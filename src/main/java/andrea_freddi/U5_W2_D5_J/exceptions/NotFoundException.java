package andrea_freddi.U5_W2_D5_J.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String messaggio) {
        super(messaggio);
    }

    public NotFoundException(UUID id) {
        super(id + " non trovato!");
    }
}