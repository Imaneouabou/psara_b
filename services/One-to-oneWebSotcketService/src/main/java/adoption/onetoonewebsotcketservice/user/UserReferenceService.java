package adoption.onetoonewebsotcketservice.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserReferenceService {


    private final UserRepository repository; // Notez "final" ici

    public void saveUser(String Id, String nom, String prenom) {
        Optional<User> existingUser = repository.findById(Id);

        if (existingUser.isPresent()) {
            // Si l'utilisateur existe, vérifier son statut
            User user = existingUser.get();

            // Si l'utilisateur est déconnecté, mettre à jour son statut
            if (user.getStatus() == Status.OFFLINE) {
                user.setStatus(Status.ONLINE);
                repository.save(user);
            }
        } else  {
            User user = new User();
            user.setId(Id);
            user.setNom(nom);
            user.setPrenom(prenom);
            user.setStatus(Status.ONLINE);
            repository.save(user);
        }
    }

    public void disconnect(User user) {
        var storedUser = repository.findById(user.getId()).orElse(null);
        if (storedUser != null) {
            storedUser.setStatus(Status.OFFLINE);
            repository.save(storedUser);
        }
    }

    public List<User> findConnectedUsers() {
        return repository.findAllByStatus(Status.ONLINE);
    }
}
