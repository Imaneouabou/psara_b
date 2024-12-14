package adoption.animalannonce.controller;

import adoption.animalannonce.dao.entities.AvisComment;
import adoption.animalannonce.dao.repository.AvisCommentRepository;
import adoption.animalannonce.services.AvisCommentService;
import adoption.animalannonce.services.dto.AdoptionDto;
import adoption.animalannonce.services.dto.AvisCommentDto;
import adoption.animalannonce.services.mappers.AvisCommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avis-comment")
@RequiredArgsConstructor
public class AvisCommentController {

    private final AvisCommentService avisCommentService;

    @PostMapping
    public AvisCommentDto createAvisComment(@RequestBody AvisCommentDto avisCommentDto) {
        return avisCommentService.createAvisComment(avisCommentDto);
    }


    @PostMapping("create")
    public  ResponseEntity<AvisCommentDto> createAvis(@RequestBody AvisCommentDto avisCommentDto) {
        return ResponseEntity.ok(avisCommentService.createAvisComment(avisCommentDto));
    }


    @PutMapping("/{id}")
    public ResponseEntity<AvisCommentDto> updateAvisComments(
            @PathVariable Long id,
            @RequestBody AvisCommentDto avisCommentDto) {
        AvisCommentDto updatedAvisComment = avisCommentService.updateAvisComment(id, avisCommentDto);
        return ResponseEntity.ok(updatedAvisComment);
    }


    @GetMapping
    public ResponseEntity<List<AvisCommentDto>> getAllAvisComments() {
        List<AvisCommentDto> AvisComments = avisCommentService.getAllAvisComments();
        return ResponseEntity.ok(AvisComments);
    }

    @GetMapping("/{adoptionId}")
    public ResponseEntity<List<AvisCommentDto>> findAvisCommentByAdoptionId(@PathVariable Long adoptionId) {
        return ResponseEntity.ok(avisCommentService.findAvisCommentByAdoptionId(adoptionId));
    }

    @DeleteMapping("/{avisId}")
    public ResponseEntity<Void> deleteAvisComment(@PathVariable Long avisId) {
        avisCommentService.deleteAvisCommentById(avisId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/count-avis")
    public long getCountAvisCommentByAdoptionId(Long adoptionId) {
        return avisCommentService.countAvisCommentsByAdoptionId(adoptionId);
    }

}
