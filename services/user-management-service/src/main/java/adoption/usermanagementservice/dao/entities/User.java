package adoption.usermanagementservice.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users", catalog = "user-management")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "email", length = 250)
    private String email;

    @Column(name = "motDepasse", length = 250)
    private String password;

    @Column(name = "phone", length = 250)
    private String phone;

    @Column(name = "role", length = 250)
    private String role;

    @Column(name = "estVerifie")
    private Boolean estVerifie;

    @Column(name = "dateInscription", columnDefinition = "TIMESTAMP")
    private LocalDateTime dateInscription;

    @Column(name = "USER_CREATION")
    private Long userCreation;

    @Column(name = "USER_UPDATE")
    private Long userUpdate;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return  List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}

