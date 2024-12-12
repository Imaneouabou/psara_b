package adoption.usermanagementservice.services.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UtilisateurDto extends UserDto  {
    private String nom;
    private String prenom;
    private String cin;
}
