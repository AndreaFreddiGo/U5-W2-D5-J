package andrea_freddi.U5_W2_D5_J.payloads;

import java.time.LocalDateTime;

public record ErrorsDTO(
        String message,
        LocalDateTime timestamp) {
}
