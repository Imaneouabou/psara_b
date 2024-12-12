package adoption.annonce.dao.repository;

import adoption.annonce.dao.entities.AnimalAnnonce;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AnimalAnnonceRepository extends JpaRepository<AnimalAnnonce, Long> {
}
