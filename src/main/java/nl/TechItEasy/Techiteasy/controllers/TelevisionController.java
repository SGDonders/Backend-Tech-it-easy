package nl.TechItEasy.Techiteasy.controllers;

import nl.TechItEasy.Techiteasy.Utils;
import nl.TechItEasy.Techiteasy.dtos.TelevisionInputDto;
import nl.TechItEasy.Techiteasy.dtos.TelevisionOutputDto;
import nl.TechItEasy.Techiteasy.models.Television;
import nl.TechItEasy.Techiteasy.services.TelevisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController // Annotatie voor RestController
@RequestMapping("/televisions") // Annotatie voor path
public class TelevisionController {
    // Constructor injection.
    private final TelevisionService televisionService;
    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }

    // GetMapping request alle televisie's.
    @GetMapping("")
    public ResponseEntity<List<TelevisionOutputDto>> getAllTelevisions() { // Slaat alle tv's op in lijst met outputDto's.
        return ResponseEntity.ok(televisionService.getAllTelevision()); // Krijgt lijst me alle outputDto's
    }

    // GetMapping request voor één televisie.
    @GetMapping("{id}")
    public ResponseEntity<TelevisionOutputDto> getTelevision(@PathVariable int id) {
        return ResponseEntity.ok(televisionService.getTelevision(id));
    }


    // PostMapping request van een televisie.
    @PostMapping("")                            // @Valid Annotation indien condities ingesteld bij Dto's
    public ResponseEntity<Object> createTelevision(@Valid @RequestBody TelevisionInputDto televisionInputDto, BindingResult bindingResult) { // Verwacht een

        Utils.reportErrors(bindingResult);

        Television savedTelevision = televisionService.createTelevision(televisionInputDto);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath
                ().path("/televisions/" + savedTelevision.getId()).toUriString());

        return ResponseEntity.created(uri).body(savedTelevision);
    }

    // PutMapping request van een televisie.
    @PutMapping("/{id}")                        // Verwacht een id en een inputDTO
    public ResponseEntity<Object> updateTelevision(@PathVariable int id, @RequestBody TelevisionInputDto televisionInputDto){
        TelevisionOutputDto televisionOutputDto = televisionService.updateTelevision(id, televisionInputDto);
        return ResponseEntity.ok().body(televisionOutputDto);                        // Slaat een inputDto op in een
        // Returned een outputDto                                                    // outputDto.
    }

    // DeleteMapping request.
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTelevision(@PathVariable int id) {
        televisionService.deleteTelevision(id); //
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{tvId}/remotecontrollers/{remoteId}")
    public ResponseEntity<Object> assignRemoteControllerToTelevision(
            @PathVariable Integer tvId, @PathVariable Integer remoteId) {
        televisionService.assignRemoteControllerToTelevision(tvId, remoteId);
        return ResponseEntity.ok().body("RemoteController linked to television!");
    }

}






