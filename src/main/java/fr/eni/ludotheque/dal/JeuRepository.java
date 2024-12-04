package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Jeu;

import java.util.List;
import java.util.Optional;

public interface JeuRepository {

    public void ajouterJeu(Jeu jeu);

    public void update(Jeu jeu);

    public List<Jeu> findAllJeu();

    Optional<Jeu> findById(int id);

    void deleteById(int id);
}
