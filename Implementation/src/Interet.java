package src;

public class Interet {
    private String nom;

    public Interet(String nom) {
        this.nom = nom;
    }

    public String getName() {
        return nom;
    }

    @Override
    public String toString() {
        return nom;
    }
}
