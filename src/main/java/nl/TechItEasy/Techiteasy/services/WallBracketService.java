package nl.TechItEasy.Techiteasy.services;

import nl.TechItEasy.Techiteasy.dtos.TelevisionInputDto;
import nl.TechItEasy.Techiteasy.dtos.WallBracketInputDto;
import nl.TechItEasy.Techiteasy.dtos.WallBracketOutputDto;
import nl.TechItEasy.Techiteasy.exceptions.RecordNotFoundException;
import nl.TechItEasy.Techiteasy.models.Television;
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


    public WallBracket transferInputDtoToWallBracket(WallBracketInputDto wallBracketInputDto) {

        WallBracket newWallBracket = new WallBracket();

        newWallBracket.setSize(wallBracketInputDto.size);
        newWallBracket.setAdjustable(wallBracketInputDto.adjustable);
        newWallBracket.setName(wallBracketInputDto.name);
        newWallBracket.setPrice(wallBracketInputDto.price);

        return wallBracketRepository.save(newWallBracket);
    }

    public WallBracketOutputDto transferWallBracketToOutputDto(WallBracket wallBracket) {

        WallBracketOutputDto wallBracketOutputDto = new WallBracketOutputDto();

        wallBracketOutputDto.setSize(wallBracket.getSize());
        wallBracketOutputDto.setAdjustable(wallBracket.getAdjustable());
        wallBracketOutputDto.setName(wallBracket.getName());
        wallBracketOutputDto.setPrice(wallBracket.getPrice());

        return wallBracketOutputDto;
    }


    // Functie voor GetMapping één wallBracket.
    public WallBracketOutputDto getWallBracket(int id) {
        Optional<WallBracket> requestedWallBracket = wallBracketRepository.findById(id);
        if (requestedWallBracket.isEmpty()) {
            throw new RecordNotFoundException("Record not found!");
        } else {
            return transferWallBracketToOutputDto(requestedWallBracket.get());
        }
    }

    // Functie voor GetMapping van alle wallBrackets.
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

    //Functie voor deleteMapping WallBracket
    public void deleteWallBracket(int id) {
        Optional<WallBracket> optionalWallBracket = wallBracketRepository.findById(id);
        // optional tv.
        if (optionalWallBracket.isEmpty()) {
            throw new RecordNotFoundException("Television already removed or doesn't exist!");
            // throw exception.
        } else {
            WallBracket wallBracketObj = optionalWallBracket.get();
            // er een tv van.
            wallBracketRepository.delete(wallBracketObj);
        }
    }

    // Functie voor PostMapping televisie
    public WallBracket createWallBracket(WallBracketInputDto wallBracketInputDto) {
        WallBracket newWallBracket = transferInputDtoToWallBracket(wallBracketInputDto);

        return wallBracketRepository.save(newWallBracket);
    }
}



