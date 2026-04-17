package christopherfa.U5_W2_D5.entities;

import christopherfa.U5_W2_D5.enums.StatoViaggio;
import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
@Table(name = "viaggi")
@Data
public class Viaggio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String destinazione;
    private LocalDate dataViaggio;
    @Enumerated(EnumType.STRING)
    private StatoViaggio stato = StatoViaggio.IN_PROGRAMMA;
}
