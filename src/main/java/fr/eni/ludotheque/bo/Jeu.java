package fr.eni.ludotheque.bo;

import java.util.List;
import java.util.Objects;

public class Jeu {

    private int no_jeu;
    private String titre;
    private int reference;
    private String description;
    private int tarif_journée;
    private int age_mini;
    private int duree;

    private List<Genre> genres;

    private List<Exemplaire> exemplaires;



    public Jeu() {
    }

    public Jeu(int no_jeu, String titre, int reference, String description, int tarif_journée, int age_mini, int duree, List<Genre> genres, List<Exemplaire> exemplaires) {
        this.no_jeu = no_jeu;
        this.titre = titre;
        this.reference = reference;
        this.description = description;
        this.tarif_journée = tarif_journée;
        this.age_mini = age_mini;
        this.duree = duree;
        this.genres = genres;
        this.exemplaires = exemplaires;
    }

    public Jeu(int no_jeu, String titre, int reference, String description, int tarif_journée, int age_mini, int duree, List<Genre> genres) {
        this.no_jeu = no_jeu;
        this.titre = titre;
        this.reference = reference;
        this.description = description;
        this.tarif_journée = tarif_journée;
        this.age_mini = age_mini;
        this.duree = duree;
        this.genres = genres;
    }

    public Jeu(int no_jeu, String titre, int reference, String description, int tarif_journée, int age_mini, int duree) {
        this.no_jeu = no_jeu;
        this.titre = titre;
        this.reference = reference;
        this.description = description;
        this.tarif_journée = tarif_journée;
        this.age_mini = age_mini;
        this.duree = duree;
    }

    public int getNo_jeu() {
        return no_jeu;
    }

    public void setNo_jeu(int no_jeu) {
        this.no_jeu = no_jeu;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTarif_journée() {
        return tarif_journée;
    }

    public void setTarif_journée(int tarif_journée) {
        this.tarif_journée = tarif_journée;
    }

    public int getAge_mini() {
        return age_mini;
    }

    public void setAge_mini(int age_mini) {
        this.age_mini = age_mini;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
    public List<Exemplaire> getExemplaires() {
        return exemplaires;
    }

    public void setExemplaires(List<Exemplaire> exemplaires) {
        this.exemplaires = exemplaires;
    }

    @Override
    public String toString() {
        return "Jeu{" +
                "no_jeu=" + no_jeu +
                ", titre='" + titre + '\'' +
                ", reference=" + reference +
                ", description='" + description + '\'' +
                ", tarif_journée=" + tarif_journée +
                ", age_mini=" + age_mini +
                ", duree=" + duree +
                ", genres=" + genres +
                ", exemplaires=" + exemplaires +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jeu jeu = (Jeu) o;
        return no_jeu == jeu.no_jeu && reference == jeu.reference && tarif_journée == jeu.tarif_journée && age_mini == jeu.age_mini && duree == jeu.duree && Objects.equals(titre, jeu.titre) && Objects.equals(description, jeu.description) && Objects.equals(genres, jeu.genres) && Objects.equals(exemplaires, jeu.exemplaires);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no_jeu, titre, reference, description, tarif_journée, age_mini, duree, genres, exemplaires);
    }
}
