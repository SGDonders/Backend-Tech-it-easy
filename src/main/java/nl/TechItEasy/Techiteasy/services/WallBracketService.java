package nl.TechItEasy.Techiteasy.services;


import nl.TechItEasy.Techiteasy.dtos.inputDtos.WallBracketInputDto;
import nl.TechItEasy.Techiteasy.dtos.outputDtos.WallBracketOutputDto;
import nl.TechItEasy.Techiteasy.exceptions.RecordNotFoundException;
import nl.TechItEasy.Techiteasy.models.WallBracket;
import nl.TechItEasy.Techiteasy.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WallBracketService {

    private final WallBracketRepository wallBracketRepository;
    public WallBracketService(WallBracketRepository wallBracketRepository) {
        this.wallBracketRepository = wallBracketRepository;
    }


    // Wrapper functie.
    public WallBracket transferInputDtoToWallBracket(WallBracketInputDto wallBracketInputDto) {

        WallBracket newWallBracket = new WallBracket();

        newWallBracket.setSize(wallBracketInputDto.size);
        newWallBracket.setAdjustable(wallBracketInputDto.adjustable);
        newWallBracket.setName(wallBracketInputDto.name);
        newWallBracket.setPrice(wallBracketInputDto.price);

        return wallBracketRepository.save(newWallBracket);
    }


    // Wrapper functie.
    public WallBracketOutputDto transferWallBracketToOutputDto(WallBracket wallBracket) {

        WallBracketOutputDto wallBracketOutputDto = new WallBracketOutputDto();

        wallBracketOutputDto.setSize(wallBracket.getSize());
        wallBracketOutputDto.setAdjustable(wallBracket.getAdjustable());
        wallBracketOutputDto.setName(wallBracket.getName());
        wallBracketOutputDto.setPrice(wallBracket.getPrice());

        return wallBracketOutputDto;
    }


    // Functie voor GetMapping.
    public WallBracketOutputDto getWallBracket(int id) {
        Optional<WallBracket> requestedWallBracket = wallBracketRepository.findById(id);

        if (requestedWallBracket.isEmpty()) {
            throw new RecordNotFoundException("Record not found!");
        } else {
            return transferWallBracketToOutputDto(requestedWallBracket.get());
        }
    }


    // Functie voor GetMapping.
    public List<WallBracketOutputDto> getAllWallBrackets() {
        List<WallBracket> optionalWallBracket = wallBracketRepository.findAll();
        List<WallBracketOutputDto> wallBracketOutputDtoList = new ArrayList<>();

        if (optionalWallBracket.isEmpty()) {
            throw new RecordNotFoundException("Record not found!");
        } else {
            for (WallBracket wallBracket : optionalWallBracket) {
                WallBracketOutputDto wallBracketOutputDto = transferWallBracketToOutputDto(wallBracket);
                wallBracketOutputDtoList.add(wallBracketOutputDto);
            }
        }
        return wallBracketOutputDtoList;
    }


    //Functie voor deleteMapping.
    public void deleteWallBracket(int id) {
        Optional<WallBracket> optionalWallBracket = wallBracketRepository.findById(id);

        if (optionalWallBracket.isEmpty()) {
            throw new RecordNotFoundException("Television already removed or doesn't exist!");
        } else {
            WallBracket wallBracketObj = optionalWallBracket.get();
            wallBracketRepository.delete(wallBracketObj);
        }
    }


    // Functie voor PostMapping.
    public WallBracket createWallBracket(WallBracketInputDto wallBracketInputDto) {
        WallBracket newWallBracket = transferInputDtoToWallBracket(wallBracketInputDto);
        return wallBracketRepository.save(newWallBracket);
    }


    // Functie voor PutMapping.
    public WallBracketOutputDto updateWallBracket(int id, WallBracketInputDto wallBracketInputDto) {
        Optional<WallBracket> optionalWallBracket = wallBracketRepository.findById(id);

        if (optionalWallBracket.isPresent()) {

            WallBracket wallBracketUpdate = optionalWallBracket.get();

            if (wallBracketInputDto.getSize() != null) {
                wallBracketUpdate.setSize(wallBracketInputDto.getSize());
            }
            if (wallBracketInputDto.getName() != null) {
                wallBracketUpdate.setName(wallBracketInputDto.getName());
            }
            if (wallBracketInputDto.getPrice() != 0) {
                wallBracketUpdate.setPrice(wallBracketInputDto.getPrice());
            }
            wallBracketUpdate.setAdjustable(wallBracketInputDto.getAdjustable());

            WallBracket updatedWallBracket = wallBracketRepository.save(wallBracketUpdate);
            return transferWallBracketToOutputDto(updatedWallBracket);
        } else {
            throw new RecordNotFoundException("WallBracket not found!");

        }
    }
}



