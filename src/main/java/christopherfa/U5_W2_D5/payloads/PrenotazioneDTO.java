package christopherfa.U5_W2_D5.payloads;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrenotazioneDTO {
    @NotNull(message = "ID obbligatorio")
    private Long dipendenteId;

    @NotNull(message = "ID obbligatorio")
    private Long viaggioId;

    private String note;
}