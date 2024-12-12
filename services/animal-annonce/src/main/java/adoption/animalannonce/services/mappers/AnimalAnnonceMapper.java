package adoption.animalannonce.services.mappers;

import adoption.animalannonce.services.dto.AnimalAnnonceDto;
import adoption.animalannonce.dao.entities.AnimalAnnonce;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnimalAnnonceMapper {

    public AnimalAnnonceDto toDto(AnimalAnnonce animalAnnonce) {

        if (animalAnnonce == null) {
            return null;
        }

        AnimalAnnonceDto dto = new AnimalAnnonceDto();

        dto.setId(animalAnnonce.getId());
        dto.setNom(animalAnnonce.getNom());
        dto.setVaccin(animalAnnonce.getVaccin());
        dto.setTypeVaccin(animalAnnonce.getTypeVaccin());
        dto.setAge(animalAnnonce.getAge());
        dto.setSexe(animalAnnonce.getSexe());
        dto.setLocalisation(animalAnnonce.getLocalisation());
        dto.setBesoinsSpecifiques(animalAnnonce.getBesoinsSpecifiques());
        dto.setDescription(animalAnnonce.getDescription());
        dto.setType(animalAnnonce.getType());
        dto.setImages(animalAnnonce.getImages()); // Convert paths back to DTO
        dto.setStatus(animalAnnonce.getStatus());
        dto.setDateCreated(animalAnnonce.getDateCreated());
        dto.setDateUpdate(animalAnnonce.getDateUpdate());
        dto.setUserCreation(animalAnnonce.getUserCreation());

        return dto;

    }

    public AnimalAnnonce toEntity(AnimalAnnonceDto animalAnnonceDto, List<String> imagePaths) {
        if (animalAnnonceDto == null) {
            return null;
        }
        AnimalAnnonce animalAnnonce = new AnimalAnnonce();

        animalAnnonce.setId(animalAnnonceDto.getId());
        animalAnnonce.setNom(animalAnnonceDto.getNom());
        animalAnnonce.setVaccin(animalAnnonceDto.getVaccin());
        animalAnnonce.setType(animalAnnonceDto.getTypeVaccin());
        animalAnnonce.setAge(animalAnnonceDto.getAge());
        animalAnnonce.setSexe(animalAnnonceDto.getSexe());
        animalAnnonce.setLocalisation(animalAnnonceDto.getLocalisation());
        animalAnnonce.setBesoinsSpecifiques(animalAnnonceDto.getBesoinsSpecifiques());
        animalAnnonce.setDescription(animalAnnonceDto.getDescription());
        animalAnnonce.setImages(imagePaths);
        animalAnnonce.setType(animalAnnonceDto.getType());
        animalAnnonce.setStatus(animalAnnonceDto.getStatus());
        animalAnnonce.setDateCreated(animalAnnonceDto.getDateCreated());
        animalAnnonce.setDateUpdate(animalAnnonceDto.getDateUpdate());
        animalAnnonce.setUserCreation(animalAnnonceDto.getUserCreation());


        return animalAnnonce;
    }

}
