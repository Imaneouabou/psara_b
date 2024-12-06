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
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOM", length=250)
    private String nom;

    @Column(name = "PRENOM", length = 250)
    private String prenom;

    @Column(name = "EMAIL", length = 250)
    private String email;

    @Column(name = "PHONE" )
    private String phone;

    @Column(name = "PASSWORD", length = 250)
    private String password;

    @Column(name = "ROLE")
    private String role ;

    @Column(name = "date_creation", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime dateCreation;

    @Column(name = "date_update", columnDefinition = "TIMESTAMP")
    private LocalDateTime dateUpdate;


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

