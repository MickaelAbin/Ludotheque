package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    public void ajouterClient(Client client);

    public void update(Client client);

    public List<Client> findAllClients();

    Optional<Client> findById(int id);

    void deleteById(int id);


}
