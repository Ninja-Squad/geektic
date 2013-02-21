package models;

import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * TODO insert class documentation here
 * @author JB
 */
public class Geek {

    @SerializedName("NOM")
    private String nom;

    @SerializedName("PRENOM")
    private String prenom;

    @SerializedName("EMAIL")
    private String email;

    @SerializedName("VILLE")
    private String ville;

    @SerializedName("LIKE1")
    private String like1;

    @SerializedName("LIKE2")
    private String like2;

    @SerializedName("LIKE3")
    private String like3;

    @SerializedName("HATE1")
    private String hate1;

    @SerializedName("HATE2")
    private String hate2;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getLike1() {
        return like1;
    }

    public void setLike1(String like1) {
        this.like1 = like1;
    }

    public String getLike2() {
        return like2;
    }

    public void setLike2(String like2) {
        this.like2 = like2;
    }

    public String getLike3() {
        return like3;
    }

    public void setLike3(String like3) {
        this.like3 = like3;
    }

    public String getHate1() {
        return hate1;
    }

    public void setHate1(String hate1) {
        this.hate1 = hate1;
    }

    public String getHate2() {
        return hate2;
    }

    public void setHate2(String hate2) {
        this.hate2 = hate2;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                      .add("nom", nom)
                      .add("prenom", prenom)
                      .add("email", email)
                      .add("ville", ville)
                      .add("like1", like1)
                      .add("like2", like2)
                      .add("like3", like3)
                      .add("hate1", hate1)
                      .add("hate2", hate2)
                      .toString();
    }
}
