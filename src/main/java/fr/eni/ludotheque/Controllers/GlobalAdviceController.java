package fr.eni.ludotheque.Controllers;


import fr.eni.ludotheque.bll.UtilisateurService;
import fr.eni.ludotheque.bo.Utilisateur;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice(annotations = Controller.class)
public class GlobalAdviceController {

    @Autowired
    private UtilisateurService utilisateurService;

    @ModelAttribute("utilisateur")
    public Utilisateur getUtilisateur() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String utilisateur = auth.getName(); // Récupère le nom d'utilisateur
        return utilisateurService.findByMailPro(utilisateur);
    }

}
