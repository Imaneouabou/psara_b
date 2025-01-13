package adoption.animalannonce.dao.repository;

import adoption.animalannonce.dao.entities.AnimalAnnonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface AnimalAnnonceRepository extends JpaRepository<AnimalAnnonce, Long> {
    List<AnimalAnnonce> findByUserCreation(Long userCreation);
}
