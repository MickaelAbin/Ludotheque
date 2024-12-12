package fr.eni.ludotheque.bo;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Location {
    private int idLocation;

    private Date dateDebutLocation =Date.from(Instant.now()) ;

    private boolean paye= false; // Valeur par défaut pour paye

    private double prixTotal; // Valeur par défaut pour prixTotal

    private Client client;

private List<DetailLocation> detailLocations  = new ArrayList<>();;


    public Location() {
    }

    public Location(int idLocation, Date dateDebutLocation, boolean paye, double prixTotal, Client client, List<DetailLocation> detailLocations) {
        this.idLocation = idLocation;
        this.dateDebutLocation = dateDebutLocation;
        this.paye = paye;
        this.prixTotal = prixTotal;
        this.client = client;
        this.detailLocations = detailLocations;
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public Date getDateDebutLocation() {
        return dateDebutLocation;
    }

    public void setDateDebutLocation(Date dateDebutLocation) {
        this.dateDebutLocation = dateDebutLocation;
    }

    public boolean isPaye() {
        return paye;
    }

    public void setPaye(boolean paye) {
        this.paye = paye;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<DetailLocation> getDetailLocations() {
        return detailLocations;
    }

    public void setDetailLocations(List<DetailLocation> detailLocations) {
        this.detailLocations = detailLocations;
    }

    @Override
    public String toString() {
        return "Location{" +
                "dateDebutLocation=" + dateDebutLocation +
                ", paye=" + paye +
                ", prixTotal=" + prixTotal +
                ", detailLocations=" + (detailLocations != null ? detailLocations.size() : 0) + " details" +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return idLocation == location.idLocation && paye == location.paye && Double.compare(prixTotal, location.prixTotal) == 0 && Objects.equals(dateDebutLocation, location.dateDebutLocation) && Objects.equals(client, location.client) && Objects.equals(detailLocations, location.detailLocations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLocation, dateDebutLocation, paye, prixTotal, client, detailLocations);
    }
}