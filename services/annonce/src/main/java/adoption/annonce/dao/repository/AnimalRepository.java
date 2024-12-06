package adoption.annonce.dao.repository;

import adoption.annonce.dao.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
