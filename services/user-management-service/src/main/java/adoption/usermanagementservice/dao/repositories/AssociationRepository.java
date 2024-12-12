package adoption.usermanagementservice.dao.repositories;

import adoption.usermanagementservice.dao.entities.Association;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssociationRepository extends JpaRepository<Association, Long>  {
    Optional<Association> findByNomOrganisation(String nomOrganisation);
}
