package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Utilisateur;

public interface UtilisateurRepository extends CrudRepository<fr.eni.ludotheque.bo.Utilisateur> {

    Utilisateur findByMailPro(String mailPro);
}
