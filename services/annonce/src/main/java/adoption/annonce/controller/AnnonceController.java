package adoption.annonce.controller;

import adoption.annonce.services.AnnonceService;
import adoption.annonce.services.dto.AnimalDto;
import adoption.annonce.services.dto.AnnonceDto;
import adoption.annonce.services.dto.PhotosDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/annonces")
public class AnnonceController {

    @Autowired
    private AnnonceService annonceService;

    @PostMapping
    public ResponseEntity<AnnonceDto> creerAnnonce(
            @RequestBody AnnonceDto annonceDto,
            @RequestBody AnimalDto animalDto,
            @RequestBody List<PhotosDto> photosDtos) {
        // Appeler le service pour enregistrer l'annonce
        AnnonceDto createdAnnonce = annonceService.creerAnnonce(annonceDto, animalDto, photosDtos);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAnnonce);
    }
}
