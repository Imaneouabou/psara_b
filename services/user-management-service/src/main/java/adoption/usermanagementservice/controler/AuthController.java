package adoption.usermanagementservice.controler;

import adoption.usermanagementservice.dao.entities.User;
import adoption.usermanagementservice.exception.FunctionalException;
import adoption.usermanagementservice.exception.UserAlreadyExistsException;
import adoption.usermanagementservice.services.UserService;
import adoption.usermanagementservice.services.criteria.UserCriteria;
import adoption.usermanagementservice.services.dto.LoginDto;
import adoption.usermanagementservice.services.dto.LoginResponseDto;
import adoption.usermanagementservice.services.dto.UserCreationDto;
import adoption.usermanagementservice.services.dto.UserDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")

public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginResponseDto req){
        return ResponseEntity.ok(userService.login(req));
    }


/*
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto) {
        try {
            UserDto registeredUser = userService.registerUser(userDto);
            return ResponseEntity.ok(registeredUser);
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<?> handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto) {
        Optional<User> userOpt = userService.authenticateUser(loginDto.getEmail(), loginDto.getPassword());
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Connexion réussie");
            response.put("role", user.getRole());
            return ResponseEntity.ok(response);
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Email ou mot de passe invalide");
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
    @GetMapping("/checkSession")
    public ResponseEntity<?> checkSession(HttpSession session) {
        if (session.getAttribute("user") != null) {
            return ResponseEntity.ok("L'utilisateur est connecté");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("L'utilisateur n'est pas connecté");
        }
    }

    @PostMapping("/auth/login")
    public ResponseEntity<UserDto> login(@RequestBody UserDto req){
        return ResponseEntity.ok(userService.login(req));
    }

    @PostMapping("/auth/refresh")
    public ResponseEntity<UserDto> refreshToken(@RequestBody UserDto req){
        return ResponseEntity.ok(userService.refreshToken(req));
    }

    @GetMapping("/alluser")
    public ResponseEntity<?> findUsersByCriteria(
            @RequestParam(name = "id", required = false) Long id,
            @RequestParam(name = "nom", required = false) String nom,
            @RequestParam(name = "prenom", required = false) String prenom,
            @RequestParam(name = "phone", required = false) String phone,
            @RequestParam(name = "email", required = false) String email,
            @RequestParam(name = "password", required = false) String password,
            @RequestParam(name = "role", required = false) String role,
            @RequestParam(name = "dateCreation", required = false) LocalDateTime dateCreation,
            @RequestParam(name = "dateUpdate", required = false) LocalDateTime dateUpdate
    ) {
        try {
            UserCriteria criteria = UserCriteria.builder()
                    .id(id)
                    .nom(nom)
                    .prenom(prenom)
                    .phone(phone)
                    .email(email)
                    .password(password)
                    .role(role)
                    .build();

            List<UserDto> userDtos = userService.findUserByCriteria(criteria);
            return ResponseEntity.ok(userDtos);
        } catch (FunctionalException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


 */
}
