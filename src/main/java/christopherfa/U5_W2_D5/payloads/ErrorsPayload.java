package christopherfa.U5_W2_D5.payloads;

import java.time.LocalDateTime;

public record ErrorsPayload(String message, LocalDateTime timestamp) {}