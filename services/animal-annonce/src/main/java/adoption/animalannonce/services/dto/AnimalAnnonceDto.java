package adoption.animalannonce.services.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

public class AnimalAnnonceDto {

    private Long id;

    private String nom;

    private Boolean vaccin;

    private String typeVaccin;

    private Integer age;

    private String sexe;

    private String localisation;

    private String besoinsSpecifiques;

    private List<String> images; // Paths of the images

    private List<MultipartFile> imageFiles;
    
    private String description;

    private String type;

    private String status;

    private LocalDateTime dateCreated;

    private LocalDateTime dateUpdate;

    private Long userCreation;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<MultipartFile> getImageFiles() {
        return imageFiles;
    }

    public void setImageFiles(List<MultipartFile> imageFiles) {
        this.imageFiles = imageFiles;
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
}
