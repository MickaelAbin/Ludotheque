package fr.eni.ludotheque.bo;

import java.util.Objects;

public class Genre {

    private int no_genre;

    private String libelle;

    public Genre() {
    }

    public Genre(int no_genre, String libelle) {
        this.no_genre = no_genre;
        this.libelle = libelle;
    }

    public int getNo_genre() {
        return no_genre;
    }

    public void setNo_genre(int no_genre) {
        this.no_genre = no_genre;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "no_genre=" + no_genre +
                ", libelle='" + libelle + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return no_genre == genre.no_genre && Objects.equals(libelle, genre.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no_genre, libelle);
    }
}
