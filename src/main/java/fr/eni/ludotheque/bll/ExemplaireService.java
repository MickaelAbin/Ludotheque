package fr.eni.ludotheque.bll;

import fr.eni.ludotheque.bo.Exemplaire;

import java.util.List;

public interface ExemplaireService extends CrudService<Exemplaire> {

    void ajouterExemplaire(Exemplaire exemplaire,int idjeu);
    public List<Exemplaire> findByJeuId(int id);
}
