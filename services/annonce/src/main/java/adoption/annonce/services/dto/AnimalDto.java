package adoption.annonce.services.dto;

import lombok.Data;

@Data
public class AnimalDto {

    private Long id;                  // Identifiant de l'animal
    private String nom;               // Nom de l'animal
    private Boolean vaccin;           // Indicateur si l'animal est vacciné
    private String typeVaccin;        // Type de vaccin reçu par l'animal
    private Integer age;              // Âge de l'animal
    private String sexe;              // Sexe de l'animal
    private String localisation;      // Localisation de l'animal
    private String besoinsSpecifiques; // Besoins spécifiques de l'animal
}
