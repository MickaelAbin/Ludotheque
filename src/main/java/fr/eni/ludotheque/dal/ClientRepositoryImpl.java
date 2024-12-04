package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepositoryBouchonImpl implements ClientRepository {

    private static int indexClient=1;
    private List<Client> clients;

    public ClientRepositoryBouchonImpl() {
        clients = new ArrayList<>();
    }

    @Override
    public void ajouterClient(Client client) {
        client.setId(indexClient++);
        clients.add(client);
    }
    @Override
    public void update(Client client) {
        clients.removeIf(client1 -> client1.getId() == client.getId());
        clients.add(client);
    }

    @Override
    public List<Client> findAllClients() {
        return this.clients;
    }
    @Override
    public Optional<Client> findById(int id) {
        return clients.stream().filter(client -> client.getId() == id).findFirst();
    }
    @Override
    public void deleteById(int id) {
        clients.removeIf(client -> client.getId() == id);
    }


}
