package adoption.usermanagementservice.services.mappers;

import adoption.usermanagementservice.dao.entities.Utilisateur;
import adoption.usermanagementservice.services.dto.UtilisateurDto;
import org.springframework.stereotype.Component;


@Component
public class UtilisateurMapper extends UserMapper {

    private final UserMapper userMapper = new UserMapper(); // Utilisation du mapper pour User

    // Mapper pour Utilisateur -> UtilisateurDTO
    public UtilisateurDto toUtilisateurDto(Utilisateur utilisateur) {
        if (utilisateur == null) {
            return null;
        }

        UtilisateurDto utilisateurDTO = new UtilisateurDto();
        // Mapper les propriétés héritées de User
        utilisateurDTO.setId(utilisateur.getId());
        utilisateurDTO.setEmail(utilisateur.getEmail());
        utilisateurDTO.setPhone(utilisateur.getPhone());
        utilisateurDTO.setRole(utilisateur.getRole());
        utilisateurDTO.setEstVerifie(utilisateur.getEstVerifie());
        utilisateurDTO.setDateInscription(utilisateur.getDateInscription());

        // Mapper les propriétés spécifiques à Utilisateur
        utilisateurDTO.setNom(utilisateur.getNom());
        utilisateurDTO.setPrenom(utilisateur.getPrenom());
        utilisateurDTO.setCin(utilisateur.getCin());

        return utilisateurDTO;
    }

    // Mapper pour UtilisateurDTO -> Utilisateur
    public Utilisateur toUtilisateur(UtilisateurDto utilisateurDTO) {
        if (utilisateurDTO == null) {
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();
        // Mapper les propriétés héritées de User
        utilisateur.setId(utilisateurDTO.getId());
        utilisateur.setEmail(utilisateurDTO.getEmail());
        utilisateur.setPhone(utilisateurDTO.getPhone());
        utilisateur.setRole(utilisateurDTO.getRole());
        utilisateur.setEstVerifie(utilisateurDTO.getEstVerifie());
        utilisateur.setDateInscription(utilisateurDTO.getDateInscription());

        // Mapper les propriétés spécifiques à Utilisateur
        utilisateur.setNom(utilisateurDTO.getNom());
        utilisateur.setPrenom(utilisateurDTO.getPrenom());
        utilisateur.setCin(utilisateurDTO.getCin());

        return utilisateur;
    }
}
