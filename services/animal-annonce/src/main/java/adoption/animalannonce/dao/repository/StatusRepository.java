package adoption.animalannonce.dao.repository;

import adoption.animalannonce.dao.entities.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<StatusEntity, Long> {
}
