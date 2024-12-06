package adoption.annonce.services.criteria;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class AnnonceCriteria {

    private Long id;

    private String description;

    private String type;

    private String status;

    private LocalDateTime dateCreated;

    private LocalDateTime dateUpdate;

    private Long userCreation;

}
