package nl.TechItEasy.Techiteasy.controllers;

import nl.TechItEasy.Techiteasy.utils.Utils;
import nl.TechItEasy.Techiteasy.dtos.inputDtos.WallBracketInputDto;
import nl.TechItEasy.Techiteasy.dtos.outputDtos.WallBracketOutputDto;
import nl.TechItEasy.Techiteasy.models.WallBracket;
import nl.TechItEasy.Techiteasy.services.WallBracketService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.xml.bind.ValidationException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/wallbrackets")
public class WallBracketController {

    private final WallBracketService wallBracketService;

    public WallBracketController(WallBracketService wallBracketService) {
        this.wallBracketService = wallBracketService;
    }

    // GetMapping request alle wallBrackets.
    @GetMapping("")
    public ResponseEntity<List<WallBracketOutputDto>> getAllWallBrackets() {
        return ResponseEntity.ok(wallBracketService.getAllWallBrackets());
    }

    // GetMapping request voor één wallBracket.
    @GetMapping("{id}")
    public ResponseEntity<WallBracketOutputDto> getWallBracket(@PathVariable int id) {
        return ResponseEntity.ok(wallBracketService.getWallBracket(id));
    }

    // DeleteMapping request voor een wallBracket.
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWallBracket(@PathVariable int id) {
        wallBracketService.deleteWallBracket(id); //
        return ResponseEntity.noContent().build();
    }

    // PostMapping request voor een wallBracket.
    @PostMapping("")
    public ResponseEntity<Object> createWallBracket(@Valid @RequestBody WallBracketInputDto wallBracketInputDto, BindingResult bindingResult) throws ValidationException {

        Utils.reportErrors(bindingResult);

        WallBracket savedWallBracket = wallBracketService.createWallBracket(wallBracketInputDto);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath
                ().path("/WallBracket/" + savedWallBracket.getId()).toUriString());

        return ResponseEntity.created(uri).body(savedWallBracket);
    }

    // PutMapping request voor een wallBracket.
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateWallBracket(@PathVariable int id, @RequestBody WallBracketInputDto wallBracketInputDto) {
        WallBracketOutputDto wallBracketOutputDto = wallBracketService.updateWallBracket(id, wallBracketInputDto);
        return ResponseEntity.ok().body(wallBracketOutputDto);
    }

}
