package fr.eni.ludotheque.bll;

import fr.eni.ludotheque.bo.Jeu;
import fr.eni.ludotheque.bo.Location;
import fr.eni.ludotheque.dal.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LocationServiceImpl implements LocationService{

    private LocationRepository locationRepository;
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }
    @Override
    public void ajouter(Location entity) { locationRepository.ajouter(entity);}



    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    @Override
    public Optional<Location> findById(int id) {
        return locationRepository.findById(id);
    }

    @Override
    public void update(Location entity) {
        locationRepository.update(entity);

    }

    @Override
    public void deleteById(int id) {
        locationRepository.deleteById(id);

    }

    @Override
    public void ajouterLoc(Location location, int id) {
        locationRepository.ajouterLoc(location,id);

    }


}
