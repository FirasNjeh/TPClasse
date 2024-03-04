package tn.esprit.spring.projetspringclasse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.projetspringclasse.entity.Moniteur;

public interface MoniteurRepository extends JpaRepository<Moniteur,Long> {
}
