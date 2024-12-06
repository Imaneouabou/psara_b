package adoption.annonce.dao.repository;

import adoption.annonce.dao.entities.Photos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotosRepository extends JpaRepository<Photos, Long> {
}
