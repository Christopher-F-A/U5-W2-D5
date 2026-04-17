package christopherfa.U5_W2_D5.controllers;

import christopherfa.U5_W2_D5.entities.Dipendente;
import christopherfa.U5_W2_D5.repositories.DipendenteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dipendenti")
@Slf4j
public class DipendenteController {
    @Autowired
    private DipendenteRepository dipRepo;

    @PostMapping
    public Dipendente save(@RequestBody @Validated Dipendente body) {
        Dipendente salvato = dipRepo.save(body);
        log.info("Salvato dipendente con ID: " + salvato.getId() + " Username: " + salvato.getUsername());
        return salvato;
    }

    @GetMapping
    public List<Dipendente> getAll() {
        List<Dipendente> lista = dipRepo.findAll();
        log.info("Lista dipendenti: " + lista.size());
        return lista;
    }
}