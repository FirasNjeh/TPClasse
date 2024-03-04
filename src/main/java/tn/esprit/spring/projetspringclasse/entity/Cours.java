package tn.esprit.spring.projetspringclasse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.spring.projetspringclasse.enumeration.Support;
import tn.esprit.spring.projetspringclasse.enumeration.TypeCours;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numCours;

 private Integer niveau;
   @Enumerated(EnumType.STRING)
    private Support support;
   @Enumerated(EnumType.STRING)
   private TypeCours typeCours;
  private Float prix;
   private Integer creneau;
    @OneToMany( mappedBy = "cours")
    private Set<Inscription> inscriptions;

}
