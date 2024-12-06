package adoption.annonce.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "photos", catalog = "annonce-management")
public class Photos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "url", nullable = false)
    private String url;

    // Relation Many-to-One avec Animal
    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    // Relation Many-to-One avec Annonce
    @ManyToOne
    @JoinColumn(name = "annonce_id")
    private Annonce annonce;
}
