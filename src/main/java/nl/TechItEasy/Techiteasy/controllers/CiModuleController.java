package nl.TechItEasy.Techiteasy.controllers;

import nl.TechItEasy.Techiteasy.Utils;
import nl.TechItEasy.Techiteasy.dtos.CiModuleInputDto;
import nl.TechItEasy.Techiteasy.dtos.CiModuleOutputDto;
import nl.TechItEasy.Techiteasy.dtos.RemoteControllerInputDto;
import nl.TechItEasy.Techiteasy.dtos.RemoteControllerOutputDto;
import nl.TechItEasy.Techiteasy.models.CiModule;
import nl.TechItEasy.Techiteasy.services.CiModuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cimodules")
public class CiModuleController {

    private final CiModuleService ciModuleService;
    public CiModuleController(CiModuleService ciModuleService) {
        this.ciModuleService = ciModuleService;
    }


    // GetMapping request alle CiModules.
    @GetMapping("")
    public ResponseEntity<List<CiModuleOutputDto>> getAllCiModules() {
        return ResponseEntity.ok(ciModuleService.getAllCiModules());
    }


    // GetMapping request voor één CiModule.
    @GetMapping("{id}")
    public ResponseEntity<CiModuleOutputDto> getCiModule(@PathVariable int id) {
        return ResponseEntity.ok(ciModuleService.getCiModule(id));
    }


    // DeleteMapping request voor een CiModule.
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCiModule(@PathVariable int id) {
        ciModuleService.deleteCiModule(id); //
        return ResponseEntity.noContent().build();
    }


    // PostMapping request voor een CiModule.
    @PostMapping("")
    public ResponseEntity<Object> createCiModule(@Valid @RequestBody CiModuleInputDto ciModuleInputDto,
                                                 BindingResult bindingResult) {
        Utils.reportErrors(bindingResult);

        CiModule savedCiModule = ciModuleService.createCiModule(ciModuleInputDto);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath
                ().path("/CiModule/" + savedCiModule.getId()).toUriString());

        return ResponseEntity.created(uri).body(savedCiModule);
    }


    // PutMapping voor een CiModule.
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCiModule(@PathVariable int id, @RequestBody CiModuleInputDto ciModuleInputDto) {
        CiModuleOutputDto ciModuleOutputDto = ciModuleService.updateCiModule(id, ciModuleInputDto);
        return ResponseEntity.ok().body(ciModuleOutputDto);
    }
}



















