package adoption.animalannonce.dao.repository;

import adoption.animalannonce.dao.entities.AnimalAnnonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalAnnonceRepository extends JpaRepository<AnimalAnnonce, Long> {
}
