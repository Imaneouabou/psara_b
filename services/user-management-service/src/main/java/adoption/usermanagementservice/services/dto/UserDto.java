package adoption.usermanagementservice.services.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import adoption.usermanagementservice.dao.entities.User;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    private int statusCode;
    private String error;
    private String message;
    private String token;
    private String refreshToken;
    private String expirationTime;
    private Long id;
    private String nom;
    private String prenom;
    private String phone;
    private String email;
    private String password;
    private String role;
    private LocalDateTime dateCreation;
    private LocalDateTime dateUpdate;
    private User users;
    private List<User> usersList;
}


