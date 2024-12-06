package adoption.annonce.services.criteria;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimalCriteria {
    private Long id;                  // L'identifiant de l'animal
    private String nom;               // Nom de l'animal
    private Boolean vaccin;           // Indique si l'animal est vacciné
    private String typeVaccin;        // Type de vaccin reçu
    private Integer age;              // Âge de l'animal
    private String sexe;              // Sexe de l'animal
    private String localisation;      // Localisation de l'animal
    private String besoinsSpecifiques; // Besoins spécifiques de l'animal
    private Long annonceId;           // Identifiant de l'annonce associée
}
