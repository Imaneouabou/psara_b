package adoption.usermanagementservice.services.mappers;


import adoption.usermanagementservice.dao.entities.Association;
import adoption.usermanagementservice.services.dto.AssociationDto;
import org.springframework.stereotype.Component;

@Component
public class AssociationMapper extends UserMapper {

    private final UserMapper userMapper = new UserMapper(); // Utilisation du mapper pour User

    // Mapper pour Association -> AssociationDTO
    public AssociationDto toAssociationDTO(Association association) {
        if (association == null) {
            return null;
        }

        AssociationDto associationDTO = new AssociationDto();
        // Mapper les propriétés héritées de User
        associationDTO.setId(association.getId());
        associationDTO.setEmail(association.getEmail());
        associationDTO.setPhone(association.getPhone());
        associationDTO.setRole(association.getRole());
        associationDTO.setEstVerifie(association.getEstVerifie());
        associationDTO.setDateInscription(association.getDateInscription());

        // Mapper les propriétés spécifiques à Association
        associationDTO.setNomOrganisation(association.getNomOrganisation());
        associationDTO.setDescription(association.getDescription());
        associationDTO.setAdresse(association.getAdresse());
        associationDTO.setSiteWeb(association.getSiteWeb());
        associationDTO.setNr(association.getNr());
        associationDTO.setDocumentVerification(association.getDocumentVerification());

        return associationDTO;
    }

    // Mapper pour AssociationDTO -> Association
    public Association toAssociation(AssociationDto associationDTO) {
        if (associationDTO == null) {
            return null;
        }

        Association association = new Association();
        // Mapper les propriétés héritées de User
        association.setId(associationDTO.getId());
        association.setEmail(associationDTO.getEmail());
        association.setPhone(associationDTO.getPhone());
        association.setRole(associationDTO.getRole());
        association.setEstVerifie(associationDTO.getEstVerifie());
        association.setDateInscription(associationDTO.getDateInscription());

        // Mapper les propriétés spécifiques à Association
        association.setNomOrganisation(associationDTO.getNomOrganisation());
        association.setDescription(associationDTO.getDescription());
        association.setAdresse(associationDTO.getAdresse());
        association.setSiteWeb(associationDTO.getSiteWeb());
        association.setNr(associationDTO.getNr());
        association.setDocumentVerification(associationDTO.getDocumentVerification());

        return association;
    }
}
