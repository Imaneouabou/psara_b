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
    private String email;
    private String password;
    private String phone;
    private String role;
    private Boolean estVerifie;
    private LocalDateTime dateInscription;
    private User users;
    private List<User> usersList;
}


