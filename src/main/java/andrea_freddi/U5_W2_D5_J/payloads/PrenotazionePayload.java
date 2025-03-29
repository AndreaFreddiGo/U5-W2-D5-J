package andrea_freddi.U5_W2_D5_J.payloads;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

public record PrenotazionePayload(
        @NotNull(message = "La data è obbligatoria")
        LocalDate dataRichiesta,
        @Size(max = 500, message = "Le note non possono superare i 500 caratteri")
        String note,
        @NotNull(message = "Il viaggio è obbligatorio")
        UUID viaggioId,
        @NotNull(message = "Il dipendente è obbligatorio")
        UUID dipendenteId
) {
}
