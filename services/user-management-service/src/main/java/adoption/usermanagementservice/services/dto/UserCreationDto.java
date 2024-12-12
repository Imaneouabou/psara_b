package adoption.usermanagementservice.services.dto;

import lombok.Data;

@Data
public class UserCreationDto {


    private String email;
    private String password;
    private String phone;
    private String role;
    private Boolean estVerifie;
    private String userType; // "UTILISATEUR" ou "ASSOCIATION"

    // Propriétés spécifiques à l'utilisateur
    private String nom;
    private String prenom;
    private String cin;

    // Propriétés spécifiques à l'association
    private String nomOrganisation;
    private String description;
    private String adresse;
    private String siteWeb;
    private String nr;
    private String documentVerification;
}
