package adoption.animalannonce.dao.repository;

import adoption.animalannonce.dao.entities.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface AdoptionRepository extends JpaRepository<Adoption, Long> {
    List<Adoption> findByIdUser(Long idUser);
}
