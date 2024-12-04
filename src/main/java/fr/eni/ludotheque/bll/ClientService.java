package fr.eni.ludotheque.bll;

import fr.eni.ludotheque.bo.Client;

import java.util.List;

public interface ClientService {

    void ajouter(Client client);

    void update(Client client);

    Client findById(int id);

    List<Client> findAll();

    void deleteById(int id);

}
