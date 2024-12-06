package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Exemplaire;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
@Repository
public class ExemplaireRepositoryImpl implements ExemplaireRepository {

    private final JdbcTemplate jdbcTemplate;

    public ExemplaireRepositoryImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }



    public void ajouterEmplaire(Exemplaire exemplaire,int idjeu) {
        System.out.println("repository");
        String sql = "INSERT INTO exemplaire_jeu (code_barre, louable, id_jeu) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, exemplaire.getCodebarre(), exemplaire.getLouable(), idjeu);

    }

    @Override
    public void ajouter(Exemplaire exemplaire, int idjeu) {

    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Optional<Exemplaire> findById(int id) {
        String sql = "SELECT * FROM exemplaire_jeu WHERE id_jeu = ?";
        Exemplaire exemplaire = jdbcTemplate.queryForObject(sql, new ExemplaireRowMapper(), id);
        return Optional.ofNullable(exemplaire);
    }

    @Override
    public List<Exemplaire> findByJeuId(int id) {
        String sql = "SELECT * FROM exemplaire_jeu WHERE id_jeu = ?";
        System.out.println("Executing SQL: " + sql + " with id_jeu: " + id);
        try {
            List<Exemplaire> exemplaires = jdbcTemplate.query(sql, new ExemplaireRowMapper(), id);
            System.out.println("Exemplaires trouvés: " + exemplaires);
            return exemplaires;
        } catch (BadSqlGrammarException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
            throw e;
        }
    }


    @Override
    public void update(Exemplaire entity) {

    }



    @Override
    public void deleteById(int id) {

    }

    class ExemplaireRowMapper implements RowMapper<Exemplaire> {
        @Override
        public Exemplaire mapRow(ResultSet rs, int rowNum) throws SQLException {
            Exemplaire exemplaire = new Exemplaire();
            exemplaire.setIdexemplaire(rs.getInt("no_exemplaire"));
            exemplaire.setCodebarre(rs.getString("code_barre"));
            exemplaire.setLouable(rs.getBoolean("louable"));
            exemplaire.setIdjeu(rs.getInt("id_jeu"));
            return exemplaire;
        }
    }
}
