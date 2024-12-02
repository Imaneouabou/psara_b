package scfa.usermanagementservice.services.criteria;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserCriteria {
    private Long id;
    private String nom;
    private String prenom;
    private String phone;
    private String email;
    private String password;
    private String role;
}
