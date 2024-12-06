package fr.eni.ludotheque.Controllers;

import fr.eni.ludotheque.bll.ClientService;
import fr.eni.ludotheque.bo.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
@Controller
public class AccueilController {

    private ClientService clientService;

    public AccueilController(ClientService clientService) {
        super();
        this.clientService = clientService;
    }

    @ModelAttribute("client")
    public Client createClient() {
        Client c = new Client();
        c.setNom("le nom");
        c.setPrenom("le prenom");
        c.setTelephone("le telephone");
        c.setEmail("le email");
        c.setRue("la rue");
        c.setCodePostal("1234");
        c.setVille("la ville");
        return c;
    }
        @GetMapping({"/", "/accueil"})
    public String accueil(Model model) {
        return "accueil";
        }
}