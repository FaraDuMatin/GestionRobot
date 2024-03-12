package src;

public class Composante {
    private String nom;
    private String type;
    private double prix;
    private String description;

    public Composante(String nom, String type, double prix, String description) {
        this.nom = nom;
        this.type = type;
        this.prix = prix;
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
