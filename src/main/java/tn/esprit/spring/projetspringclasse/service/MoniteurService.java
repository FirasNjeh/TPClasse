package tn.esprit.spring.projetspringclasse.service;

import tn.esprit.spring.projetspringclasse.entity.Moniteur;

import java.util.List;

public interface MoniteurService {
    List<Moniteur> retrieveAllMoniteurs();
    Moniteur addMoniteur(Moniteur moniteur);
    Moniteur updateMoniteur (Moniteur moniteur);
    Moniteur retrieveMoniteur (Long numMoniteur);
    Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse);
}
