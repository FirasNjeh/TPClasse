package tn.esprit.spring.projetspringclasse.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.projetspringclasse.entity.Cours;
import tn.esprit.spring.projetspringclasse.repository.CoursRepository;
import tn.esprit.spring.projetspringclasse.service.CoursService;

import java.util.List;

@AllArgsConstructor
@Service
public class CoursServiceImpl implements CoursService {

    private CoursRepository coursRepository;

    @Override
    public List<Cours> retrieveAllCourses() {
        return coursRepository.findAll();
    }

    @Override
    public Cours addCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public Cours updateCours(Cours cours) {
        // Check if a Cours with the same ID exists
        Cours existingCours = coursRepository.findById(cours.getNumCours()).orElse(null);

        if (existingCours != null) {
            existingCours.setNiveau(cours.getNiveau());
            existingCours.setTypeCours(cours.getTypeCours());
            existingCours.setPrix(cours.getPrix());
            existingCours.setSupport(cours.getSupport());
            return coursRepository.save(existingCours);
        } else {
            return null; // Indicate that update failed due to non-existent Cours
        }
    }

    @Override
    public Cours retrieveCours(Long numCours) {
        return coursRepository.findById(numCours).orElse(null);
    }

    @Override
    public Cours retriveInscription(Long numInscri) {
        return coursRepository.findByInscriptionsNumInscription(numInscri);
    }
}
