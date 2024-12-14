package adoption.animalannonce.services.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdoptionDto {
    private Long id;
    private LocalDateTime dataDemande;
    private LocalDateTime dateValidation;
    private String typeAdoption;
    private Long idUser;
    private Long statusId; // Correspond à l'entité StatusEntity
    private Long animalAnnonceId; // Correspond à l'entité AnimalAnnonce
}
