package adoption.usermanagementservice.services.dto;

import lombok.Data;

@Data
public class LoginResponseDto {
    private Long userId;
    private int statusCode;
    private String error;
    private String message;
    private String token;
    private String refreshToken;
    private String nom;
    private String prenom;
    private String expirationTime;
    private String email;
    private String role;
    private String password;
}
