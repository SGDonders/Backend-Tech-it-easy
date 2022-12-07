package nl.TechItEasy.Techiteasy.services;


import nl.TechItEasy.Techiteasy.dtos.CiModuleInputDto;
import nl.TechItEasy.Techiteasy.dtos.CiModuleOutputDto;
import nl.TechItEasy.Techiteasy.dtos.TelevisionInputDto;
import nl.TechItEasy.Techiteasy.dtos.TelevisionOutputDto;
import nl.TechItEasy.Techiteasy.exceptions.RecordNotFoundException;
import nl.TechItEasy.Techiteasy.models.CiModule;
import nl.TechItEasy.Techiteasy.models.Television;
import nl.TechItEasy.Techiteasy.repositories.CiModuleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CiModuleService {

    private final CiModuleRepository ciModuleRepository;

    public CiModuleService(CiModuleRepository ciModuleRepository) {
        this.ciModuleRepository = ciModuleRepository;
    }


    // Wrapper functie
    public CiModule transferInputDtoToCiModule(CiModuleInputDto ciModuleInputDto) {

        CiModule newCiModule = new CiModule();

        newCiModule.setType(ciModuleInputDto.type);
        newCiModule.setName(ciModuleInputDto.name);
        newCiModule.setPrice(ciModuleInputDto.price);

        return ciModuleRepository.save(newCiModule);
    }

    // Wrapper Functie
    public CiModuleOutputDto transferCiModuleToOutputDto(CiModule ciModule) {

        CiModuleOutputDto ciModuleOutputDto = new CiModuleOutputDto();

        ciModuleOutputDto.setType(ciModule.getType());
        ciModuleOutputDto.setName(ciModule.getName());
        ciModuleOutputDto.setPrice(ciModule.getPrice());

        return ciModuleOutputDto;
    }

    // Functie voor GetMapping van alle CiModules.
    public List<CiModuleOutputDto> getAllCiModules() {
        List<CiModule> optionalCiModule = ciModuleRepository.findAll();
        List<CiModuleOutputDto> CiModuleOutputDtoList = new ArrayList<>();

        if (optionalCiModule.isEmpty()) {
            throw new RecordNotFoundException("Record not found!");
        } else {
            for (CiModule ciModule : optionalCiModule) {
                CiModuleOutputDto ciModuleOutputDto = transferCiModuleToOutputDto(ciModule);

                CiModuleOutputDtoList.add(ciModuleOutputDto);

            }
        }
        return CiModuleOutputDtoList;
    }

    // Functie voor getMapping één CiModule.
    public CiModuleOutputDto getCiModule(int id) {
        Optional<CiModule> requestedCiModule = ciModuleRepository.findById(id);
        if (requestedCiModule.isEmpty()) {
            throw new RecordNotFoundException("Record not found!");
        } else {
            return transferCiModuleToOutputDto(requestedCiModule.get());
        }
    }

    // Functie voor deleteMapping.
    public void deleteCiModule(int id) {
        Optional<CiModule> optionalCiModule = ciModuleRepository.findById(id);
        // optional tv.
        if (optionalCiModule.isEmpty()) {
            throw new RecordNotFoundException("Television already removed or doesn't exist!");
            // throw exception.
        } else {
            CiModule CiModuleObj = optionalCiModule.get();
            // er een tv van.
            ciModuleRepository.delete(CiModuleObj);
        }
    }

    // Functie voor PostMapping
    public CiModule createCiModule(CiModuleInputDto ciModuleInputDto) {
        CiModule newCiModule = transferInputDtoToCiModule(ciModuleInputDto);
        return ciModuleRepository.save(newCiModule);
    }
}