package adoption.annonce.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "annonce" , catalog = "annonce-management")
public class Annonce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @Column(name = "status")
    private String status;

    @Column(name = "date_creation", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime dateCreated;

    @Column(name = "date_update", columnDefinition = "TIMESTAMP")
    private LocalDateTime dateUpdate;

    @Column(name = "USER_CREATION")
    private Long userCreation;

    // Relation One-to-One avec Animal
    @OneToOne(mappedBy = "annonce", cascade = CascadeType.ALL)
    private Animal animal;

    // Relation One-to-Many avec Photos
    @OneToMany(mappedBy = "annonce", cascade = CascadeType.ALL)
    private List<Photos> photos;

}
