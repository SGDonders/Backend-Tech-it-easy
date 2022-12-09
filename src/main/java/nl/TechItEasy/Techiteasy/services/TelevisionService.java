package nl.TechItEasy.Techiteasy.services;

import nl.TechItEasy.Techiteasy.dtos.outputDtos.TelevisionOutputDto;
import nl.TechItEasy.Techiteasy.dtos.inputDtos.TelevisionInputDto;
import nl.TechItEasy.Techiteasy.exceptions.RecordNotFoundException;
import nl.TechItEasy.Techiteasy.models.RemoteController;
import nl.TechItEasy.Techiteasy.models.Television;
import nl.TechItEasy.Techiteasy.repositories.RemoteControllerRepository;
import nl.TechItEasy.Techiteasy.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service // Annotatie voor service layer.
public class TelevisionService {
    private final TelevisionRepository televisionRepository;
    private final RemoteControllerRepository remoteControllerRepository;

    // Constructor injection.
    public TelevisionService(TelevisionRepository televisionRepository, RemoteControllerRepository remoteControllerRepository) {
        this.televisionRepository = televisionRepository;
        this.remoteControllerRepository = remoteControllerRepository;
    }


    // Wrapper functie om dto naar televisie te mappen (wordt gebruikt door de client zijde via controller).
    public Television transferInputDtoToTelevision(TelevisionInputDto televisionInputDto) {
        // Nieuwe televisie aanmaken
        Television newTelevision = new Television();
        // Nieuwe televisie de variabelen meegeven van de inputDto.
        newTelevision.setType(televisionInputDto.getType());
        newTelevision.setName(televisionInputDto.getName());
        newTelevision.setBrand(televisionInputDto.getBrand());
        newTelevision.setPrice(televisionInputDto.getPrice());
        newTelevision.setAvailable_size(televisionInputDto.getAvailable_size());
        newTelevision.setRefresh_rate(televisionInputDto.getRefresh_rate());
        newTelevision.setScreen_type(televisionInputDto.getScreen_type());
        newTelevision.setScreen_quality(televisionInputDto.getScreen_quality());
        newTelevision.setSmart_tv(televisionInputDto.isSmart_tv());
        newTelevision.setWifi(televisionInputDto.isWifi());
        newTelevision.setHdr(televisionInputDto.isHdr());
        newTelevision.setBluetooth(televisionInputDto.isBluetooth());
        newTelevision.setAmbi_light(televisionInputDto.isAmbi_light());
        newTelevision.setOriginal_stock(televisionInputDto.getOriginal_stock());
        newTelevision.setSold(televisionInputDto.getSold());
        newTelevision.setRemoteController(televisionInputDto.getRemoteController());
        // nieuwe televisie opslaan in database.
        return televisionRepository.save(newTelevision);
    }


    // Wrapper functie om televisie naar dto te mappen (wordt gebruikt door de database zijde).
    public TelevisionOutputDto transferTelevisionToOutputDto(Television television) {
        // Nieuwe outputDto aanmaken.
        TelevisionOutputDto televisionOutputDto = new TelevisionOutputDto();
        // Nieuwe outputDto variabelen meegeven van de televisie.
        televisionOutputDto.setType(television.getType());
        televisionOutputDto.setBrand(television.getBrand());
        televisionOutputDto.setName(television.getName());
        televisionOutputDto.setPrice(television.getPrice());
        televisionOutputDto.setAvailable_size(television.getAvailable_size());
        televisionOutputDto.setRefresh_rate(television.getRefresh_rate());
        televisionOutputDto.setScreen_type(television.getScreen_type());
        televisionOutputDto.setScreen_quality(television.getScreen_quality());
        televisionOutputDto.setSmart_tv(television.isWifi());
        televisionOutputDto.setWifi(television.isWifi());
        televisionOutputDto.setVoice_control(television.isVoice_control());
        televisionOutputDto.setHdr(television.isHdr());
        televisionOutputDto.setBluetooth(television.isBluetooth());
        televisionOutputDto.setAmbi_light(television.isAmbi_light());
        televisionOutputDto.setOriginal_stock(television.getOriginal_stock());
        televisionOutputDto.setSold(television.getSold());
        televisionOutputDto.setRemoteController(television.getRemoteController());
        // Nieuw aangemaakte televisionOutputDto terug geven.
        return televisionOutputDto;
    }


    // Functie voor GetMapping één televisie
    public TelevisionOutputDto getTelevision(int id) {
        Optional<Television> requestedTv = televisionRepository.findById(id); // Haalt tv uit database.
        if (requestedTv.isEmpty()) { // Check of requested tv leeg is.
            throw new RecordNotFoundException("Record not found!"); // Indien leeg throw exception.
        } else {
            return transferTelevisionToOutputDto(requestedTv.get()); // Inline transfer tv, returned outputDto.
        }
    }


