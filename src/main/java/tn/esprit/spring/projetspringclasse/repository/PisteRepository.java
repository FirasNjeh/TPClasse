package tn.esprit.spring.projetspringclasse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.projetspringclasse.entity.Piste;

import java.util.List;

public interface PisteRepository extends JpaRepository<Piste,Long> {
    List<Piste> findBySkieursNumSkieur(Long numSkieur);
    List<Piste> findBySkieursNomSLikeAndSkieursInscriptionsNumInscription(String nomS, Long numInscri);
    List<Piste> findBySkieursNomSLike(String nom);
}

