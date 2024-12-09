package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Utilisateur;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class UtilisateurRepositoryImpl implements UtilisateurRepository {


    private final JdbcTemplate jdbcTemplate;

    public UtilisateurRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Utilisateur findByMailPro(String mailPro) {
        String sql = "SELECT * FROM Utilisateur WHERE mailpro = ?";
        List<Utilisateur> utilisateurs = jdbcTemplate.query(sql, new Object[]{mailPro}, new UtilisateurRowMapper());

        if (utilisateurs.isEmpty()) {
            return null;
        } else {
            return utilisateurs.get(0);
        }
    }


    @Override
    public void ajouter(Utilisateur entity, int jeuId) {

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

    private static final class UtilisateurRowMapper implements RowMapper<Utilisateur> {
        @Override
        public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setId(rs.getInt("id_user"));
            utilisateur.setMailPro(rs.getString("mailpro"));
            utilisateur.setMdp(rs.getString("mdp"));
            utilisateur.setUserRole(rs.getString("user_role"));
            return utilisateur;
        }
    }
}
