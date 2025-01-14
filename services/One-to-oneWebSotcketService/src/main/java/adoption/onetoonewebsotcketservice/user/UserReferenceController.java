package adoption.onetoonewebsotcketservice.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserReferenceController {

    private final UserReferenceService userService;

    @MessageMapping("/user.addUser")
    @SendTo("/user/public")
    public User addUser(@Payload User user) {
        // Valider les données reçues avant de les traiter
        if (user == null || user.getId() == null || user.getNom() == null || user.getPrenom() == null) {
            throw new IllegalArgumentException("Données utilisateur invalides.");
        }
        userService.saveUser(user.getId(), user.getNom(), user.getPrenom());
        return user;
    }

    @MessageMapping("/user.disconnectUser")
    @SendTo("/user/public")
    public User disconnectUser(@Payload User user) {
        if (user == null || user.getId() == null) {
            throw new IllegalArgumentException("Utilisateur non valide pour la déconnexion.");
        }
        userService.disconnect(user);
        return user;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> findConnectedUsers() {
        return ResponseEntity.ok(userService.findConnectedUsers());
    }

}
