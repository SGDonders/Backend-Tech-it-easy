package nl.TechItEasy.Techiteasy.repositories;

import nl.TechItEasy.Techiteasy.models.RemoteController;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RemoteControllerRepository extends JpaRepository <RemoteController, Integer>{
    Optional<RemoteController> findById(int id);
}
