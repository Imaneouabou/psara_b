package adoption.animalannonce.controller;

import adoption.animalannonce.services.dto.AnimalAnnonceDto;
import adoption.animalannonce.exception.FunctionalException;
import adoption.animalannonce.services.AnimalAnnonceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/animal-annonces")
public class AnimalAnnonceController {

    @Autowired
     private  AnimalAnnonceService animalAnnonceService;



    // Créer une annonce
    @PostMapping
    public AnimalAnnonceDto createAnimalAnnonce(@ModelAttribute AnimalAnnonceDto animalAnnonceDto) throws IOException {
        return animalAnnonceService.createAnimalAnnonce(animalAnnonceDto);
    }

    // Trouver une annonce par ID
    @GetMapping("/{id}")
    public AnimalAnnonceDto findAnimalAnnonceById(@PathVariable Long id) throws FunctionalException {
        return animalAnnonceService.findAnimalAnnonceById(id);
    }

    // Mettre à jour une annonce
    @PutMapping("/{id}")
    public AnimalAnnonceDto updateAnimalAnnonce(@PathVariable Long id, @ModelAttribute AnimalAnnonceDto animalAnnonceDto)
            throws FunctionalException, IOException {
        return animalAnnonceService.updateAnimalAnnonce(id, animalAnnonceDto);
    }

    // Supprimer une annonce
    @DeleteMapping("/{id}")
    public void deleteAnimalAnnonce(@PathVariable Long id) throws FunctionalException {
        animalAnnonceService.deleteAnimalAnnonce(id);
    }

    // Récupérer toutes les annonces
    @GetMapping
    public List<AnimalAnnonceDto> getAllAnimalAnnonces() {
        return animalAnnonceService.getAllAnimalAnnonces();
    }

    // Rechercher des annonces par critères
    @GetMapping("/search")
    public List<AnimalAnnonceDto> findAnimalAnnoncesByCriteria(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String localisation) {
        return animalAnnonceService.findAnimalAnnoncesByCriteria(type, localisation);
    }

    // Changer le statut d'une annonce
    @PatchMapping("/{id}/status")
    public AnimalAnnonceDto changeStatus(@PathVariable Long id, @RequestParam String status) throws FunctionalException {
        return animalAnnonceService.changeStatus(id, status);
    }

    // Supprimer une image spécifique d'une annonce
    @PatchMapping("/{id}/remove-image")
    public AnimalAnnonceDto removeImageFromAnnonce(@PathVariable Long id, @RequestParam String imagePath)
            throws FunctionalException {
        return animalAnnonceService.removeImageFromAnnonce(id, imagePath);
    }
}