package nl.TechItEasy.Techiteasy.Controllers;

import nl.TechItEasy.Techiteasy.Exceptions.RecordNotFoundException;
import nl.TechItEasy.Techiteasy.Models.Television;
import nl.TechItEasy.Techiteasy.Repositories.TelevisonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisonRepository televisionRepository;

    public TelevisionController(TelevisonRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    @GetMapping("")
    public ResponseEntity<Object> getAllTelevisions() {
        return ResponseEntity.ok(televisionRepository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getTelevision(@PathVariable int id) {
        return ResponseEntity.ok(televisionRepository.findById(id));
    }

    @PostMapping("")
    public ResponseEntity<Object> postTelevision(@RequestBody Television television) {
        Television savedTelevision = televisionRepository.save(television);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/televisions/" + savedTelevision.getId()).toUriString());

        return ResponseEntity.created(uri).body(television);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable int id) {
        Optional<Television> television = televisionRepository.findById(id);
        if (television.isEmpty()) {
            return new ResponseEntity<>(
                    "Television already removed or doesn't exist!", HttpStatus.NOT_FOUND);
        } else {
            Television televisionObj = television.get();
            televisionRepository.delete(televisionObj);

            return ResponseEntity.ok("Television removed!");
        }
    }

    @PutMapping
    public Television updateTelevision(@RequestBody Television television){
        Optional<Television> currentTv = televisionRepository.findById(television.getId());
        if (currentTv.isPresent()){
            televisionRepository.save(television);
            return currentTv.get();
        } else {
            throw new RecordNotFoundException();
        }
    }

    @PatchMapping("{id}")
    public ResponseEntity<Object> modifyTelevisionPrice(@PathVariable int id, @RequestBody Television television) {
        Optional<Television> optionalTelevisions = televisionRepository.findById(id);
        if (optionalTelevisions.isPresent()) {
            Television patchedTelevision = optionalTelevisions.get();
            patchedTelevision.setPrice(television.getPrice());
            televisionRepository.save(patchedTelevision);
            return ResponseEntity.ok("patched update" + patchedTelevision);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
