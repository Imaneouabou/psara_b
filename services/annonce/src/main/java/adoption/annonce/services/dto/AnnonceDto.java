package adoption.annonce.services.dto;

import adoption.annonce.dao.entities.Photos;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class AnnonceDto {

    private Long id;

    private String description;

    private String type;

    private String status;

    private LocalDateTime dateCreated;

    private LocalDateTime dateUpdate;

    private Long userCreation;

    private List<Photos> photosAnimal ;
}
