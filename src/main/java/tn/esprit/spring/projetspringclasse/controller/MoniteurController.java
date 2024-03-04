package tn.esprit.spring.projetspringclasse.controller;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.projetspringclasse.entity.Moniteur;
import tn.esprit.spring.projetspringclasse.service.MoniteurService;

import java.util.List;

@RestController
@RequestMapping("/moniteurs")
@AllArgsConstructor
public class MoniteurController {

    private final MoniteurService moniteurService;



    @GetMapping
    public List<Moniteur> retrieveAllMoniteurs() {
        return moniteurService.retrieveAllMoniteurs();
    }

    @PostMapping
    public Moniteur addMoniteur(@RequestBody Moniteur moniteur) {
        return moniteurService.addMoniteur(moniteur);
    }

    @PutMapping("/{numMoniteur}")
    public Moniteur updateMoniteur(@PathVariable Long numMoniteur, @RequestBody Moniteur moniteur) {
        moniteur.setNumMoniteur(numMoniteur); // Ensure ID matches path variable
        return moniteurService.updateMoniteur(moniteur);
    }

    @GetMapping("/{numMoniteur}")
    public Moniteur retrieveMoniteur(@PathVariable Long numMoniteur) {
        return moniteurService.retrieveMoniteur(numMoniteur);
    }
@PutMapping("/liste/{numCourse}")
    public Moniteur addInstructorAndAssignToCourse(@RequestBody Moniteur moniteur,@PathVariable Long numCourse) {
        return moniteurService.addInstructorAndAssignToCourse(moniteur, numCourse);
    }
}

