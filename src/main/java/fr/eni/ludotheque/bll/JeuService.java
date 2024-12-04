package fr.eni.ludotheque.bll;

import fr.eni.ludotheque.bo.Jeu;

import java.util.List;

public interface JeuService {

    public void ajouter(Jeu jeu);

    public void update(Jeu jeu);

    public List<Jeu> findAll();

    Jeu findById(int id);

    void deleteById(int id);
}
