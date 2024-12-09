package fr.eni.ludotheque.bll;

import fr.eni.ludotheque.bo.Utilisateur;

public interface UtilisateurService extends CrudService<Utilisateur> {
    Utilisateur findByMailPro(String mailPro);
}
