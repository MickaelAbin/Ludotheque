package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Client;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private JdbcTemplate jdbcTemplate;

    public ClientRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void ajouterClient(Client client) {
        String sql = "INSERT INTO client (nom, prenom, cp, ville, rue, telephone_perso, mail) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, client.getNom(), client.getPrenom(), client.getCodePostal(), client.getVille(), client.getRue(), client.getTelephone(),client.getEmail());
    }

    @Override
    public void update(Client client) {
        String sql = "UPDATE client SET nom = ?, prenom = ?, cp = ?, ville = ?, rue = ?, telephone_perso = ?, mail = ? WHERE id_client = ?";
        jdbcTemplate.update(sql, client.getNom(), client.getPrenom(), client.getCodePostal(), client.getVille(), client.getRue(), client.getTelephone(),client.getEmail(), client.getId());

    }

    @Override
    public List<Client> findAllClients() {
        String sql = "SELECT * FROM client ";
        List<Client> clients = jdbcTemplate.query(sql, new ClientRowMapper());
        return clients;

    }

    @Override
    public Optional<Client> findById(int id) {
        String sql = "SELECT * FROM client WHERE id_client = ?";
        Client client = jdbcTemplate.queryForObject(sql,new ClientRowMapper(),id);
        System.out.println("ID passé à la méthode: " + id);
        return Optional.ofNullable(client);
    }

    @Override
    public void deleteById(int id) {
            String sql = "DELETE FROM client WHERE id_client = ?";
            jdbcTemplate.update(sql, id);
    }

    class ClientRowMapper implements RowMapper<Client> {
        @Override
        public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
            Client client = new Client();
            client.setId(rs.getInt("id_client")); // Ajoute cette ligne pour mapper l'ID
            client.setNom(rs.getString("nom"));
            client.setPrenom(rs.getString("prenom"));
            client.setCodePostal(rs.getString("cp"));
            client.setVille(rs.getString("ville"));
            client.setRue(rs.getString("rue"));
            client.setTelephone(rs.getString("telephone_perso"));
            client.setEmail(rs.getString("mail"));

            return client;
        }
    }
}
