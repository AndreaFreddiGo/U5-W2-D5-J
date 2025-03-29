package andrea_freddi.U5_W2_D5_J.repositories;

import andrea_freddi.U5_W2_D5_J.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PrenotazioniRepository extends JpaRepository<Prenotazione, UUID> {
}
