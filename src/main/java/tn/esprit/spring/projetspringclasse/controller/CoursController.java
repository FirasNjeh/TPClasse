package tn.esprit.spring.projetspringclasse.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.projetspringclasse.entity.Cours;
import tn.esprit.spring.projetspringclasse.service.CoursService;

import java.util.List;
@Tag(name="Gestion Cours")
@RestController
@RequestMapping("/cours")
@AllArgsConstructor
public class CoursController {

    private final CoursService coursService;
    @Operation(description = "cette methode permet d'afficher tous les cours ")
    @GetMapping
    public List<Cours> retrieveAllCourses() {
        return coursService.retrieveAllCourses();
    }

    @PostMapping
    public Cours addCours(@RequestBody Cours cours) {
        return coursService.addCours(cours);
    }

    @PutMapping("/{numCours}")
    public Cours updateCours(@PathVariable Long numCours, @RequestBody Cours cours) {
        cours.setNumCours(numCours); // Ensure ID matches path variable
        return coursService.updateCours(cours);
    }

    @GetMapping("/{numCours}")
    public Cours retrieveCours(@PathVariable Long numCours) {

        return coursService.retrieveCours(numCours);
    }
    @GetMapping("/Inscription/{numInscri}")
    public Cours retrieveInscription(@PathVariable Long numInscri) {

        return coursService.retriveInscription(numInscri);
    }
}
