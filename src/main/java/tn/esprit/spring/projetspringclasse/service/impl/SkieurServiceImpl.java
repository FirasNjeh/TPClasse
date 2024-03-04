package tn.esprit.spring.projetspringclasse.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.projetspringclasse.entity.Skieur;
import tn.esprit.spring.projetspringclasse.repository.SkieurRepository;
import tn.esprit.spring.projetspringclasse.service.SkieurService;

import java.util.List;
@AllArgsConstructor
@Service

public class SkieurServiceImpl implements SkieurService {

    private SkieurRepository skieurRepository;
    @Override
    public List<Skieur> retrieveAllSkieurs() {
        return skieurRepository.findAll();
    }

    @Override
    public Skieur addSkieur(Skieur skieur) {
        return skieurRepository.save(skieur);
    }

    @Override
    public void removeSkieur(Long numSkieur) {
        skieurRepository.deleteById(numSkieur);

    }

    @Override
    public Skieur retrieveSkieur(Long numSkieur) {
        return skieurRepository.findById(numSkieur).orElse(null);
    }

    @Override
    public List<Skieur> retrieveSkieurPiste(Long a) {
        return skieurRepository.findByPistesNumPiste(a);
    }
}
