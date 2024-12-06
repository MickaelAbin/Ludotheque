package fr.eni.ludotheque.bll;

import fr.eni.ludotheque.bo.Client;
import fr.eni.ludotheque.dal.ClientRepository;
import fr.eni.ludotheque.exceptions.ClientNotFound;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepo;

    public ClientServiceImpl(ClientRepository clientRepo) {
        super();
        this.clientRepo = clientRepo;
    }

    @Override
    public void ajouter(Client client) {
        clientRepo.ajouterClient(client);
    }

    @Override
    public void update(Client client) {
        clientRepo.update(client);
    }
    @Override
    public List<Client> findAll() {
        return clientRepo.findAllClients();
    }

    @Override
    public Client findById(int id) throws ClientNotFound {
        return clientRepo.findById(id)
                .orElseThrow(() -> new ClientNotFound("Client not found with ID: " + id));
    }

    @Override
    public void deleteById(int id){
        clientRepo.deleteById(id);
    }

}
