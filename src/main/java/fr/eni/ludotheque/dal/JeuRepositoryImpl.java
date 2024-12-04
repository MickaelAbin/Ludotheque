package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Genre;
import fr.eni.ludotheque.bo.Jeu;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class JeuRepositoryImpl implements JeuRepository {

    private final JdbcTemplate jdbcTemplate;

    public JeuRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void ajouterJeu(Jeu jeu) {
        String sql = "INSERT INTO jeux (titre, reference, description, tarif_jour, age_mini, duree) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, jeu.getTitre(), jeu.getReference(), jeu.getDescription(), jeu.getTarif_journée(), jeu.getAge_mini(), jeu.getDuree());
        // Récupérer l'id généré du jeu
        int jeuId = jdbcTemplate.queryForObject("SELECT lastval()", Integer.class);
        jeu.setNo_jeu(jeuId);

        // Insérer les genres associés
        for (Genre genre : jeu.getGenres()) {
            String genreSql = "INSERT INTO jeu_genre (id_jeu, id_genre) VALUES (?, ?)";
            jdbcTemplate.update(genreSql, jeuId, genre.getNo_genre());
        }
    }

    @Override
    public void update(Jeu jeu) {
        String sql = "UPDATE jeux SET titre = ?, reference = ?, description = ?, tarif_jour = ?, age_mini = ?, duree = ? WHERE id_jeu = ?";
        jdbcTemplate.update(sql, jeu.getTitre(), jeu.getReference(), jeu.getDescription(), jeu.getTarif_journée(), jeu.getAge_mini(), jeu.getDuree(), jeu.getNo_jeu());

        // Supprimer les anciens genres associés
        String deleteGenresSql = "DELETE FROM jeu_genre WHERE id_jeu = ?";
        jdbcTemplate.update(deleteGenresSql, jeu.getNo_jeu());

        // Insérer les nouveaux genres associés
        for (Genre genre : jeu.getGenres()) {
            String genreSql = "INSERT INTO jeu_genre (id_jeu, id_genre) VALUES (?, ?)";
            jdbcTemplate.update(genreSql, jeu.getNo_jeu(), genre.getNo_genre());
        }
    }

    @Override
    public List<Jeu> findAllJeu() {
        String sql = "SELECT j.id_jeu, j.titre, j.reference, j.description, j.tarif_jour, j.age_mini, j.duree, g.id_genre, g.libelle " +
                "FROM jeux j " +
                "LEFT JOIN jeu_genre jg ON j.id_jeu = jg.id_jeu " +
                "LEFT JOIN genre g ON jg.id_genre = g.id_genre";
        return jdbcTemplate.query(sql, new JeuRowMapper());
    }

    @Override
    public Optional<Jeu> findById(int id) {
        String sql = "SELECT j.id_jeu, j.titre, j.reference, j.description, j.tarif_jour, j.age_mini, j.duree, g.id_genre, g.libelle " +
                "FROM jeux j " +
                "LEFT JOIN jeu_genre jg ON j.id_jeu = jg.id_jeu " +
                "LEFT JOIN genre g ON jg.id_genre = g.id_genre WHERE j.id_jeu = ?";
        List<Jeu> jeux = jdbcTemplate.query(sql, new JeuRowMapper(), id);
        return jeux.isEmpty() ? Optional.empty() : Optional.of(jeux.get(0));
    }

    @Override
    public void deleteById(int id) {
        String deleteGenresSql = "DELETE FROM jeu_genre WHERE id_jeu = ?";
        jdbcTemplate.update(deleteGenresSql, id);

        String deleteJeuSql = "DELETE FROM jeux WHERE id_jeu = ?";
        jdbcTemplate.update(deleteJeuSql, id);
    }

    class JeuRowMapper implements RowMapper<Jeu> {
        @Override
        public Jeu mapRow(ResultSet rs, int rowNum) throws SQLException {
            Jeu jeu = new Jeu();
            jeu.setNo_jeu(rs.getInt("id_jeu"));
            jeu.setTitre(rs.getString("titre"));
            jeu.setReference(rs.getInt("reference"));
            jeu.setDescription(rs.getString("description"));
            jeu.setTarif_journée(rs.getInt("tarif_jour"));
            jeu.setAge_mini(rs.getInt("age_mini"));
            jeu.setDuree(rs.getInt("duree"));

            List<Genre> genres = new ArrayList<>();
            do {
                Genre genre = new Genre();
                genre.setNo_genre(rs.getInt("id_genre"));
                genre.setLibelle(rs.getString("libelle"));
                genres.add(genre);
            } while (rs.next() && rs.getInt("id_jeu") == jeu.getNo_jeu());

            jeu.setGenres(genres);
            return jeu;
        }
    }
}
