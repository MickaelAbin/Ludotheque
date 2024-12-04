package fr.eni.ludotheque.bo;

import jakarta.validation.constraints.*;

public class Client {
    @Size(min = 2, max = 50, message = "Le nom doit faire entre 2 et 50 caractères")
    @NotBlank(message = "Le nom est obligatoire")
    private String nom;

    @Size(min = 2, max = 50, message = "Le prénom doit faire entre 2 et 50 caractères")
    @NotBlank(message = "Le prénom est obligatoire")
    private String prenom;

    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Le numéro de téléphone est invalide")
    @NotBlank(message = "Le numéro de téléphone est obligatoire")
    private String telephone;

    @Email(message = "L'adresse email est invalide")
    @NotBlank(message = "L'adresse email est obligatoire")
    private String email;

    @Size(min = 2, max = 100, message = "La rue doit faire entre 2 et 100 caractères")
    @NotBlank(message = "La rue est obligatoire")
    private String rue;

    @Min(value = 10000, message = "Ceci n'est pas un Code Postal valide")
    @Size(min = 5, max = 5, message = "Le code postal doit être un nombre à 5 chiffres")
    @NotNull(message = "Le code postal est obligatoire")
    private int codePostal;

    @Size(min = 2, max = 50, message = "La ville doit faire entre 2 et 50 caractères")
    @NotBlank(message = "La ville est obligatoire")
    private String ville;
    private int id;

    public Client() {
        ;
    }

    public Client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Client(int id, String nom, String prenom, String telephone, String email, String rue, int codePostal, String ville) {
        super();
        this.id=id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.email = email;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", rue='" + rue + '\'' +
                ", codePostal=" + codePostal +
                ", ville='" + ville + '\'' +
                ", id=" + id +
                '}';
    }
}
