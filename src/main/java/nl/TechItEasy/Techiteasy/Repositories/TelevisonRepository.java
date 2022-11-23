package nl.TechItEasy.Techiteasy.Repositories;

import nl.TechItEasy.Techiteasy.Models.Television;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TelevisonRepository extends JpaRepository<Television, Integer> {
    Optional <Television> findById(int id);
    Optional <Television> findByBrand(String brand);
}
