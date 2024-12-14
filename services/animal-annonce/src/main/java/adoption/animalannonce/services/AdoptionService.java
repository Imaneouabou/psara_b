package adoption.animalannonce.services;


import adoption.animalannonce.dao.entities.Adoption;
import adoption.animalannonce.dao.entities.StatusEntity;
import adoption.animalannonce.dao.repository.AdoptionRepository;
import adoption.animalannonce.dao.repository.StatusRepository;
import adoption.animalannonce.services.dto.AdoptionDto;
import adoption.animalannonce.services.dto.StatusDto;
import adoption.animalannonce.services.mappers.AdoptionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdoptionService {

    private final AdoptionRepository adoptionRepository;

    private final AdoptionMapper adoptionMapper;

    private final StatusRepository statusRepository;

    // ajouter status
    public StatusDto createStatus(StatusDto statusDto) {
        // Créer une nouvelle entité à partir du DTO
        StatusEntity statusEntity = new StatusEntity();
        statusEntity.setStatus(statusDto.getStatus());

        System.out.println("status est : " + statusDto.getStatus());
        // Enregistrer dans la base de données
        StatusEntity savedStatusEntity = statusRepository.save(statusEntity);

        // Mapper l'entité enregistrée vers le DTO pour la réponse
        StatusDto responseDto = new StatusDto();
        responseDto.setId(savedStatusEntity.getId());
        responseDto.setStatus(savedStatusEntity.getStatus());

        return responseDto;
    }


    public List<StatusDto> getAllStatus() {
        List<StatusEntity> statusEntities = statusRepository.findAll();

        return statusEntities.stream().
                map(statusEntity -> {
                    // Create a new StatusDto for each StatusEntity
                    StatusDto statusDto = new StatusDto();
                    statusDto.setId(statusEntity.getId());
                    statusDto.setStatus(statusEntity.getStatus());
                    return statusDto;
                }).collect(Collectors.toList());
    }

    /**
     * Ajouter une nouvelle adoption.
     */
    public AdoptionDto addAdoption(AdoptionDto adoptionDto) {
        Adoption adoption = adoptionMapper.toEntity(adoptionDto);
        adoption.setDataDemande(LocalDateTime.now());
        Adoption savedAdoption = adoptionRepository.save(adoption);
        return adoptionMapper.toDto(savedAdoption);
    }

    /**
     * Récupérer une adoption par son ID.
     */
    public AdoptionDto getAdoptionById(Long id) {
        Optional<Adoption> adoption = adoptionRepository.findById(id);
        if (adoption.isPresent()) {
            return adoptionMapper.toDto(adoption.get());
        } else {
            throw new IllegalArgumentException("Adoption avec l'ID " + id + " introuvable.");
        }
    }

    /**
     * Récupérer toutes les adoptions.
     */
    public List<AdoptionDto> getAllAdoptions() {
        List<Adoption> adoptions = adoptionRepository.findAll();
        return adoptions.stream()
                .map(adoptionMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Mettre à jour une adoption existante.
     */
    public AdoptionDto updateAdoption(Long id, AdoptionDto adoptionDto) {
        Optional<Adoption> existingAdoption = adoptionRepository.findById(id);
        if (existingAdoption.isPresent()) {
            Adoption adoptionToUpdate = adoptionMapper.toEntity(adoptionDto);
            adoptionToUpdate.setId(id); // Assurez-vous que l'ID reste le même
            Adoption updatedAdoption = adoptionRepository.save(adoptionToUpdate);
            return adoptionMapper.toDto(updatedAdoption);
        } else {
            throw new IllegalArgumentException("Adoption avec l'ID " + id + " introuvable.");
        }
    }

    /**
     * Supprimer une adoption par son ID.
     */
    public void deleteAdoption(Long id) {
        if (adoptionRepository.existsById(id)) {
            adoptionRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Adoption avec l'ID " + id + " introuvable.");
        }
    }

    /**
     * Récupérer les adoptions d'un utilisateur spécifique.
     */
    public List<AdoptionDto> getAdoptionsByUserId(Long userId) {
        List<Adoption> adoptions = adoptionRepository.findByIdUser(userId);
        return adoptions.stream()
                .map(adoptionMapper::toDto)
                .collect(Collectors.toList());
    }

}
