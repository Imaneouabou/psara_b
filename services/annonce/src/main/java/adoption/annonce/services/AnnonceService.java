package adoption.annonce.services;

import adoption.annonce.dao.entities.Animal;
import adoption.annonce.dao.entities.Annonce;
import adoption.annonce.dao.entities.Photos;
import adoption.annonce.dao.repository.AnimalRepository;
import adoption.annonce.dao.repository.AnnonceRepository;
import adoption.annonce.dao.repository.PhotosRepository;
import adoption.annonce.services.dto.AnimalDto;
import adoption.annonce.services.dto.AnnonceDto;
import adoption.annonce.services.dto.PhotosDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional // Assure la gestion des transactions pour les opérations sur la base
public class AnnonceService {

    @Autowired
    private AnnonceRepository annonceRepository;

    @Autowired
    private PhotosRepository photosRepository;

    @Autowired
    private AnimalRepository animalRepository;

    /**
     * Crée une annonce, enregistre l'animal et les photos associés dans la base de données.
     *
     * @param annonceDto Les informations de l'annonce.
     * @param animalDto Les informations de l'animal.
     * @param photosDtos La liste des photos associées.
     * @return L'annonce créée avec toutes les relations.
     */
    public AnnonceDto creerAnnonce(AnnonceDto annonceDto, AnimalDto animalDto, List<PhotosDto> photosDtos) {
        // 1. Enregistrer l'animal
        Animal animal = new Animal();
        animal.setNom(animalDto.getNom());
        animal.setVaccin(animalDto.getVaccin());
        animal.setTypeVaccin(animalDto.getTypeVaccin());
        animal.setAge(animalDto.getAge());
        animal.setSexe(animalDto.getSexe());
        animal.setLocalisation(animalDto.getLocalisation());
        animal.setBesoinsSpecifiques(animalDto.getBesoinsSpecifiques());
        Animal savedAnimal = animalRepository.save(animal);

        // 2. Créer l'annonce et l'associer à l'animal
        Annonce annonce = new Annonce();
        annonce.setDescription(annonceDto.getDescription());
        annonce.setType(annonceDto.getType());
        annonce.setStatus(annonceDto.getStatus());
        annonce.setDateCreated(LocalDateTime.now());
        annonce.setDateUpdate(LocalDateTime.now());
        annonce.setUserCreation(annonceDto.getUserCreation());
        annonce.setAnimal(savedAnimal); // Association avec l'animal
        Annonce savedAnnonce = annonceRepository.save(annonce);

        // 3. Enregistrer les photos et les associer à l'annonce
        List<Photos> savedPhotos = photosDtos.stream().map(photoDto -> {
            Photos photo = new Photos();
            photo.setUrl(photoDto.getUrl());
            photo.setAnnonce(savedAnnonce); // Association avec l'annonce
            return photosRepository.save(photo);
        }).collect(Collectors.toList());

        // 4. Préparer l'objet DTO pour la réponse
        AnnonceDto result = new AnnonceDto();
        result.setId(savedAnnonce.getId());
        result.setDescription(savedAnnonce.getDescription());
        result.setType(savedAnnonce.getType());
        result.setStatus(savedAnnonce.getStatus());
        result.setDateCreated(savedAnnonce.getDateCreated());
        result.setDateUpdate(savedAnnonce.getDateUpdate());
        result.setUserCreation(savedAnnonce.getUserCreation());
        result.setPhotosAnimal(savedPhotos);

        return result;
    }
}
