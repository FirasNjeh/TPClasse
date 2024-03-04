package tn.esprit.spring.projetspringclasse.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.projetspringclasse.entity.Cours;
import tn.esprit.spring.projetspringclasse.entity.Inscription;
import tn.esprit.spring.projetspringclasse.entity.Skieur;
import tn.esprit.spring.projetspringclasse.repository.CoursRepository;
import tn.esprit.spring.projetspringclasse.repository.InscriptionRepository;
import tn.esprit.spring.projetspringclasse.repository.SkieurRepository;
import tn.esprit.spring.projetspringclasse.service.InscriptionService;

import java.util.List;
@Service
@AllArgsConstructor
public class InscriptionServiceImpl implements InscriptionService {
    private SkieurRepository skieurRepository;
    private InscriptionRepository inscriptionRepository;
    private CoursRepository coursRepository;
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

    @Override
    public Inscription addRegistrationAndAssignToSkieur(Inscription registration, Long numSkieur) {
        Skieur skieur=skieurRepository.findById(numSkieur).orElse(null);
        registration.setSkieur(skieur);
        return inscriptionRepository.save(registration);
    }

    @Override
    public Inscription assignRegistrationToCourse(Long numRegistration, Long numCours) {
        Cours cours=coursRepository.findById(numCours).orElse(null);
        Inscription inscription=inscriptionRepository.findById(numRegistration).orElse(null);
        inscription.setCours(cours);
        return inscriptionRepository.save(inscription);
    }
}
