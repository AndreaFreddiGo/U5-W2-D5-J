package andrea_freddi.U5_W2_D5_J.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record DipendentePayload(
        @NotEmpty(message = "Lo username è obbligatorio")
        @Size(min = 2, max = 20, message = "Lo username deve essere compreso tra 2 e 20 caratteri!")
        String username,
        @NotEmpty(message = "Il nome proprio è obbligatorio")
        @Size(min = 2, max = 20, message = "Il nome deve essere compreso tra 2 e 20 caratteri!")
        String nome,
        @NotEmpty(message = "Il cognome è obbligatorio")
        @Size(min = 2, max = 20, message = "Il cognome deve essere compreso tra 2 e 20 caratteri!")
        String cognome,
        @NotEmpty(message = "L'indirizzo email è obbligatorio")
        @Email(message = "L'email inserita non è un'email valida")
        String email
) {
}
