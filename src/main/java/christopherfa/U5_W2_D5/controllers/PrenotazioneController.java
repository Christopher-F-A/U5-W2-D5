package christopherfa.U5_W2_D5.controllers;

import christopherfa.U5_W2_D5.entities.Prenotazione;
import christopherfa.U5_W2_D5.payloads.PrenotazioneDTO;
import christopherfa.U5_W2_D5.repositories.PrenotazioneRepository;
import christopherfa.U5_W2_D5.services.PrenotazioneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prenotazioni")
@Slf4j
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService preService;

    @Autowired
    private PrenotazioneRepository preRepo;

    // post prenotazioni
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Prenotazione save(@RequestBody @Validated PrenotazioneDTO body) {
        log.info("Prenotazione eseguita");
        return preService.salvaPrenotazione(body);
    }

    // get prenotazioni
    @GetMapping
    public List<Prenotazione> getAll() {
        List<Prenotazione> lista = preRepo.findAll();
        log.info("Prenotazioni totali: " + lista.size());
        return lista;
    }
}