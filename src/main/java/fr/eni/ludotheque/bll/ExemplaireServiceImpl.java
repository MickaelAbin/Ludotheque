package fr.eni.ludotheque.bll;

import fr.eni.ludotheque.bo.Exemplaire;

import fr.eni.ludotheque.dal.ExemplaireRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ExemplaireServiceImpl implements ExemplaireService{

    private ExemplaireRepository exemplaireRepository;

    public ExemplaireServiceImpl(ExemplaireRepository exemplaireRepository){
        super();
        this.exemplaireRepository = exemplaireRepository;
    }


    public void ajouterExemplaire(Exemplaire exemplaire,int idjeu) {
        System.out.println("service");
        exemplaireRepository.ajouterEmplaire(exemplaire,idjeu);

    }


    public List<Exemplaire> findByJeuId(int id) {
        return exemplaireRepository.findByJeuId(id);
    }


    @Override
    public void ajouter(Exemplaire entity) {

    }

    @Override
    public List<Exemplaire> findAll() {
        return exemplaireRepository.findAll();
    }

    @Override
    public Optional<Exemplaire> findById(int id) {
        return exemplaireRepository.findById(id) ;
    }

    @Override
    public void update(Exemplaire exemplaire) {
exemplaireRepository.update(exemplaire);
    }



    @Override
    public void deleteById(int id) {
exemplaireRepository.deleteById(id);
    }
}
