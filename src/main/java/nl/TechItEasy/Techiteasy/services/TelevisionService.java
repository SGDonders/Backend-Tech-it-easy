package nl.TechItEasy.Techiteasy.services;

import nl.TechItEasy.Techiteasy.dtos.TelevisionOutputDto;
import nl.TechItEasy.Techiteasy.dtos.TelevisionInputDto;
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
        newTelevision.setType(televisionInputDto.type);
        newTelevision.setName(televisionInputDto.name);
        newTelevision.setBrand(televisionInputDto.brand);
        newTelevision.setPrice(televisionInputDto.price);
        newTelevision.setAvailableSize(televisionInputDto.availableSize);
        newTelevision.setRefreshRate(televisionInputDto.refreshRate);
        newTelevision.setScreenType(televisionInputDto.screenType);
        newTelevision.setScreenQuality(televisionInputDto.screenQuality);
        newTelevision.setSmartTv(televisionInputDto.smartTv);
        newTelevision.setWifi(televisionInputDto.wifi);
        newTelevision.setSpeech(televisionInputDto.speech);
        newTelevision.setHDR(televisionInputDto.HDR);
        newTelevision.setBluetooth(televisionInputDto.bluetooth);
        newTelevision.setAmbiLight(televisionInputDto.ambiLight);
        newTelevision.setOriginalStock(televisionInputDto.originalStock);
        newTelevision.setSold(televisionInputDto.sold);
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
        televisionOutputDto.setAvailableSize(television.getAvailableSize());
        televisionOutputDto.setRefreshRate(television.getRefreshRate());
        televisionOutputDto.setScreenType(television.getScreenType());
        televisionOutputDto.setScreenQuality(television.getScreenQuality());
        televisionOutputDto.setSmartTv(television.isWifi());
        televisionOutputDto.setWifi(television.isWifi());
        televisionOutputDto.setVoiceControl(television.isVoiceControl());
        televisionOutputDto.setHDR(television.isHDR());
        televisionOutputDto.setBluetooth(television.isBluetooth());
        televisionOutputDto.setAmbiLight(television.isAmbiLight());
        televisionOutputDto.setOriginalStock(television.getOriginalStock());
        televisionOutputDto.setSold(television.getSold());
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
            for (Television tv : optionalTelevisions) { // uit de lijst van optional tv's één voor één de tv's halen.
                TelevisionOutputDto televisionOutputDto = transferTelevisionToOutputDto(tv); // Mapping functie om tv's
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
            if(televisionInputDto.type != null) {
                televisionUpdate.setType(televisionInputDto.getType());
            }
            if(televisionInputDto.brand != null) {
                televisionUpdate.setBrand(televisionInputDto.getBrand());
            }
            if(televisionInputDto.name != null) {
                televisionUpdate.setName(televisionInputDto.getName());
            }
            if(televisionInputDto.price != 0) {
                televisionUpdate.setPrice(televisionInputDto.getPrice());
            }
            if(televisionInputDto.availableSize != 0) {
                televisionUpdate.setAvailableSize(televisionInputDto.getAvailableSize());
            }
            if(televisionInputDto.refreshRate != 0) {
                televisionUpdate.setRefreshRate(televisionInputDto.getRefreshRate());
            }
            if(televisionInputDto.screenType != 0) {
                televisionUpdate.setScreenType(televisionInputDto.getScreenType());
            }
            if(televisionInputDto.screenQuality != 0) {
                televisionUpdate.setScreenQuality(televisionInputDto.getScreenQuality());
            }
            if(televisionInputDto.smartTv != null ) {
                televisionUpdate.setSmartTv(televisionInputDto.isSmartTv());
            }
            if(televisionInputDto.wifi != null) {
                televisionUpdate.setWifi(televisionInputDto.isWifi());
            }
            if(televisionInputDto.speech != null) {
                televisionUpdate.setSpeech(televisionInputDto.isSpeech());
            }
            if(televisionInputDto.bluetooth != null) {
                televisionUpdate.setBluetooth(televisionInputDto.isBluetooth());
            }
            if(televisionInputDto.ambiLight != null) {
                televisionUpdate.setAmbiLight(televisionInputDto.isAmbiLight());
            }
            if(televisionInputDto.originalStock != null) {
                televisionUpdate.setOriginalStock(televisionInputDto.getOriginalStock());
            }
            if(televisionInputDto.sold != null) {
                televisionUpdate.setSold(televisionInputDto.getSold());
            }
            // Slaat de geüpdatete televisie op in de database
            Television updatedTelevision = televisionRepository.save(televisionUpdate);
            return transferTelevisionToOutputDto(updatedTelevision);  // Returned de geüpdatete televisie
        } else {                                                      // als televisionOutputDto.
            throw new RecordNotFoundException("Television with " + id + " not found!");
            // Throw exception indien televisie niet aanwezig is.
        }
    }

    public void assignRemoteControllerToTelevision(Integer tvId, Integer remoteId) {

        Optional<Television> optionalTelevision = televisionRepository.findById(tvId);
        Optional<RemoteController> optionalRemoteControl = remoteControllerRepository.findById(remoteId);
        if (optionalTelevision.isPresent() && optionalRemoteControl.isPresent()) {
            Television television = optionalTelevision.get();
            RemoteController remoteControl = optionalRemoteControl.get();
            television.setRemoteController(remoteControl);
            televisionRepository.save(television);
        } else {
            throw new RecordNotFoundException("No television/remote-controller combination found");
        }
    }
}















