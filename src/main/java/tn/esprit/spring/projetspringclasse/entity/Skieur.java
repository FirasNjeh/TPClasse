package tn.esprit.spring.projetspringclasse.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Skieur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numSkieur;
    private String nomS;
    private String prenomS;
    private LocalDate dateNaissance;
    private String ville;
    @JsonIgnore
    @OneToMany( mappedBy = "skieur")
    private Set<Inscription> inscriptions;
    @JsonIgnore
    @ManyToMany(mappedBy = "skieurs")
    private Set<Piste> pistes;
    @JsonIgnore
    @OneToOne
    private Abonnement abonnement;



}
