package nl.TechItEasy.Techiteasy.services;

import nl.TechItEasy.Techiteasy.dtos.inputDtos.RemoteControllerInputDto;
import nl.TechItEasy.Techiteasy.dtos.outputDtos.RemoteControllerOutputDto;
import nl.TechItEasy.Techiteasy.exceptions.RecordNotFoundException;
import nl.TechItEasy.Techiteasy.models.RemoteController;
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


    // Wrapper functie.
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

    // Wrapper functie.
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

    // Functie voor GetMapping.
    public List<RemoteControllerOutputDto> getAllRemoteControllers() {
        List<RemoteController> optionalRemoteController = remoteControllerRepository.findAll();
        List<RemoteControllerOutputDto> RemoteControllerOutputDtoList = new ArrayList<>();

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

    // Functie voor GetMapping.
    public RemoteControllerOutputDto getRemoteController(int id) {
        Optional<RemoteController> requestedRemoteController = remoteControllerRepository.findById(id);

        if (requestedRemoteController.isEmpty()) {
            throw new RecordNotFoundException("Record not found!");
        } else {
            return transferRemoteControllerToOutputDto(requestedRemoteController.get());
        }
    }


    // Functie voor DeleteMapping.
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


    // Functie voor PostMapping.
    public RemoteController createRemoteController(RemoteControllerInputDto remoteControllerInputDto) {
        RemoteController newRemoteController = transferInputDtoToRemoteController(remoteControllerInputDto);

        return remoteControllerRepository.save(newRemoteController);
    }


    // Functie voor PutMapping.
    public RemoteControllerOutputDto updateRemoteController(int id, RemoteControllerInputDto remoteControllerInputDto) {

        Optional<RemoteController> optionalRemoteController = remoteControllerRepository.findById(id);

        if (optionalRemoteController.isPresent()) {

            RemoteController remoteControllerUpdate = optionalRemoteController.get();

            if (remoteControllerInputDto.getCompatible_with() != null) {
                remoteControllerUpdate.setCompatible_with(remoteControllerInputDto.getCompatible_with());
            }
            if (remoteControllerInputDto.getBattery_type() != null) {
                remoteControllerUpdate.setBattery_type(remoteControllerInputDto.getBattery_type());
            }
            if (remoteControllerInputDto.getName() != null) {
                remoteControllerUpdate.setName(remoteControllerInputDto.getName());
            }
            if (remoteControllerInputDto.getBrand() != null) {
                remoteControllerUpdate.setBrand(remoteControllerInputDto.getBrand());
            }
            if (remoteControllerInputDto.getPrice() != 0) {
                remoteControllerUpdate.setPrice(remoteControllerInputDto.getPrice());
            }
            if (remoteControllerInputDto.getOriginal_stock() != 0) {
                remoteControllerUpdate.setOriginal_stock(remoteControllerInputDto.getOriginal_stock());
            }

            RemoteController updatedRemoteController = remoteControllerRepository.save(remoteControllerUpdate);
            return transferRemoteControllerToOutputDto(updatedRemoteController);
        } else {
            throw new RecordNotFoundException("RemoteController not found!");

        }
    }
}
