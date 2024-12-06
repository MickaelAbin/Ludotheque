package fr.eni.ludotheque.bll;

import fr.eni.ludotheque.bo.Client;
import fr.eni.ludotheque.dal.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import fr.eni.ludotheque.exceptions.ClientNotFound;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ClientServiceImplTest {

    @MockitoBean
    private ClientRepository clientRepository;
    @Autowired
    private ClientServiceImpl clientService;




    @Test
    public void testTrouvéunClientById() throws ClientNotFound {

        int id = 1;
        Client clientAttendu = new Client( id,"abin");
        when(clientRepository.findById(id)).thenReturn(Optional.of(clientAttendu));

        Client resultat = clientService.findById(id);

        assertNotNull(resultat);
        assertEquals(clientAttendu.getId(), resultat.getId());
        assertEquals(clientAttendu.getNom(), resultat.getNom());
        verify(clientRepository, times(1)).findById(id);


    }
@Test
    public void testNonTrouvéunClientById()  {
        int id = 999;
        when(clientRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ClientNotFound.class, () -> {
            clientService.findById(id);
        });
        verify(clientRepository, times(1)).findById(id);
    }


}
