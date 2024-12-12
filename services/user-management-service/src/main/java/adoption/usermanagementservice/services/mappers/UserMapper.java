package adoption.usermanagementservice.services.mappers;


import org.springframework.stereotype.Component;
import adoption.usermanagementservice.dao.entities.User;
import adoption.usermanagementservice.services.dto.UserDto;

@Component
public class UserMapper {

    public User toEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId()); // Assurez-vous que l'ID est correctement mappé
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        return user;
    }

    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId()); // Assurez-vous que l'ID est correctement mappé
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole());

        return userDto;
    }

}
