package nl.TechItEasy.Techiteasy.controllers;

import nl.TechItEasy.Techiteasy.utils.Utils;
import nl.TechItEasy.Techiteasy.dtos.inputDtos.RemoteControllerInputDto;
import nl.TechItEasy.Techiteasy.dtos.outputDtos.RemoteControllerOutputDto;
import nl.TechItEasy.Techiteasy.models.RemoteController;
import nl.TechItEasy.Techiteasy.services.RemoteControllerService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.xml.bind.ValidationException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/remotecontollers")
public class RemoteControllerController {

    private final RemoteControllerService remoteControllerService;
    public RemoteControllerController(RemoteControllerService remoteControllerService) {
        this.remoteControllerService = remoteControllerService;
    }


    // GetMapping request voor één remoteController
    @GetMapping("{id}")
    public ResponseEntity<RemoteControllerOutputDto> getRemoteController(@PathVariable int id) {
        return ResponseEntity.ok(remoteControllerService.getRemoteController(id));
    }


    // GetMapping request voor alle remoteControllers.
    @GetMapping("")
    public ResponseEntity<List<RemoteControllerOutputDto>> getAllRemoteController() {
        return ResponseEntity.ok(remoteControllerService.getAllRemoteControllers());
    }


    // DeleteMapping request voor remoteController.
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRemoteController(@PathVariable int id) {
        remoteControllerService.deleteRemoteController(id); //
        return ResponseEntity.noContent().build();
    }


    // PostMapping request voor remoteController.
    @PostMapping("")
    public ResponseEntity<Object> createRemoteController(@Valid @RequestBody RemoteControllerInputDto remoteControllerInputDto, BindingResult bindingResult) throws ValidationException {

        Utils.reportErrors(bindingResult);

        RemoteController savedRemoteControllerController = remoteControllerService.createRemoteController(remoteControllerInputDto);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath
                ().path("/RemoteController/" + savedRemoteControllerController.getId()).toUriString());

        return ResponseEntity.created(uri).body(savedRemoteControllerController);
    }


    // PutMapping request voor een remote-controller.
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateRemoteController(@PathVariable int id, @RequestBody RemoteControllerInputDto remoteControllerInputDto) {
        RemoteControllerOutputDto remoteControllerOutputDto = remoteControllerService.updateRemoteController(id, remoteControllerInputDto);
        return ResponseEntity.ok().body(remoteControllerOutputDto);
    }
}