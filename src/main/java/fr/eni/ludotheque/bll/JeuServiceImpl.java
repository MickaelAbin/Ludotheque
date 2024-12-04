package fr.eni.ludotheque.bll;

import fr.eni.ludotheque.bo.Jeu;
import fr.eni.ludotheque.dal.JeuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JeuServiceImpl implements JeuService {

    private JeuRepository jeuRepo;

    public JeuServiceImpl(JeuRepository jeuRepo) {
        super();
        this.jeuRepo = jeuRepo;
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
        return jeuRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {jeuRepo.deleteById(id);}

    }





