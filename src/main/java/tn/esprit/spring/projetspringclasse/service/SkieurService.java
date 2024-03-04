package tn.esprit.spring.projetspringclasse.service;

import tn.esprit.spring.projetspringclasse.entity.Skieur;

import java.util.List;

public interface SkieurService {
    List<Skieur> retrieveAllSkieurs();
    Skieur addSkieur(Skieur skieur);
    void removeSkieur (Long numSkieur);
    Skieur retrieveSkieur (Long numSkieur);

}
