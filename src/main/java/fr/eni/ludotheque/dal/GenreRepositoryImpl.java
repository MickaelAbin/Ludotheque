package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Genre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
@Repository
public class GenreRepositoryImpl implements GenreRepository {

    private JdbcTemplate jdbcTemplate;
    public GenreRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void ajouter(Genre entity) {

    }

    @Override
    public List<Genre> findAll() {
        String sql = "SELECT * FROM genre";
        List<Genre> genres = jdbcTemplate.query(sql, new GenreRowMapper());
        return genres;
    }

    @Override
    public Optional<Genre> findById(int id) {

        String sql = "SELECT * FROM genre WHERE id_genre = ?";
        Genre genre = jdbcTemplate.queryForObject(sql, new GenreRowMapper(), id);
        return Optional.ofNullable(genre);
    }

    @Override
    public void update(Genre entity) {

    }

    @Override
    public void deleteById(int id) {

    }
    class GenreRowMapper implements RowMapper<Genre> {
        @Override
        public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
            Genre genre = new Genre();
            genre.setNo_genre(rs.getInt("id_genre"));
            genre.setLibelle(rs.getString("libelle"));
            return genre;
        }
    }
}
