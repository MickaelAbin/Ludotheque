package fr.eni.ludotheque.bll;

import fr.eni.ludotheque.bo.Exemplaire;
import fr.eni.ludotheque.bo.Jeu;
import fr.eni.ludotheque.dal.JeuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JeuServiceImpl implements JeuService {

    private JeuRepository jeuRepo;
    private ExemplaireServiceImpl exemplaireService;

    public JeuServiceImpl(JeuRepository jeuRepo,ExemplaireServiceImpl exemplaireService) {
        super();
        this.jeuRepo = jeuRepo;
        this.exemplaireService = exemplaireService;
    }


    @Override
    public void ajouter(Jeu jeu) { jeuRepo.ajouterJeu(jeu) ;System.out.println("ici service");}

    @Override
    public void update(Jeu jeu) { jeuRepo.update(jeu);}



    @Override
    public List<Jeu> findAll() {
        return jeuRepo.findAllJeu();
    }

    @Override
    public Jeu findById(int id) {
        Jeu jeu = jeuRepo.findById(id).orElse(null);
        if(jeu != null) {
            List<Exemplaire> exemplaires = exemplaireService.findByJeuId(id);
            jeu.setExemplaires(exemplaires);
        }
        return jeu;
    }

    @Override
    public void deleteById(int id) {jeuRepo.deleteById(id);}

    }





