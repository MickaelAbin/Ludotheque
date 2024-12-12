package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Location;

public interface LocationRepository  extends CrudRepository<Location> {
    void ajouterLoc(Location location, int id);
}