    // Functie voor GetMapping van alle tv's.
    public List<TelevisionOutputDto> getAllTelevision() {
        List<Television> optionalTelevisions = televisionRepository.findAll(); // Alle tv objecten opslaan in een lijst
        // van optionalTelevisions.
        List<TelevisionOutputDto> tvOutputDtoList = new ArrayList<>(); // Nieuwe arraylist aanmaken om te vullen met
        // outputDto.
        if (optionalTelevisions.isEmpty()) { // Checken of lijst leeg is.
            throw new RecordNotFoundException("Record not found!"); // Als lijst leeg is throw exception.
        } else {
            for (Television television : optionalTelevisions) { // uit de lijst van optional tv's één voor één de tv's halen.
                TelevisionOutputDto televisionOutputDto = transferTelevisionToOutputDto(television); // Mapping functie om tv's
                                                                                                     // uit optional tv's
                                                                                                     // om te zetten naar outputDto.
                tvOutputDtoList.add(televisionOutputDto); // OutputDto's
                                                          // toevoegen aan nieuwe arraylist
                                                          // met de naam tvOutputDtoList.
            }
        }// Returned nieuwe arraylist met outputDto's terug geven
        return tvOutputDtoList;
    }


    // Functie voor deleteMapping televisie.
    public void deleteTelevision(int id) {
        Optional<Television> optionalTelevision = televisionRepository.findById(id); // Haalt tv uit de database als
                                                                                    // optional tv.
        if (optionalTelevision.isEmpty()) { // Checked of er een optional tv aanwezig is.
            throw new RecordNotFoundException("Television already removed or doesn't exist!"); // Indien niet aanwezig
                                                                                               // throw exception.
        } else {
            Television televisionObj = optionalTelevision.get(); // Indien aanwezig pak de optional televisie en maakt
                                                                 // er een tv van.
            televisionRepository.delete(televisionObj); // Delete de televisie.
        }
    }


    // Functie voor PostMapping televisie
    public Television createTelevision(TelevisionInputDto televisionInputDto) { // Functie ontvangt een inputDto
        Television newTelevision = transferInputDtoToTelevision(televisionInputDto); // Gebruik mapping functie om
                                                                                     // televisieInputDTO
                                                                                     // om te zetten naar een nieuw tv
                                                                                     // object.
        // Return slaat nieuw tv object in de database.
        return televisionRepository.save(newTelevision);
    }


    // Functie voor PutMapping televisie
    public TelevisionOutputDto updateTelevision(int id, TelevisionInputDto televisionInputDto) { // Functie ontvangt een
                                                                                                 // inputDTo.
        Optional<Television> optionalTelevision = televisionRepository.findById(id); // Haalt tv uit database.

        if (optionalTelevision.isPresent()) { // Checked of television er is.
            // Slaat de optional television op in nieuwe televisie.
            Television televisionUpdate = optionalTelevision.get();

            // If-(conditie) checked of de waarde niet null is.
            // Update de televisie met de waardes van de ontvangen inputDto.
            if(televisionInputDto.getType() != null) {
                televisionUpdate.setType(televisionInputDto.getType());
            }
            if(televisionInputDto.getBrand() != null) {
                televisionUpdate.setBrand(televisionInputDto.getBrand());
            }
            if(televisionInputDto.getName() != null) {
                televisionUpdate.setName(televisionInputDto.getName());
            }
            if(televisionInputDto.getPrice() != 0) {
                televisionUpdate.setPrice(televisionInputDto.getPrice());
            }
            if(televisionInputDto.getAvailable_size() != 0) {
                televisionUpdate.setAvailable_size(televisionInputDto.getAvailable_size());
            }
            if(televisionInputDto.getRefresh_rate() != 0) {
                televisionUpdate.setRefresh_rate(televisionInputDto.getRefresh_rate());
            }
            if(televisionInputDto.getScreen_type() != null) {
                televisionUpdate.setScreen_type(televisionInputDto.getScreen_type());
            }
            if(televisionInputDto.getScreen_quality() != null) {
                televisionUpdate.setScreen_quality(televisionInputDto.getScreen_quality());
            }

            if(televisionInputDto.getOriginal_stock() != 0) {
                televisionUpdate.setOriginal_stock(televisionInputDto.getOriginal_stock());
            }
            if(televisionInputDto.getSold() != 0) {
                televisionUpdate.setSold(televisionInputDto.getSold());
            }
            televisionUpdate.setSmart_tv(televisionInputDto.isSmart_tv());
            televisionUpdate.setWifi(televisionInputDto.isWifi());
            televisionUpdate.setBluetooth(televisionInputDto.isBluetooth());
            televisionUpdate.setAmbi_light(televisionInputDto.isAmbi_light());
            // Slaat de geüpdatete televisie op in de database
            Television updatedTelevision = televisionRepository.save(televisionUpdate);
            return transferTelevisionToOutputDto(updatedTelevision);  // Returned de geüpdatete televisie
        } else {                                                      // als televisionOutputDto.
            throw new RecordNotFoundException("Television with " + id + " not found!");
            // Throw exception indien televisie niet aanwezig is.
        }
    }


        // Functie om de remote-controller te linken met een televisie.
        public void assignRemoteToTelevision(int tvId, int remoteId) { // Functie verwachte een tvId en remoteId
        Television television = televisionRepository.findById(tvId) // Haalt televisie op uit de database en slaat het op
                                                                    // als een televisie.
                .orElseThrow(() -> new RecordNotFoundException("Tv not found!")); // Indien niet gevonden gooit een exception.

        RemoteController remoteController = remoteControllerRepository.findById(remoteId) // Haalt remote-controller uit
                                                                                          // de database en slaat het op
                                                                                          // als een remote-controller/
                .orElseThrow(() -> new RecordNotFoundException("RemoteController not found!")); // Indien niet gevonden
                                                                                                // gooit een exception.

        television.setRemoteController(remoteController); // Linked de remote-controller aan de televisie.
            televisionRepository.save(television); // Slaat de televisie op in de database.
        }
}


















