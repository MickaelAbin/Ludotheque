package fr.eni.ludotheque.Controllers;

import fr.eni.ludotheque.bll.ExemplaireService;
import fr.eni.ludotheque.bll.JeuService;
import fr.eni.ludotheque.bo.Exemplaire;
import fr.eni.ludotheque.bo.Jeu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/exemplaires")
public class ExemplaireController {

    private ExemplaireService exemplaireService;
    private JeuService jeuService;
    @Autowired
    public ExemplaireController(ExemplaireService exemplaireService,JeuService jeuService) {
        this.exemplaireService = exemplaireService;
        this.jeuService = jeuService;
    }

    @GetMapping("/{id}/creer")
    public String creerExemplaire(Model model,@PathVariable int id) {
        model.addAttribute("idjeu",id);
        model.addAttribute("exemplaire", new Exemplaire());
        System.out.println("ici");
        return "exemplaire-form-creation";
    }

    @PostMapping("/{id}/creer")
    public String creerExemplaire(@ModelAttribute Exemplaire exemplaire, @PathVariable int id) {
        // Ajouter l'exemplaire dans la base de données
        exemplaireService.ajouterExemplaire(exemplaire, id);

        // Récupérer le jeu correspondant à l'ID
        Optional<Jeu> jeuOpt = Optional.ofNullable(jeuService.findById(id));
        if (jeuOpt.isPresent()) {
            Jeu jeu = jeuOpt.get();

            // Initialiser la liste des exemplaires si elle est null
            if (jeu.getExemplaires() == null) {
                jeu.setExemplaires(new ArrayList<>());
            }

            // Ajouter l'exemplaire à la liste des exemplaires du jeu
            jeu.getExemplaires().add(exemplaire);

            // Afficher tout le contenu de la liste des exemplaires
            System.out.println("Exemplaires du jeu " + jeu.getTitre() + ":");
            for (Exemplaire ex : jeu.getExemplaires()) {
                System.out.println(ex);
            }

            // Mettre à jour le jeu dans la base de données
            jeuService.update(jeu);
        } else {
            // Gérer le cas où le jeu n'est pas trouvé (optionnel)
            return "redirect:/error";
        }

        return "redirect:/jeux/" + id + "/detail";
    }

}
