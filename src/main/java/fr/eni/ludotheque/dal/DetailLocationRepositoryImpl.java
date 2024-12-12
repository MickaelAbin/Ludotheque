package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.DetailLocation;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DetailLocationRepositoryImpl implements DetailLocationRepository {

    public void ajouter(DetailLocation entity, int jeuId) {

    }

    @Override
    public void ajouter(DetailLocation entity) {

    }

    @Override
    public List<DetailLocation> findAll() {
        return null;
    }

    @Override
    public Optional<DetailLocation> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void update(DetailLocation entity) {

    }

    @Override
    public void deleteById(int id) {

    }
}
