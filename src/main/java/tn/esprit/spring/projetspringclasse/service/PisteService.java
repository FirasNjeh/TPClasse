package tn.esprit.spring.projetspringclasse.service;

import tn.esprit.spring.projetspringclasse.entity.Piste;

import java.util.List;

public interface PisteService {
    List<Piste> retrieveAllPistes();
    Piste addPiste(Piste piste);
    Piste updatePiste (Piste piste);
    Piste retrievePiste (Long numPiste);
    List<Piste> retrievePisteSkieur(Long numSkieur);
    List<Piste> retrievePiesteSkieurInscri(String nomS, Long numInscri);
    List<Piste> retrievePiesteSkieurNomS(String nom);
}
