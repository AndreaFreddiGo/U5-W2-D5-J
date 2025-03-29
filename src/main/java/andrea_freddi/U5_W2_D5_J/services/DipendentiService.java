package andrea_freddi.U5_W2_D5_J.services;

import andrea_freddi.U5_W2_D5_J.repositories.DipendentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DipendentiService {
    @Autowired
    private DipendentiRepository dipendentiRepository;
}
