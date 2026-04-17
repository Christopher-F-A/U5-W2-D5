package christopherfa.U5_W2_D5.controllers;

import christopherfa.U5_W2_D5.entities.Viaggio;
import christopherfa.U5_W2_D5.repositories.ViaggioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viaggi")
@Slf4j
public class ViaggioController {

    @Autowired
    private ViaggioRepository viaggioRepo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Viaggio save(@RequestBody Viaggio body) {
        Viaggio salvato = viaggioRepo.save(body);
        log.info("Viaggio salvato con destinazione: " + salvato.getDestinazione() + " - ID: " + salvato.getId());
        return salvato;
    }

    @GetMapping
    public List<Viaggio> getAll() {
        List<Viaggio> lista = viaggioRepo.findAll();
        log.info("Viaggi trovati: " + lista.size() + " elementi.");
        return lista;
    }
}