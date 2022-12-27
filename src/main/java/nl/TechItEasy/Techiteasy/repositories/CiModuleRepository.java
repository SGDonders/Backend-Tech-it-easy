package nl.TechItEasy.Techiteasy.repositories;

import nl.TechItEasy.Techiteasy.models.CiModule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CiModuleRepository extends JpaRepository<CiModule, Integer> {
    Optional<CiModule> findById(int id);
}
