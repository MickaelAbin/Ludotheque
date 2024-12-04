package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Jeu;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class JeuRepositoryBouchonImpl implements JeuRepository {

    private static int indexJeu=1;
    private List<Jeu> jeux;

    public JeuRepositoryBouchonImpl() {
        jeux = new ArrayList<>();
    }


    @Override
    public void ajouterJeu(Jeu jeu) {
        jeu.setNo_jeu(indexJeu++);
        jeux.add(jeu);
        System.out.println("ici repository");

    }

    @Override
    public void update(Jeu jeu) {

    }

    @Override
    public List<Jeu> findAllJeu() {
        return this.jeux;
    }

    @Override
    public Optional<Jeu> findById(int id) {
        return jeux.stream().filter(jeu -> jeu.getNo_jeu() == id).findFirst();
    }

    @Override
    public void deleteById(int id) { jeux.removeIf(jeu -> jeu.getNo_jeu() == id);}


}
