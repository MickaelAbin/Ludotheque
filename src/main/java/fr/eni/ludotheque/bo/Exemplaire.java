package fr.eni.ludotheque.bo;

import jakarta.validation.constraints.*;

import java.util.Objects;

public class Exemplaire {

    private int idexemplaire;
@NotNull(message = "numero a renseigner")
@Size(min = 10, max = 10, message = "Le code barre doit etre composé de 10 chiffres")
    private String codebarre;


    private Boolean louable;

    private int idjeu;
    public Exemplaire() {
    }

    public Exemplaire(int idexemplaire, String codebarre, Boolean louable, int idjeu) {
        this.idexemplaire = idexemplaire;
        this.codebarre = codebarre;
        this.louable = louable;
        this.idjeu = idjeu;
    }

    public Exemplaire(int idexemplaire, String codebarre, Boolean louable) {
        this.idexemplaire = idexemplaire;
        this.codebarre = codebarre;
        this.louable = louable;
    }

    public int getIdexemplaire() {
        return idexemplaire;
    }

    public void setIdexemplaire(int idexemplaire) {
        this.idexemplaire = idexemplaire;
    }

    public String getCodebarre() {
        return codebarre;
    }

    public void setCodebarre(String codebarre) {
        this.codebarre = codebarre;
    }

    public Boolean getLouable() {
        return louable;
    }

    public void setLouable(Boolean louable) {
        this.louable = louable;
    }

    public int getIdjeu() {
        return idjeu;
    }

    public void setIdjeu(int idjeu) {
        this.idjeu = idjeu;
    }

    @Override
    public String toString() {
        return "Exemplaire{" +
                "idexemplaire=" + idexemplaire +
                ", codebarre=" + codebarre +
                ", louable=" + louable +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exemplaire that = (Exemplaire) o;
        return idexemplaire == that.idexemplaire && codebarre == that.codebarre && Objects.equals(louable, that.louable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idexemplaire, codebarre, louable);
    }
}
