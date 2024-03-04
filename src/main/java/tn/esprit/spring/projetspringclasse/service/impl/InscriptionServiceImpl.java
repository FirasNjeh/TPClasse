package tn.esprit.spring.projetspringclasse.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.projetspringclasse.entity.Inscription;
import tn.esprit.spring.projetspringclasse.repository.InscriptionRepository;
import tn.esprit.spring.projetspringclasse.service.InscriptionService;

import java.util.List;
@Service
@AllArgsConstructor
public class InscriptionServiceImpl implements InscriptionService {
    private InscriptionRepository inscriptionRepository;
    @Override
    public List<Inscription> retrieveAllInscription() {
        return inscriptionRepository.findAll();
    }

    @Override
    public Inscription addInscription(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    @Override
    public Inscription updateInscription(Inscription inscription) {
        return null;
    }

    @Override
    public Inscription retrieveInscription(Long numInscription) {
        return inscriptionRepository.findById(numInscription).orElse(null);
    }

    @Override
    public List<Inscription> retrieveInscriptionCours(Long numCours) {
        return inscriptionRepository.findByCoursNumCours(numCours);
    }
}
