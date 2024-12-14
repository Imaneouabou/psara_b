package adoption.animalannonce.services.mappers;

import adoption.animalannonce.dao.entities.Adoption;
import adoption.animalannonce.dao.entities.AnimalAnnonce;
import adoption.animalannonce.dao.entities.StatusEntity;
import adoption.animalannonce.services.dto.AdoptionDto;
import org.springframework.stereotype.Component;

@Component
public class AdoptionMapper {

    public AdoptionDto toDto(Adoption adoption) {

        AdoptionDto dto = new AdoptionDto();
        dto.setId(adoption.getId());
        dto.setTypeAdoption(adoption.getTypeAdoption());
        dto.setIdUser(adoption.getIdUser());
        dto.setDataDemande(adoption.getDataDemande());
        dto.setDateValidation(adoption.getDateValidation());

        // Vérification des relations pour éviter les NullPointerException
        dto.setAnimalAnnonceId(
                adoption.getAnimalAnnonce() != null ? adoption.getAnimalAnnonce().getId() : null
        );
        dto.setStatusId(
                adoption.getStatusEntity() != null ? adoption.getStatusEntity().getId() : null
        );
        return dto;
    }


    public Adoption toEntity(AdoptionDto adoptionDto) {
        Adoption adoption = new Adoption();
        adoption.setId(adoptionDto.getId());
        adoption.setTypeAdoption(adoptionDto.getTypeAdoption());
        adoption.setIdUser(adoptionDto.getIdUser());
        adoption.setDataDemande(adoptionDto.getDataDemande());
        adoption.setDateValidation(adoptionDto.getDateValidation());

        // Mapper l'identifiant vers une entité AnimalAnnonce
        if (adoptionDto.getAnimalAnnonceId() != null) {
            AnimalAnnonce animalAnnonce = new AnimalAnnonce();
            animalAnnonce.setId(adoptionDto.getAnimalAnnonceId());
            adoption.setAnimalAnnonce(animalAnnonce);
        }

        // Mapper l'identifiant vers une entité StatusEntity
        if (adoptionDto.getStatusId() != null) {
            StatusEntity statusEntity = new StatusEntity();
            statusEntity.setId(adoptionDto.getStatusId());
            adoption.setStatusEntity(statusEntity);
        }

        return adoption;
    }
}
