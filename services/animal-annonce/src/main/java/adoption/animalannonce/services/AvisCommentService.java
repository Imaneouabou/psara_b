package adoption.animalannonce.services;


import adoption.animalannonce.dao.entities.AvisComment;
import adoption.animalannonce.dao.repository.AvisCommentRepository;
import adoption.animalannonce.exception.FunctionalException;
import adoption.animalannonce.services.dto.AvisCommentDto;
import adoption.animalannonce.services.mappers.AvisCommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AvisCommentService {

    private final AvisCommentRepository avisCommentRepository;

    private final AvisCommentMapper avisCommentMapper;


    public AvisCommentDto createAvisComment(AvisCommentDto avisCommentDto) {
        AvisComment avisComment = avisCommentMapper.toEntity(avisCommentDto);
        avisComment.setCreatedAt(LocalDateTime.now());
        AvisComment savedAvisComment = avisCommentRepository.save(avisComment);
        return avisCommentMapper.toDto(savedAvisComment);
    }

    public List<AvisCommentDto> getAllAvisComments() {
       List<AvisComment>  avisComment = avisCommentRepository.findAll();

        return avisComment.stream()
                .map(avisCommentMapper::toDto)
                .collect(Collectors.toList());
    }

    public AvisCommentDto getAvisCommentById(long avisCommentId) {
        AvisComment avisComment = avisCommentRepository.findById(avisCommentId).orElse(null);
        return avisCommentMapper.toDto(avisComment);
    }

    public void deleteAvisCommentById(long avisCommentId) throws FunctionalException {
        AvisComment avisComment = avisCommentRepository.findById(avisCommentId)
                .orElseThrow(() -> new FunctionalException("no avis comment found with id: " + avisCommentId));
        avisCommentRepository.deleteById(avisCommentId);
    }

    public List<AvisCommentDto> findAvisCommentByAdoptionId(Long adoptionId) {
        List<AvisComment> avisComments = avisCommentRepository.findByAdoptionId(adoptionId);

        return avisComments.stream()
                .map(avisCommentMapper::toDto)
                .collect(Collectors.toList());
    }

    public AvisCommentDto updateAvisComment(Long id, AvisCommentDto avisCommentDto) {

        Optional<AvisComment> avisComment = avisCommentRepository.findById(id);

        AvisComment savedAvisComment;
        if (avisComment.isPresent()) {

            AvisComment avisCommentToUpdate = new AvisComment();
            avisCommentToUpdate.setComment(avisCommentDto.getComment());
            avisCommentToUpdate.setId(id);
            avisCommentToUpdate.setCreatedAt(avisComment.get().getCreatedAt());
            avisCommentToUpdate.setUserId(avisComment.get().getUserId());
            avisCommentToUpdate.setAdoption(avisComment.get().getAdoption());
            savedAvisComment = avisCommentRepository.save(avisCommentToUpdate);
            return avisCommentMapper.toDto(savedAvisComment);
        } else {
            throw new FunctionalException("no avis comment found with id: " + id);
        }
    }

    public long countAvisCommentsByAdoptionId(Long adoptionId) {
        return avisCommentRepository.countByAdoptionId(adoptionId);
    }




}
