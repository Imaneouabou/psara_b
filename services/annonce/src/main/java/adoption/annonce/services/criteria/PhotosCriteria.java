package adoption.annonce.services.criteria;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PhotosCriteria {

    private Long id;                  // L'identifiant de la photo

    private String url;               // URL de la photo

    private Long animalId;            // Identifiant de l'animal associé

    private Long annonceId;           // Identifiant de l'annonce associée

}
