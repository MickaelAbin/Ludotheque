package fr.eni.ludotheque.bll;

import fr.eni.ludotheque.bo.Utilisateur;
import fr.eni.ludotheque.dal.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private UtilisateurRepository utilisateurRepository;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }
    @Override
    public void ajouter(Utilisateur entity) {

    }

    @Override
    public List<Utilisateur> findAll() {
        return null;
    }

    @Override
    public Optional<Utilisateur> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void update(Utilisateur entity) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Utilisateur findByMailPro(String mailPro) {
        return utilisateurRepository.findByMailPro(mailPro);
    }
}
