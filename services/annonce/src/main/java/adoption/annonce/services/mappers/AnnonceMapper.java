package adoption.annonce.services.mappers;

import adoption.annonce.dao.entities.Annonce;
import adoption.annonce.dao.entities.Photos;
import adoption.annonce.services.dto.AnnonceDto;
import adoption.annonce.services.dto.PhotosDto;
import org.springframework.stereotype.Component;

@Component
public class AnnonceMapper {

    // Convertir un DTO en entité
    public Annonce toEntity(AnnonceDto annonceDto) {
        if (annonceDto == null) {
            return null;
        }

        Annonce annonce = new Annonce();
        annonce.setId(annonceDto.getId());
        annonce.setDescription(annonceDto.getDescription());
        annonce.setType(annonceDto.getType());
        annonce.setStatus(annonceDto.getStatus());
        annonce.setDateCreated(annonceDto.getDateCreated());
        annonce.setDateUpdate(annonceDto.getDateUpdate());
        annonce.setUserCreation(annonceDto.getUserCreation());
        return annonce;
    }

    // Convertir une entité en DTO
    public AnnonceDto toDto(Annonce annonce) {
        if (annonce == null) {
            return null;
        }

        AnnonceDto annonceDto = new AnnonceDto();
        annonceDto.setId(annonce.getId());
        annonceDto.setDescription(annonce.getDescription());
        annonceDto.setType(annonce.getType());
        annonceDto.setStatus(annonce.getStatus());
        annonceDto.setDateCreated(annonce.getDateCreated());
        annonceDto.setDateUpdate(annonce.getDateUpdate());
        annonceDto.setUserCreation(annonce.getUserCreation());


        return annonceDto;
    }

}
