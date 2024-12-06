package adoption.annonce.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "animal", catalog = "annonce-management")
public class Animal {

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

    // Relation One-to-One avec Annonce
    @OneToOne
    @JoinColumn(name = "annonce_id", nullable = false)
    private Annonce annonce;

    // Relation One-to-Many avec Photos
    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
    private List<Photos> photos;

}
