package adoption.animalannonce.dao.repository;

import adoption.animalannonce.dao.entities.AvisComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvisCommentRepository extends JpaRepository<AvisComment, Long> {
    List<AvisComment> findByAdoptionId(Long adoptionId);
    long countByAdoptionId(Long adoptionId);
}
