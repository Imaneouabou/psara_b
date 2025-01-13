package adoption.animalannonce.controller;


import adoption.animalannonce.services.AdoptionService;
import adoption.animalannonce.services.dto.AdoptionDto;
import adoption.animalannonce.services.dto.StatusDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/adoptions")
@RequiredArgsConstructor
public class AdoptionController {

    private final AdoptionService adoptionService;

    @PostMapping("/create-status")
    public StatusDto createStatus(@RequestBody StatusDto statusDto) {
        System.out.println(statusDto.getStatus());
        return adoptionService.createStatus(statusDto);
    }

    @GetMapping("/all-status")
    public List<StatusDto> getAllStatus() {
        return adoptionService.getAllStatus();
    }

    /**
     * Créer une nouvelle adoption.
     */
    @PostMapping
    public ResponseEntity<AdoptionDto> createAdoption(@RequestBody AdoptionDto adoptionDto) {
        AdoptionDto createdAdoption = adoptionService.addAdoption(adoptionDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAdoption);
    }

    /**
     * Récupérer une adoption par ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<AdoptionDto> getAdoptionById(@PathVariable Long id) {
        AdoptionDto adoptionDto = adoptionService.getAdoptionById(id);
        return ResponseEntity.ok(adoptionDto);
    }

    /**
     * Récupérer toutes les adoptions.
     */
    @GetMapping
    public ResponseEntity<List<AdoptionDto>> getAllAdoptions() {
        List<AdoptionDto> adoptions = adoptionService.getAllAdoptions();
        return ResponseEntity.ok(adoptions);
    }

    // Endpoint pour mettre à jour le statut d'une adoption
    @PutMapping("/{adoptionId}/status/{statusId}")
    @ResponseStatus(HttpStatus.OK)
    public AdoptionDto updateStatusDecision(@PathVariable Long adoptionId, @PathVariable Long statusId) {
        try {
            return adoptionService.updateStatusDecision(adoptionId, statusId);
        } catch (IllegalArgumentException e) {
            // En cas d'erreur, retourner un message détaillé
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    /**
     * Récupérer les adoptions par utilisateur.
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AdoptionDto>> getAdoptionsByUserId(@PathVariable Long userId) {
        List<AdoptionDto> adoptions = adoptionService.getAdoptionsByUserId(userId);
        return ResponseEntity.ok(adoptions);
    }

    /**
     * Mettre à jour une adoption existante.
     */
    @PutMapping("/{id}")
    public ResponseEntity<AdoptionDto> updateAdoption(
            @PathVariable Long id,
            @RequestBody AdoptionDto adoptionDto) {
        AdoptionDto updatedAdoption = adoptionService.updateAdoption(id, adoptionDto);
        return ResponseEntity.ok(updatedAdoption);
    }

    /**
     * Supprimer une adoption par ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdoption(@PathVariable Long id) {
        adoptionService.deleteAdoption(id);
        return ResponseEntity.noContent().build();
    }
}
