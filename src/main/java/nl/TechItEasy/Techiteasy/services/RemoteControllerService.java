package nl.TechItEasy.Techiteasy.services;

import nl.TechItEasy.Techiteasy.dtos.RemoteControllerInputDto;
import nl.TechItEasy.Techiteasy.dtos.RemoteControllerOutputDto;
import nl.TechItEasy.Techiteasy.dtos.TelevisionInputDto;
import nl.TechItEasy.Techiteasy.exceptions.RecordNotFoundException;
import nl.TechItEasy.Techiteasy.models.RemoteController;
import nl.TechItEasy.Techiteasy.models.Television;
import nl.TechItEasy.Techiteasy.repositories.RemoteControllerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RemoteControllerService {

    private final RemoteControllerRepository remoteControllerRepository;

    public RemoteControllerService(RemoteControllerRepository remoteControllerRepository) {
        this.remoteControllerRepository = remoteControllerRepository;
    }


    public RemoteController transferInputDtoToRemoteController(RemoteControllerInputDto remoteControllerInputDto) {

        RemoteController newRemoteController = new RemoteController();

        newRemoteController.setCompatible_with(remoteControllerInputDto.compatible_with);
        newRemoteController.setBattery_type(remoteControllerInputDto.battery_type);
        newRemoteController.setName(remoteControllerInputDto.name);
        newRemoteController.setPrice(remoteControllerInputDto.price);
        newRemoteController.setBrand(remoteControllerInputDto.brand);
        newRemoteController.setOriginal_stock(remoteControllerInputDto.original_stock);

        return remoteControllerRepository.save(newRemoteController);
    }

    public RemoteControllerOutputDto transferRemoteControllerToOutputDto(RemoteController remoteController) {

        RemoteControllerOutputDto remoteControllerOutputDto = new RemoteControllerOutputDto();

        remoteControllerOutputDto.setCompatibleWith(remoteController.getCompatible_with());
        remoteControllerOutputDto.setBatteryType(remoteController.getBattery_type());
        remoteControllerOutputDto.setName(remoteController.getName());
        remoteControllerOutputDto.setPrice(remoteController.getPrice());
        remoteControllerOutputDto.setBrand(remoteController.getBrand());
        remoteControllerOutputDto.setOriginalStock(remoteController.getOriginal_stock());

        return remoteControllerOutputDto;
    }

    // Functie voor getMapping alle RemoteControllers.
    public List<RemoteControllerOutputDto> getAllRemoteControllers() {
        List<RemoteController> optionalRemoteController = remoteControllerRepository.findAll();
        List<RemoteControllerOutputDto> RemoteControllerOutputDtoList = new ArrayList<>();
        // outputDto.
        if (optionalRemoteController.isEmpty()) {
            throw new RecordNotFoundException("Record not found!");
        } else {
            for (RemoteController remoteController : optionalRemoteController) {
                RemoteControllerOutputDto remoteControllerOutputDto = transferRemoteControllerToOutputDto(remoteController);

                RemoteControllerOutputDtoList.add(remoteControllerOutputDto);
            }
        }
        return RemoteControllerOutputDtoList;
    }

    // Functie voor getMapping RemoteControllerController.
    public RemoteControllerOutputDto getRemoteController(int id) {
        Optional<RemoteController> requestedRemoteController = remoteControllerRepository.findById(id);
        if (requestedRemoteController.isEmpty()) {
            throw new RecordNotFoundException("Record not found!");
        } else {
            return transferRemoteControllerToOutputDto(requestedRemoteController.get());
        }
    }

    // Functie voor deleteMapping remoteController.
    public void deleteRemoteController(int id) {
        Optional<RemoteController> optionalRemoteController = remoteControllerRepository.findById(id);

        if (optionalRemoteController.isEmpty()) {
            throw new RecordNotFoundException("Television already removed or doesn't exist!");
            // throw exception.
        } else {
                RemoteController remoteControllerObj = optionalRemoteController.get();
                remoteControllerRepository.delete(remoteControllerObj);
        }
    }

    // Functie voor PostMapping RemoteControllerController.
    public RemoteController createRemoteController(RemoteControllerInputDto remoteControllerInputDto) {
        RemoteController newRemoteController = transferInputDtoToRemoteController(remoteControllerInputDto);

        return remoteControllerRepository.save(newRemoteController);
    }
}
