package adoption.usermanagementservice.services;


import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import adoption.usermanagementservice.dao.entities.User;
import adoption.usermanagementservice.dao.repositories.UserRepository;
import adoption.usermanagementservice.exception.FunctionalException;
import adoption.usermanagementservice.exception.UserAlreadyExistsException;
import adoption.usermanagementservice.services.criteria.UserCriteria;
import adoption.usermanagementservice.services.dto.ResponseDto;
import adoption.usermanagementservice.services.dto.UserDto;
import adoption.usermanagementservice.services.mappers.UserMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private AuthenticationManager authenticationManager;

    public UserDto registerUser(UserDto userDto) {
        Optional<User> existingUser = userRepository.findByEmail(userDto.getEmail());
        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException("User with email " + userDto.getEmail() + " already exists.");
        }

        User user = userMapper.toEntity(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setDateCreation(LocalDateTime.now());
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }
    public UserDto registerUser_(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER"); // Default role
        user.setDateCreation(LocalDateTime.now());
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> authenticateUser(String email, String password) {
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent() && passwordEncoder.matches(password, userOpt.get().getPassword())) {
            return userOpt;
        }
        return Optional.empty();
    }

    public UserDto login(UserDto loginRequest) {
        UserDto response = new UserDto();
        try {
            // Authenticate the user using the provided email and password
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(), loginRequest.getPassword()
                    )
            );

            // Fetch the user details from the repository
            var user = userRepository.findByEmail(loginRequest.getEmail())
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

            // Generate JWT and refresh tokens
            var jwt = jwtUtils.generateToken(user);
            var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);

            // Populate the response DTO with the appropriate details
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRole(user.getRole());
            response.setNom(user.getNom());
            response.setPrenom(user.getPrenom());
            response.setRefreshToken(refreshToken);
            response.setExpirationTime("24Hrs");
            response.setMessage("Connexion réussie");

            return response;

        } catch (UsernameNotFoundException e) {
            // Handle case when the user is not found
            response.setStatusCode(404);
            response.setMessage("Utilisateur non trouvé: " + e.getMessage());
            return response;

        } catch (BadCredentialsException e) {
            // Return HTTP 401 instead of 200 with an error message
            response.setStatusCode(401);
            response.setMessage("Identifiants incorrects: " + e.getMessage());
            return response;

        } catch (Exception e) {
            // Handle any other exceptions that might occur
            response.setStatusCode(500);
            response.setMessage("Une erreur est survenue: " + e.getMessage());
            return response;
        }
    }



    public UserDto refreshToken(UserDto refreshTokenReqiest){
        UserDto response = new UserDto();
        try{
            String ourEmail = jwtUtils.extractUsername(refreshTokenReqiest.getToken());
            User users = userRepository.findByEmail(ourEmail).orElseThrow();
            if (jwtUtils.isTokenValid(refreshTokenReqiest.getToken(), users)) {
                var jwt = jwtUtils.generateToken(users);
                response.setStatusCode(200);
                response.setToken(jwt);
                response.setRefreshToken(refreshTokenReqiest.getToken());
                response.setExpirationTime("24Hr");
                response.setMessage("Successfully Refreshed Token");
            }
            response.setStatusCode(200);
            return response;

        }catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
            return response;
        }
    }


   public List<UserDto> findUserByCriteria(UserCriteria userCriteria) throws FunctionalException {
        List<User> userList = userRepository.findAll((Specification<User>) (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (userCriteria.getId() != null) {
                predicates.add(builder.equal(root.get("id"), userCriteria.getId()));
            }
            if (userCriteria.getNom() != null) {
                predicates.add(builder.like(builder.lower(root.get("nom")), "%" + userCriteria.getNom().toLowerCase() + "%"));
            }
            if (userCriteria.getPrenom() != null) {
                predicates.add(builder.like(builder.lower(root.get("prenom")), "%" + userCriteria.getPrenom().toLowerCase() + "%"));
            }
            if (userCriteria.getPhone() != null) {
                predicates.add(builder.equal(root.get("phone"), userCriteria.getPhone()));
            }
            if (userCriteria.getEmail() != null) {
                predicates.add(builder.equal(root.get("email"), userCriteria.getEmail()));
            }
            if (userCriteria.getPassword() != null) {
                predicates.add(builder.equal(root.get("password"), userCriteria.getPassword()));
            }
            if (userCriteria.getRole() != null) {
                predicates.add(builder.equal(root.get("role"), userCriteria.getRole()));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        });

        // Convertir la liste des utilisateurs en liste de UserDto
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : userList) {
            userDtoList.add(userMapper.toDto(user));
        }
        return userDtoList;
    }


    public UserDto findUserById(Long id) throws FunctionalException {
            UserCriteria userCriteria = UserCriteria.builder()
                    .id(id)
                    .build();
            List<UserDto> userDtoList = findUserByCriteria(userCriteria);
            if (userDtoList != null && !userDtoList.isEmpty()) {
                return userDtoList.get(0);
            } else {
                throw new FunctionalException("L'utilisateur avec l'id " + id + " n'existe pas.");
            }
        }

    public UserDto updateUser(Long id, UserDto userDto) throws FunctionalException {
        // Trouver l'utilisateur existant par ID
        UserDto existingUserDto = findUserById(id);

        // Mettre à jour les champs nécessaires
        userDto.setId(id);  // S'assurer que l'ID est correctement mis à jour
        userDto.setDateCreation(existingUserDto.getDateCreation());
        userDto.setDateUpdate(LocalDateTime.now());
        // Enregistrer l'utilisateur mis à jour
        User updatedUser = userRepository.save(userMapper.toEntity(userDto));

        // Mapper l'entité mise à jour en DTO
        return userMapper.toDto(updatedUser);
    }

    public ResponseDto deleteUserById(Long id) throws FunctionalException {
        ResponseDto responseDto = new ResponseDto();

        // Trouver l'utilisateur par ID
        UserDto userDto = findUserById(id);
        userRepository.deleteById(id);

        responseDto.setMessage("L'utilisateur " + userDto.getNom() + " " + userDto.getPrenom() + " a bien été supprimé");
        return responseDto;
    }


    public UserDto getMyInfo(String email){
        UserDto reqRes = new UserDto();
        try {
            Optional<User> userOptional = userRepository.findByEmail(email);
            if (userOptional.isPresent()) {
                reqRes.setUsers(userOptional.get());
                reqRes.setStatusCode(200);
                reqRes.setMessage("successful");
            } else {
                reqRes.setStatusCode(404);
                reqRes.setMessage("User not found for update");
            }

        }catch (Exception e){
            reqRes.setStatusCode(500);
            reqRes.setMessage("Error occurred while getting user info: " + e.getMessage());
        }
        return reqRes;

    }



}