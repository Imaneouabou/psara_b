package adoption.animalannonce.repository;

import adoption.animalannonce.entities.AnimalAnnonce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalAnnonceRepository extends JpaRepository<AnimalAnnonce, Long> {
}
