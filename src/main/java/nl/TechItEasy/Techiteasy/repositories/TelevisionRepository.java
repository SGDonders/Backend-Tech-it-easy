package nl.TechItEasy.Techiteasy.repositories;

import nl.TechItEasy.Techiteasy.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TelevisionRepository extends JpaRepository<Television, Integer> {
    Optional <Television> findById(int id);
    Optional <Television> findByBrand(String brand);
}
