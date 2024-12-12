package adoption.usermanagementservice.dao.repositories;

import adoption.usermanagementservice.dao.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Optional<Utilisateur> findByCin(String cin);
}
