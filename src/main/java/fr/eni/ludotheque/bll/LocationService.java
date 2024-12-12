package fr.eni.ludotheque.bll;

import fr.eni.ludotheque.bo.Jeu;
import fr.eni.ludotheque.bo.Location;

import java.util.List;

public interface LocationService  extends CrudService<Location> {
    void ajouterLoc(Location location, int id);


}
