package fr.eni.ludotheque.bll;

import fr.eni.ludotheque.bo.DetailLocation;
import fr.eni.ludotheque.dal.DetailLocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetailLocationServiceImpl implements DetailLocationService {

    private DetailLocationRepository detailLocationRepository;
    public DetailLocationServiceImpl(DetailLocationRepository detailLocationRepository) {
        this.detailLocationRepository = detailLocationRepository;
    }
    @Override
    public void ajouter(DetailLocation entity) { detailLocationRepository.ajouter(entity);}



    @Override
    public List<DetailLocation> findAll() {
        return detailLocationRepository.findAll();
    }

    @Override
    public Optional<DetailLocation> findById(int id) {
        return detailLocationRepository.findById(id);
    }

    @Override
    public void update(DetailLocation entity) {
        detailLocationRepository.update(entity);

    }

    @Override
    public void deleteById(int id) {
        detailLocationRepository.deleteById(id);

    }
}
