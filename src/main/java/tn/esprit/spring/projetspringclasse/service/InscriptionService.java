package tn.esprit.spring.projetspringclasse.service;

import tn.esprit.spring.projetspringclasse.entity.Cours;
import tn.esprit.spring.projetspringclasse.entity.Inscription;

import java.util.List;

public interface InscriptionService {
    List<Inscription> retrieveAllInscription();
    Inscription addInscription(Inscription inscription);
    Inscription updateInscription (Inscription inscription);
    Inscription retrieveInscription (Long numInscription);
    List<Inscription> retrieveInscriptionCours(Long numCours);
}
