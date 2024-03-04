package tn.esprit.spring.projetspringclasse.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.projetspringclasse.entity.Inscription;
import tn.esprit.spring.projetspringclasse.service.InscriptionService;

import java.util.List;

@RestController
@RequestMapping("/inscription")
@AllArgsConstructor
public class InscriptionController {
    private InscriptionService inscriptionService;
    @GetMapping
    public List<Inscription> retrieveAllInscription() {
        return inscriptionService.retrieveAllInscription();
    }

    @PostMapping
    public Inscription addInscription(@RequestBody Inscription inscription) {
        return inscriptionService.addInscription(inscription);
    }


    @GetMapping("/{numInscription}")
    public Inscription retrieveInscription(@PathVariable Long numInscription) {
        return inscriptionService.retrieveInscription(numInscription);
    }
    @GetMapping("/inscription/{numCours}")
    public List<Inscription> retrieveInscriptionCours(@PathVariable Long numCours) {
        return inscriptionService.retrieveInscriptionCours(numCours);
    }
    @PostMapping("/add/{numSkieur}")
    public Inscription addRegistrationAndAssignToSkieur(@RequestBody Inscription registration,@PathVariable Long numSkieur){
        return inscriptionService.addRegistrationAndAssignToSkieur(registration,numSkieur);
    }

}
