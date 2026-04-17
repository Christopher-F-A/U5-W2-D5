package christopherfa.U5_W2_D5.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "prenotazioni")
@Data
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "viaggio_id")
    private Viaggio viaggio;

    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;

    private LocalDate dataRichiesta = LocalDate.now();
    @Column(columnDefinition = "TEXT")
    private String note;
}