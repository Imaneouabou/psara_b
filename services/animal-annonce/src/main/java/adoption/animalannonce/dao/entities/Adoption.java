package adoption.animalannonce.dao.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "adoption" )
public class Adoption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "data_demande")
    private LocalDateTime dataDemande;

    @Column(name = "date_validation")
    private LocalDateTime dateValidation;

    @Column(name = "type_adoption")
    private String typeAdoption;

    @Column(name = "id_user")
    private Long idUser;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private StatusEntity statusEntity;

    @ManyToOne
    @JoinColumn(name = "animal_annonce_id")
    private AnimalAnnonce animalAnnonce;

    @OneToMany( mappedBy = "adoption", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<AvisComment> avisComments;

}
