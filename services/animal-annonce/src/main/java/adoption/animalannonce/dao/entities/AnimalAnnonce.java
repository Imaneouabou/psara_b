package adoption.animalannonce.dao.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AnimalAnnonce")
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

    @ElementCollection
    @CollectionTable(name = "ANIMAL_IMAGES", joinColumns = @JoinColumn(name = "ANIMAL_ID"))
    @Column(name = "IMAGE")
    private List<String> images;

    @OneToMany(mappedBy = "animalAnnonce", cascade = CascadeType.ALL)
    private List<Adoption> adoptions;

    public List<Adoption> getAdoptions() {
        return adoptions;
    }

    public void setAdoptions(List<Adoption> adoptions) {
        this.adoptions = adoptions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Boolean getVaccin() {
        return vaccin;
    }

    public void setVaccin(Boolean vaccin) {
        this.vaccin = vaccin;
    }

    public String getTypeVaccin() {
        return typeVaccin;
    }

    public void setTypeVaccin(String typeVaccin) {
        this.typeVaccin = typeVaccin;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getBesoinsSpecifiques() {
        return besoinsSpecifiques;
    }

    public void setBesoinsSpecifiques(String besoinsSpecifiques) {
        this.besoinsSpecifiques = besoinsSpecifiques;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(LocalDateTime dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public Long getUserCreation() {
        return userCreation;
    }

    public void setUserCreation(Long userCreation) {
        this.userCreation = userCreation;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
