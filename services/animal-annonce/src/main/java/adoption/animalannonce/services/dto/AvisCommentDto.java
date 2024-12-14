package adoption.animalannonce.services.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AvisCommentDto {
    private Long id;
    private String comment;
    private LocalDateTime createdAt;
    private Long userId;
    private Long adoptedId;
}
