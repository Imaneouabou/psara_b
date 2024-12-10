package adoption.animalannonce.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "AnimalAnnonce", catalog = "annonce-management")
public class AnimalAnnonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "vaccin", nullable = false)
    private Boolean vaccin;

    @Column(name = "type_vaccin")
    private String typeVaccin;

    @Column(name = "age")
    private int age;

    @Column(name = "sexe", nullable = false)
    private String sexe;

    @Column(name = "localisation")
    private String localisation;

    @Column(name = "besoins_specifiques")
    private String besoinsSpecifiques;

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

}
