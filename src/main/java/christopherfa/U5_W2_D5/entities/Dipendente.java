package christopherfa.U5_W2_D5.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dipendenti")
@Data
@NoArgsConstructor
public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;
    private String nome;
    private String cognome;

    @Email(message = "Inserire una email valida")
    private String email;
    private String immagineProfiloUrl;
}