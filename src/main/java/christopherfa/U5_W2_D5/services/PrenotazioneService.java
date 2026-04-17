package christopherfa.U5_W2_D5.services;

import christopherfa.U5_W2_D5.entities.*;
import christopherfa.U5_W2_D5.payloads.PrenotazioneDTO;
import christopherfa.U5_W2_D5.repositories.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PrenotazioneService {

    @Autowired private PrenotazioneRepository preRepo;
    @Autowired private DipendenteRepository dipRepo;
    @Autowired private ViaggioRepository viaRepo;

    public Prenotazione salvaPrenotazione(PrenotazioneDTO body) {
        // ricerca dipendente e viaggio
        Dipendente d = dipRepo.findById(body.getDipendenteId())
                .orElseThrow(() -> new RuntimeException("Dipendente non trovato con ID: " + body.getDipendenteId()));

        Viaggio v = viaRepo.findById(body.getViaggioId())
                .orElseThrow(() -> new RuntimeException("Viaggio non trovato con ID: " + body.getViaggioId()));

        // un viaggio per data
        boolean occupato = preRepo.findAll().stream()
                .anyMatch(p -> p.getDipendente().getId().equals(d.getId())
                        && p.getViaggio().getDataViaggio().equals(v.getDataViaggio()));

        if (occupato) {
            throw new RuntimeException("Il dipendente " + d.getCognome() + " è occupato il giorno " + v.getDataViaggio());
        }

        // creazione e salvataggio prenotazione
        Prenotazione nuova = new Prenotazione();
        nuova.setDipendente(d);
        nuova.setViaggio(v);
        nuova.setNote(body.getNote());

        log.info("Salvataggio prenotazione: Dipendente " + d.getId() + " per Viaggio " + v.getId());
        return preRepo.save(nuova);
    }}