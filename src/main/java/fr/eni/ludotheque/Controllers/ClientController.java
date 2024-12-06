package fr.eni.ludotheque.Controllers;

import fr.eni.ludotheque.bll.ClientService;
import fr.eni.ludotheque.bo.Client;
import fr.eni.ludotheque.exceptions.ClientNotFound;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClientController {

    private ClientService clientService;


    @Autowired
    public ClientController(ClientService clientService) {
        super();
        this.clientService = clientService;
    }
    @GetMapping("/Client/ajout")
    public String ajouterClient(Model model) {
        model.addAttribute("client", new Client());
        return "form-ajout-client";
    }



    @PostMapping("/Client/ajout")
    public String ajouterClient( @Valid @ModelAttribute Client client, BindingResult resultat) {
        if(resultat.hasErrors()) {
            return "form-ajout-client";
        }
        clientService.ajouter(client);
        System.out.println(client);
        return "redirect:/clients";
    }

    @GetMapping({ "/clients"})
    public String clients(Model model) {
        List<Client> clients = clientService.findAll();
        model.addAttribute("clients",clients) ;
        return "clients";
    }
    @GetMapping("/detailClient/{id}")
    public String  detailClient(@PathVariable("id")int id, Model model) throws ClientNotFound {
        System.out.println("ID passé à la méthode: " + id);

    Client client = clientService.findById(id);
    model.addAttribute("client",client);
        return "detailClient";
    }

    @GetMapping("/clients/delete/{id}")
    public String deleteClient(@PathVariable int id) {
        clientService.deleteById(id);
        return "redirect:/clients";
    }
    @GetMapping("/clients/modif/{id}")
    public String modifClient(@PathVariable int id, Model model) throws ClientNotFound {
        model.addAttribute("client",clientService.findById(id));
        return "form-modif-client";
    }
    @PostMapping("/clients/modif/{id}")
    public String modifClient(@PathVariable int id,@ModelAttribute Client client) {
        client.setId(id);
        clientService.update(client);
        return "detailClient";
    }
}
