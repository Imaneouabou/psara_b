package adoption.usermanagementservice.services.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssociationDto extends UserDto{
    private String nomOrganisation;
    private String description;
    private String adresse;
    private String siteWeb;
    private String nr;
    private String documentVerification;
}