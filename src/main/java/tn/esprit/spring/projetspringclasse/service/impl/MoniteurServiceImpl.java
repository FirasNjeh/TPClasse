package tn.esprit.spring.projetspringclasse.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.projetspringclasse.entity.Cours;
import tn.esprit.spring.projetspringclasse.entity.Moniteur;
import tn.esprit.spring.projetspringclasse.repository.CoursRepository;
import tn.esprit.spring.projetspringclasse.repository.MoniteurRepository;
import tn.esprit.spring.projetspringclasse.service.MoniteurService;

import java.util.List;

@AllArgsConstructor
@Service
public class MoniteurServiceImpl implements MoniteurService {

    private MoniteurRepository moniteurRepository;
    private CoursRepository coursRepository;

    @Override
    public List<Moniteur> retrieveAllMoniteurs() {
        return moniteurRepository.findAll();
    }

    @Override
    public Moniteur addMoniteur(Moniteur moniteur) {
        return moniteurRepository.save(moniteur);
    }

    @Override
    public Moniteur updateMoniteur(Moniteur moniteur) {
        // Check if a Moniteur with the same ID exists
        Moniteur existingMoniteur = moniteurRepository.findById(moniteur.getNumMoniteur()).orElse(null);

        if (existingMoniteur != null) {
            existingMoniteur.setNomM(moniteur.getNomM());
            existingMoniteur.setPrenomM(moniteur.getPrenomM());
            existingMoniteur.setDateRecru(moniteur.getDateRecru());
            return moniteurRepository.save(existingMoniteur);
        } else {
            return null; // Indicate that update failed due to non-existent Moniteur
        }
    }

    @Override
    public Moniteur retrieveMoniteur(Long numMoniteur) {
        return moniteurRepository.findById(numMoniteur).orElse(null);
    }

    @Override
    public Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse) {
        Cours cours =coursRepository.findById(numCourse).orElse(null);
        moniteur.getCours().add(cours);
        return moniteurRepository.save(moniteur);

    }
}
