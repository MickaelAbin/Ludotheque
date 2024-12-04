package fr.eni.ludotheque.Controllers;

import fr.eni.ludotheque.bll.GenreService;
import fr.eni.ludotheque.bll.JeuService;
import fr.eni.ludotheque.bo.Genre;
import fr.eni.ludotheque.bo.Jeu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/jeux")
public class JeuController {

    private JeuService jeuService;
    private GenreService genreService;

    @Autowired
    public JeuController(JeuService jeuService,GenreService genreService) {
        super();
        this.jeuService = jeuService;
        this.genreService = genreService;
    }

    @GetMapping("/creer")
    public String creerJeu(Model model) {
        model.addAttribute("jeu", new Jeu());
        model.addAttribute("genres", genreService.findAll());
        System.out.println("genres");
        System.out.println(genreService.findAll());
        return "jeu-form-creation";
    }
    @PostMapping("/creer")
    public String creerJeu( @ModelAttribute Jeu jeu, @RequestParam List<Integer> genres) {
        System.out.println("genres sélectionnés : " + genres);
        List<Genre> genreList = genres.stream()
                .map(genreService::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
        jeu.setGenres(genreList);
        jeuService.ajouter(jeu);
        System.out.println(jeu);
        return "redirect:/jeux";
    }
@GetMapping
public String afficherJeu(Model model) {
    List<Jeu> mesJeux = jeuService.findAll();
    model.addAttribute("mesJeux", mesJeux);
    return "jeux";    }

    @GetMapping("/{id}/detail")
    public String detailJeu(@PathVariable int id,Model model) {
        model.addAttribute("jeu", jeuService.findById(id));
        System.out.println(jeuService.findById(id));
        return "jeu-detail";
    }

    @GetMapping("/{id}/edition")
    public String modifierJeu(@PathVariable int id, Model model) {
        model.addAttribute("jeu", jeuService.findById(id));
        model.addAttribute("genres", genreService.findAll());
        return "jeu-form-edition";
    }

    @PostMapping("/{id}/edition")
    public String modifierJeu(@PathVariable int id, @ModelAttribute Jeu jeu) {
        jeu.setNo_jeu(id);
        jeuService.update(jeu);
        return "redirect:/jeux/{id}/detail";
    }

    @GetMapping("/{id}/suppression")
    public String supprimerJeu(@PathVariable int id) {
        jeuService.deleteById(id);
        return "redirect:/jeux";
    }


}
