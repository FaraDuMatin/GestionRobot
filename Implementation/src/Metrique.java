package src;

public class Metrique {
    private int nombreDeRobotsDisponibles;
    private String étatGeneral;
    private int utilisationGlobale;

    public Metrique(int nombreDeRobotsDisponibles, String étatGeneral, int utilisationGlobale) {
        this.nombreDeRobotsDisponibles = nombreDeRobotsDisponibles;
        this.étatGeneral = étatGeneral;
        this.utilisationGlobale = utilisationGlobale;
    }

    public int getNombreDeRobotsDisponibles() {
        return nombreDeRobotsDisponibles;
    }

    public void setNombreDeRobotsDisponibles(int nombreDeRobotsDisponibles) {
        this.nombreDeRobotsDisponibles = nombreDeRobotsDisponibles;
    }

    public String getÉtatGeneral() {
        return étatGeneral;
    }

    public void setÉtatGeneral(String étatGeneral) {
        this.étatGeneral = étatGeneral;
    }

    public int getUtilisationGlobale() {
        return utilisationGlobale;
    }

    public void setUtilisationGlobale(int utilisationGlobale) {
        this.utilisationGlobale = utilisationGlobale;
    }
}
