package tn.esprit.spring.projetspringclasse.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.projetspringclasse.entity.Skieur;
import tn.esprit.spring.projetspringclasse.service.SkieurService;

import java.util.List;

@RestController
@RequestMapping("/skieurs")
@AllArgsConstructor
public class SkieurController {


    @GetMapping("/{numPiste}")
    public List<Skieur> retrieveSkieurPiste(@PathVariable Long numPiste) {

        return skieurService.retrieveSkieurPiste(numPiste);}

    private final SkieurService skieurService;

    @GetMapping
    public List<Skieur> retrieveAllSkieurs() {
        return skieurService.retrieveAllSkieurs();
    }

    @PostMapping
    public Skieur addSkieur(@RequestBody Skieur skieur) {
        return skieurService.addSkieur(skieur);
    }

    @DeleteMapping("/{numSkieur}")
    public void removeSkieur(@PathVariable Long numSkieur) {
        skieurService.removeSkieur(numSkieur);
    }

    @GetMapping("/{numSkieur}")
    public Skieur retrieveSkieur(@PathVariable Long numSkieur) {
        return skieurService.retrieveSkieur(numSkieur);
    }

}

