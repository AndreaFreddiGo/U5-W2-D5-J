package andrea_freddi.U5_W2_D5_J.controllers;

import andrea_freddi.U5_W2_D5_J.services.PrenotazioniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*

1. GET http://localhost:3001/prenotazioni
2. POST http://localhost:3001/prenotazioni (+ req.body) --> 201
3. GET http://localhost:3001/prenotazioni/{prenotazioneId}
4. PUT http://localhost:3001/prenotazioni/{prenotazioneId} (+ req.body)
5. DELETE http://localhost:3001/prenotazioni/{prenotazioneId} --> 204

*/

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioniController {
    @Autowired
    PrenotazioniService prenotazioniService;
}
