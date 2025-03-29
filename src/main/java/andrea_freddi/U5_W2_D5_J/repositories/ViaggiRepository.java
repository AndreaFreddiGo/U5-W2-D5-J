package andrea_freddi.U5_W2_D5_J.repositories;

import andrea_freddi.U5_W2_D5_J.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ViaggiRepository extends JpaRepository<Viaggio, UUID> {
}
