package andrea_freddi.U5_W2_D5_J.repositories;

import andrea_freddi.U5_W2_D5_J.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DipendentiRepository extends JpaRepository<Dipendente, UUID> {
    Optional<Dipendente> findByEmail(String email);
}
