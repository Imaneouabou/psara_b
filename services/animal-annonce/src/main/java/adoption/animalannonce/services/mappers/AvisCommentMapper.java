package adoption.animalannonce.services.mappers;

import adoption.animalannonce.dao.entities.Adoption;
import adoption.animalannonce.dao.entities.AvisComment;
import adoption.animalannonce.services.dto.AvisCommentDto;
import org.springframework.stereotype.Component;

@Component
public class AvisCommentMapper {

    public AvisCommentDto toDto(AvisComment avisComment) {

        if (avisComment == null) {
            return null;
        }

        AvisCommentDto avisCommentDto = new AvisCommentDto();

        avisCommentDto.setId(avisComment.getId());
        avisCommentDto.setComment(avisComment.getComment());
        avisCommentDto.setCreatedAt(avisComment.getCreatedAt());
        avisCommentDto.setUserId(avisComment.getUserId());
        avisCommentDto.setAdoptedId(
                avisComment.getAdoption() != null ? avisComment.getAdoption().getId()  : null
        );

        return avisCommentDto;
    }

    public AvisComment toEntity(AvisCommentDto avisCommentDto) {
        AvisComment avisComment = new AvisComment();

        avisComment.setId(avisCommentDto.getId());
        avisComment.setComment(avisCommentDto.getComment());
        avisComment.setCreatedAt(avisCommentDto.getCreatedAt());
        avisComment.setUserId(avisCommentDto.getUserId());

        if (avisCommentDto.getAdoptedId() != null) {
            Adoption adoption = new Adoption();
            adoption.setId(avisCommentDto.getAdoptedId());
            avisComment.setAdoption(adoption);
        }

        return avisComment;
    }

}
