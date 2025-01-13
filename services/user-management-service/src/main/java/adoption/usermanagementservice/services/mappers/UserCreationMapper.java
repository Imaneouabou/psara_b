package adoption.usermanagementservice.services.mappers;

import adoption.usermanagementservice.dao.entities.Association;
import adoption.usermanagementservice.dao.entities.Utilisateur;
import adoption.usermanagementservice.services.dto.UserCreationDto;
import org.springframework.stereotype.Component;

@Component
public class UserCreationMapper {

    // Mapper de UserCreationDto à Utilisateur
    public Utilisateur toUtilisateur(UserCreationDto userCreationDto) {
        if (userCreationDto == null) {
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(userCreationDto.getId());
        utilisateur.setEmail(userCreationDto.getEmail());
        utilisateur.setPassword(userCreationDto.getPassword());
        utilisateur.setPhone(userCreationDto.getPhone());
        utilisateur.setRole(userCreationDto.getRole());
        utilisateur.setEstVerifie(userCreationDto.getEstVerifie());
        utilisateur.setNom(userCreationDto.getNom());
        utilisateur.setPrenom(userCreationDto.getPrenom());
        utilisateur.setCin(userCreationDto.getCin());

        return utilisateur;
    }

    // Mapper de UserCreationDto à Association
    public Association toAssociation(UserCreationDto userCreationDto) {
        if (userCreationDto == null) {
            return null;
        }

        Association association = new Association();
        association.setId(userCreationDto.getId());
        association.setEmail(userCreationDto.getEmail());
        association.setPassword(userCreationDto.getPassword());
        association.setPhone(userCreationDto.getPhone());
        association.setRole(userCreationDto.getRole());
        association.setEstVerifie(userCreationDto.getEstVerifie());
        association.setNomOrganisation(userCreationDto.getNomOrganisation());
        association.setDescription(userCreationDto.getDescription());
        association.setAdresse(userCreationDto.getAdresse());
        association.setSiteWeb(userCreationDto.getSiteWeb());
        association.setNr(userCreationDto.getNr());
        association.setDocumentVerification(userCreationDto.getDocumentVerification());

        return association;
    }

    // Mapper de Utilisateur à UserCreationDto
    public UserCreationDto toUserCreationDto(Utilisateur utilisateur) {
        if (utilisateur == null) {
            return null;
        }

        UserCreationDto userCreationDto = new UserCreationDto();
        userCreationDto.setId(utilisateur.getId());
        userCreationDto.setEmail(utilisateur.getEmail());
        userCreationDto.setPassword(utilisateur.getPassword());
        userCreationDto.setPhone(utilisateur.getPhone());
        userCreationDto.setRole(utilisateur.getRole());
        userCreationDto.setEstVerifie(utilisateur.getEstVerifie());
        userCreationDto.setNom(utilisateur.getNom());
        userCreationDto.setPrenom(utilisateur.getPrenom());
        userCreationDto.setCin(utilisateur.getCin());

        return userCreationDto;
    }

    // Mapper de Association à UserCreationDto
    public UserCreationDto toUserCreationDto(Association association) {
        if (association == null) {
            return null;
        }

        UserCreationDto userCreationDto = new UserCreationDto();
        userCreationDto.setId(association.getId());
        userCreationDto.setEmail(association.getEmail());
        userCreationDto.setPassword(association.getPassword());
        userCreationDto.setPhone(association.getPhone());
        userCreationDto.setRole(association.getRole());
        userCreationDto.setEstVerifie(association.getEstVerifie());
        userCreationDto.setNomOrganisation(association.getNomOrganisation());
        userCreationDto.setDescription(association.getDescription());
        userCreationDto.setAdresse(association.getAdresse());
        userCreationDto.setSiteWeb(association.getSiteWeb());
        userCreationDto.setNr(association.getNr());
        userCreationDto.setDocumentVerification(association.getDocumentVerification());

        return userCreationDto;
    }
}
