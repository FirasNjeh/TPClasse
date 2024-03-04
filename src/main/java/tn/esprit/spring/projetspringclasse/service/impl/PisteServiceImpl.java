package tn.esprit.spring.projetspringclasse.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.projetspringclasse.entity.Piste;
import tn.esprit.spring.projetspringclasse.entity.Skieur;
import tn.esprit.spring.projetspringclasse.repository.PisteRepository;
import tn.esprit.spring.projetspringclasse.repository.SkieurRepository;
import tn.esprit.spring.projetspringclasse.service.PisteService;

import java.util.List;

@AllArgsConstructor
@Service
public class PisteServiceImpl implements PisteService {

    private PisteRepository pisteRepository;
    private SkieurRepository skieurRepository;

    @Override
    public List<Piste> retrieveAllPistes() {
        return pisteRepository.findAll();
    }

    @Override
    public Piste addPiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste updatePiste(Piste piste) {
        // Check if a Piste with the same ID exists
        Piste existingPiste = pisteRepository.findById(piste.getNumPiste()).orElse(null);

        if (existingPiste != null) {
            existingPiste.setNomPiste(piste.getNomPiste());
            existingPiste.setCouleur(piste.getCouleur());
            existingPiste.setLongueur(piste.getLongueur());
            existingPiste.setPente(piste.getPente());
            return pisteRepository.save(existingPiste);
        } else {
            return null; // Indicate that update failed due to non-existent Piste
        }
    }

    @Override
    public Piste retrievePiste(Long numPiste) {
        return pisteRepository.findById(numPiste).orElse(null);
    }

    @Override
    public List<Piste> retrievePisteSkieur(Long numSkieur) {
        return pisteRepository.findBySkieursNumSkieur(numSkieur);
    }

    @Override
    public List<Piste> retrievePiesteSkieurInscri(String nomS, Long numInscri) {
        return pisteRepository.findBySkieursNomSLikeAndSkieursInscriptionsNumInscription(nomS, numInscri);
    }

    @Override
    public List<Piste> retrievePiesteSkieurNomS(String nom) {
        return pisteRepository.findBySkieursNomSLike(nom);
    }

    @Override
    public Skieur assignSkieurToPiste(Long numSkieur, Long numPiste) {
        Skieur skieur=skieurRepository.findById(numSkieur).orElse(null);
        Piste piste=pisteRepository.findById(numPiste).orElse(null);
        piste.getSkieurs().add(skieur);
        pisteRepository.save(piste);
        return skieur;
    }
}
