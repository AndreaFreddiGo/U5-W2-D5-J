package andrea_freddi.U5_W2_D5_J.services;

import andrea_freddi.U5_W2_D5_J.entities.Dipendente;
import andrea_freddi.U5_W2_D5_J.entities.Prenotazione;
import andrea_freddi.U5_W2_D5_J.entities.Viaggio;
import andrea_freddi.U5_W2_D5_J.exceptions.NotFoundException;
import andrea_freddi.U5_W2_D5_J.payloads.PrenotazionePayload;
import andrea_freddi.U5_W2_D5_J.repositories.PrenotazioniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class PrenotazioniService {
    @Autowired
    private PrenotazioniRepository prenotazioniRepository;
    @Autowired
    private ViaggiService viaggiService;
    @Autowired
    private DipendentiService dipendentiService;

    // Creo un metodo per salvare una nuova prenotazione
    public Prenotazione save(PrenotazionePayload body) {
        // Controllo se il viaggio o il dipendente per cui è stata richiesta la prenotazione esistono
        Viaggio viaggioTrovato = viaggiService.findById(body.viaggioId());
        Dipendente dipendenteTrovato = dipendentiService.findById(body.dipendenteId());
        if (viaggioTrovato == null || dipendenteTrovato == null) {
            throw new NotFoundException("Viaggio o dipendente non trovato");
        }
        // Controllo se il dipendente ha già una prenotazione per la stessa data
        prenotazioniRepository.findByDipendenteAndDataViaggio(body.dipendenteId(), viaggioTrovato.getData())
                .ifPresent(p -> {
                    throw new IllegalArgumentException("Il dipendente ha già una prenotazione per questa data");
                });
        Prenotazione nuovaPrenotazione = new Prenotazione(LocalDate.now(), dipendenteTrovato,
                body.note() == null || body.note().isEmpty() ? "Nessuna nota o preferenza richiesta" : body.note()
                , viaggioTrovato);
        return prenotazioniRepository.save(nuovaPrenotazione);
    }

    // Creo un metodo per trovare tutte le prenotazioni ma con la paginazione
    public Page<Prenotazione> getPrenotazioni(int page, int size, String sortBy) {
        if (size > 100) size = 100; // Limito la size max a 100 così da client non possono inserire numeri troppo grandi
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return this.prenotazioniRepository.findAll(pageable);
    }

    // Creo un metodo per trovare una prenotazione tramite id
    public Prenotazione findById(UUID id) {
        return this.prenotazioniRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Prenotazione non trovata")); // Se non la trovo lancio un'eccezione
    }

    // Creo un metodo per eliminare una prenotazione tramite id
    public void findByIdAndDelete(UUID id) {
        Prenotazione trovata = this.findById(id); // Trovo la prenotazione tramite id
        this.prenotazioniRepository.delete(trovata); // La elimino
    }

    // Creo un metodo per aggiornare una prenotazione tramite id
    public Prenotazione findByIdAndUpdate(UUID id, PrenotazionePayload body) {
        Prenotazione trovata = this.findById(id); // Trovo la prenotazione tramite id
        trovata.setNote(body.note()); // Aggiorno le note
        return this.prenotazioniRepository.save(trovata); // La salvo
    }
}
