package fr.eni.ludotheque.bll;

import fr.eni.ludotheque.bo.Client;
import fr.eni.ludotheque.exceptions.ClientNotFound;

import java.util.List;

public interface ClientService {

    void ajouter(Client client);

    void update(Client client);

    Client findById(int id) throws ClientNotFound;

    List<Client> findAll();

    void deleteById(int id);

}
