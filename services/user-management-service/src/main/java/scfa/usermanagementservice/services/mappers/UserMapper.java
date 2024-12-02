package scfa.usermanagementservice.services.mappers;


import org.springframework.stereotype.Component;
import scfa.usermanagementservice.dao.entities.User;
import scfa.usermanagementservice.services.dto.UserDto;

@Component
public class UserMapper {

    public User toEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId()); // Assurez-vous que l'ID est correctement mappé
        user.setNom(userDto.getNom());
        user.setPrenom(userDto.getPrenom());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        user.setDateCreation(userDto.getDateCreation());
        user.setDateUpdate(userDto.getDateUpdate());
        return user;
    }

    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId()); // Assurez-vous que l'ID est correctement mappé
        userDto.setNom(user.getNom());
        userDto.setPrenom(user.getPrenom());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole());
        userDto.setDateCreation(user.getDateCreation());
        userDto.setDateUpdate(user.getDateUpdate());
        return userDto;
    }

}
