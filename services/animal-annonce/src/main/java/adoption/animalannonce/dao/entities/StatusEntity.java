package adoption.animalannonce.dao.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "status")
public class StatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_status")
    private Long id;

    @Column(name = "status" , nullable = false)
    private String status;

    @OneToMany(mappedBy = "statusEntity" , cascade = CascadeType.ALL)
    @JsonIgnore // Cette annotation ignore la relation bidirectionnelle
    private List<Adoption> adoptions ;
}
