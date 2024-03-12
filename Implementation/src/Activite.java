package src;

import java.util.List;

public class Activite {

    public String nom;
    public List <Interet> interet;
    public String statut;
    public double point;

    public Activite(String nom, List<Interet> interet, String statut, double point) {
        this.nom = nom;
        this.interet = interet;
        this.statut = statut;
        this.point = point;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Interet> getInteret() {
        return interet;
    }

    public void setInteret(List<Interet> interet) {
        this.interet = interet;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }
}
