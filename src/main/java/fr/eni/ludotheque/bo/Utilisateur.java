package fr.eni.ludotheque.bo;

import java.util.Objects;

public class Utilisateur {
    private int id;
    private String mailPro;
    private String mdp;
    private String userRole;

    public Utilisateur(int id, String mailPro, String mdp, String userRole) {
        this.id = id;
        this.mailPro = mailPro;
        this.mdp = mdp;
        this.userRole = userRole;
    }

    public Utilisateur() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMailPro() {
        return mailPro;
    }

    public void setMailPro(String mailPro) {
        this.mailPro = mailPro;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", mailPro='" + mailPro + '\'' +
                ", mdp='" + mdp + '\'' +
                ", userRole='" + userRole + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilisateur that = (Utilisateur) o;
        return id == that.id && Objects.equals(mailPro, that.mailPro) && Objects.equals(mdp, that.mdp) && Objects.equals(userRole, that.userRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mailPro, mdp, userRole);
    }
}
