package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Exemplaire;

import java.util.List;

public interface ExemplaireRepository extends CrudRepository<Exemplaire> {
    void ajouterEmplaire(Exemplaire exemplaire,int idjeu);

     List<Exemplaire> findByJeuId(int id);
}
