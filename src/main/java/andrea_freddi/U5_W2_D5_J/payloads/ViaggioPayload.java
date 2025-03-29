package andrea_freddi.U5_W2_D5_J.payloads;

import andrea_freddi.U5_W2_D5_J.entities.Stato;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ViaggioPayload(
        @NotEmpty(message = "La destinazione è obbligatoria")
        String destinazione,
        @NotNull(message = "La data è obbligatoria")
        @Future(message = "La data deve essere nel futuro")
        LocalDate data,
        @NotNull(message = "Lo stato è obbligatorio")
        Stato stato
) {
}
