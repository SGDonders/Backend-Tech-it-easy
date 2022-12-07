package nl.TechItEasy.Techiteasy.repositories;

import nl.TechItEasy.Techiteasy.models.Television;
import nl.TechItEasy.Techiteasy.models.WallBracket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WallBracketRepository extends JpaRepository <WallBracket, Integer> {
    Optional<WallBracket> findById(int id);
}
