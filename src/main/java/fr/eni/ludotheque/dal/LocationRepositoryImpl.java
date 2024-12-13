package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Client;
import fr.eni.ludotheque.bo.DetailLocation;
import fr.eni.ludotheque.bo.Genre;
import fr.eni.ludotheque.bo.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LocationRepositoryImpl implements LocationRepository {

Logger logger = LoggerFactory.getLogger(LocationRepositoryImpl.class);
private JdbcTemplate jdbcTemplate;

public LocationRepositoryImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
}

    @Override
    public void ajouter(Location entity) {

    }

    @Override
    public List<Location> findAll() {
        return null;
    }

    @Override
    public Optional<Location> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void update(Location entity) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void ajouterLoc(Location location, int id) {
        logger.debug("Début ajouterLoc - location=" + location);

        // Insérer la location principale et récupérer l'ID généré
        String sql = "INSERT INTO location (date_debut_location, paye, prix_total, id_client) VALUES (?, ?, ?, ?) RETURNING id_location";
        int newLocationId = jdbcTemplate.queryForObject(sql, new Object[]{location.getDateDebutLocation(), location.isPaye(), location.getPrixTotal(), id}, Integer.class);

        logger.debug("Location ajoutée avec ID=" + newLocationId);

        // Insérer les détails de location
        String detailSql = "INSERT INTO detail_location (id_location, no_exemplaire,tarif_location) VALUES (?, ?, ?)";

        for (DetailLocation detail : location.getDetailLocations()) {
            jdbcTemplate.update(detailSql, newLocationId, detail.getExemplaire().getIdexemplaire(),  detail.getTarifLocation());
            logger.debug("Détail ajouté - ID Location: " + newLocationId + ", ID Exemplaire: " + detail.getExemplaire().getIdexemplaire());
        }

        logger.debug("Fin ajouterLoc - location=" + location);
    }


    class LocationRowMapper implements RowMapper<Location> {
        @Override
        public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
            Location location = new Location();
            location.setIdLocation(rs.getInt("id_location"));
            location.setDateDebutLocation(rs.getDate("date_debut_location"));
            location.setPaye(rs.getBoolean("paye"));
            location.setPrixTotal(rs.getDouble("prix_total"));
            location.setIdLocation(rs.getInt("id_client"));
            location.setDetailLocations(new ArrayList<>());
            return location;
        }

    }
}





