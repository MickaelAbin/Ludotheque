package fr.eni.ludotheque.bo;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

public class DetailLocation {

    private int noLigne;
    private Date dateRetour;
    private double tarifLocation;

    private Location location;

    private Exemplaire exemplaire;

    public DetailLocation() {
    }

    public DetailLocation(int noLigne, Date dateRetour, double tarifLocation, Location location, Exemplaire exemplaire) {
        this.noLigne = noLigne;
        this.dateRetour = dateRetour;
        this.tarifLocation = tarifLocation;
        this.location = location;
        this.exemplaire = exemplaire;
    }

    public int getNoLigne() {
        return noLigne;
    }

    public void setNoLigne(int noLigne) {
        this.noLigne = noLigne;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public double getTarifLocation() {
        return tarifLocation;
    }

    public void setTarifLocation(double tarifLocation) {
        this.tarifLocation = tarifLocation;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Exemplaire getExemplaire() {
        return exemplaire;
    }

    public void setExemplaire(Exemplaire exemplaire) {
        this.exemplaire = exemplaire;
    }

    @Override
    public String toString() {
        return "DetailLocation{" +
                "noLigne=" + noLigne +
                ", dateRetour=" + dateRetour +
                ", tarifLocation=" + tarifLocation +
                ", exemplaireId=" + (exemplaire != null ? exemplaire.getIdexemplaire() : "null") + // Affichez seulement l'ID
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetailLocation that = (DetailLocation) o;
        return noLigne == that.noLigne && Double.compare(tarifLocation, that.tarifLocation) == 0 && Objects.equals(dateRetour, that.dateRetour) && Objects.equals(location, that.location) && Objects.equals(exemplaire, that.exemplaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noLigne, dateRetour, tarifLocation, location, exemplaire);
    }
}