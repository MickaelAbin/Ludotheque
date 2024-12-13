package fr.eni.ludotheque.Controllers;

import fr.eni.ludotheque.bll.ClientService;
import fr.eni.ludotheque.bll.ExemplaireService;
import fr.eni.ludotheque.bll.JeuService;
import fr.eni.ludotheque.bll.LocationService;
import fr.eni.ludotheque.bo.*;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/locations")
public class LocationController {
    private static final Logger logger = LoggerFactory.getLogger(LocationController.class);
private LocationService locationService;
private ClientService clientService;
private JeuService jeuService;

private ExemplaireService exemplaireService;
    public LocationController(LocationService locationService, JeuService jeuService, ClientService clientService, ExemplaireService exemplaireService) {
        super();
        this.locationService = locationService;
        this.jeuService = jeuService;
        this.clientService = clientService;
        this.exemplaireService = exemplaireService;
    }

    @GetMapping
    public String afficherListeLocation(Model model) {
        model.addAttribute("locations", locationService.findAll());
        return "locations";
    }

    @GetMapping("/{id}/ajoutloc")
    public String ajouterLocation(Model model,@PathVariable int id) {
        logger.info("Tentative de creation du formulaire pour  le client ID: {}", id);
        model.addAttribute("location", new Location());
        List<Jeu> mesJeux = jeuService.getJeuxWithExemplaires();
        System.out.println(jeuService.getJeuxWithExemplaires());
        System.out.println(locationService.findAll());
        model.addAttribute("mesJeux", mesJeux);
        model.addAttribute("idclient",id);


        return "form-ajout-location";
    }
    @PostMapping("/{id}/ajoutloc")
    public String ajouterLocation(@Valid @ModelAttribute Location location,
                                  BindingResult resultat,
                                  @PathVariable int id,
                                  @RequestParam Map<String, String> params,
                                  Model model) {
        logger.info("Tentative d'ajout d'une nouvelle location pour le client ID: {}", id);

        // Récupérer les exemplaires sélectionnés
        List<String> selectedExemplaires = new ArrayList<>();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getKey().startsWith("selectedExemplaires")) {
                selectedExemplaires.add(entry.getValue());
            }
        }

        if (resultat.hasErrors()) {
            logger.error("Des erreurs ont été détectées lors de la validation de la location: {}", resultat.getAllErrors());
            model.addAttribute("mesJeux", jeuService.getJeuxWithExemplaires());
            model.addAttribute("idclient", id);
            return "form-ajout-location"; // Renvoie au formulaire en cas d'erreur
        }

        if (selectedExemplaires.isEmpty()) {
            logger.warn("Aucun exemplaire sélectionné pour la location.");
            model.addAttribute("mesJeux", jeuService.getJeuxWithExemplaires());
            model.addAttribute("idclient", id);
            return "form-ajout-location"; // Renvoie au formulaire en cas d'absence d'exemplaire
        }



        for (String exemplaireId : selectedExemplaires) {
            // Extraire l'ID de l'exemplaire à partir de la chaîne
            String[] parts = exemplaireId.split("-");
            if (parts.length == 2) {
                Integer noJeu = Integer.valueOf(parts[0]); // ID du jeu
                Integer idExemplaire = Integer.valueOf(parts[1]); // ID de l'exemplaire

                Optional<Exemplaire> exemplaireOptional = exemplaireService.findById(idExemplaire);
                if (exemplaireOptional.isPresent()) {
                    Exemplaire exemplaire = exemplaireOptional.get();
                    DetailLocation detailLocation = new DetailLocation();


                    detailLocation.setExemplaire(exemplaire);
                    detailLocation.setLocation(location);

                    // Récupérer le jeu correspondant à l'ID du jeu dans l'exemplaire
                    Jeu jeu = jeuService.findById(exemplaire.getIdjeu());
                    if (jeu != null) {
                        detailLocation.setTarifLocation(jeu.getTarif_journée()); // Enregistrer le tarif journalier
                        logger.info("Ajout du détail de location: {} - Tarif: {}", jeu.getTitre(), detailLocation.getTarifLocation());
                    } else {
                        logger.warn("Jeu non trouvé pour l'exemplaire ID: {}", idExemplaire);
                        resultat.rejectValue("exemplaires", "jeu.not.found", "Jeu non trouvé pour l'exemplaire ID: " + idExemplaire);
                        model.addAttribute("mesJeux", jeuService.getJeuxWithExemplaires());
                        model.addAttribute("idclient", id);
                        return "form-ajout-location";
                    }

                    // Ajoutez le détail de location à la liste
                    location.getDetailLocations().add(detailLocation);
                } else {
                    logger.error("Exemplaire non trouvé pour ID: {}", idExemplaire);
                    resultat.rejectValue("exemplaires", "exemplaire.not.found", "Exemplaire non trouvé");
                    model.addAttribute("mesJeux", jeuService.getJeuxWithExemplaires());
                    model.addAttribute("idclient", id);
                    return "form-ajout-location";
                }
            } else {
                logger.error("Format d'ID d'exemplaire invalide : {}", exemplaireId);
            }
        }

        locationService.ajouterLoc(location, id); // Appel à la méthode pour ajouter la location dans la base de données
        logger.info("Location ajoutée avec succès pour le client ID: {}", id);

        return "redirect:/clients/detail/" + id; // Redirection vers la page de détails du client

    }

}





