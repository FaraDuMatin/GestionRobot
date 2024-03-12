package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Utilisateur extends Usager{
    private String nom;
    private String prenom;

    private String pseudo;
    private String mdp;
    private String telephone;
    private String mail;
    private String nomCompagnie;
    private List<Activite> activites;
    private List<Robot> robots;
    private List <Interet> interets;



    private List <Utilisateur> abonnée;
    private List <Utilisateur> abonnement;


    public Utilisateur(){

    }

    public Utilisateur(String nom) {
        this.nom = nom;
    }

    public Utilisateur(String nom, String prenom, String pseudo, String mdp, String telephone, String mail, String nomCompagnie, List<Interet> interets) {
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.telephone = telephone;
        this.mail = mail;
        this.nomCompagnie = nomCompagnie;
        this.interets = interets;
    }

    public Utilisateur(String nom, String prenom, String pseudo, String mdp, String telephone, String mail, List<Interet> interets) {
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.telephone = telephone;
        this.mail = mail;
        this.interets = interets;
    }

    public Utilisateur(String nom, String prenom, String pseudo, String mdp, String telephone, String mail) {
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.telephone = telephone;
        this.mail = mail;
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

    public void setPrénom(String prenom) {
        this.prenom = prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTéléphone(String telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Interet> getInterets() {
        return interets;
    }

    public void setInterets(List<Interet> interets) {
        this.interets = interets;
    }

    public String getNomCompagnie() {
        return nomCompagnie;
    }

    public void setNomCompagnie(String nomCompagnie) {
        this.nomCompagnie = nomCompagnie;
    }

    public List<Utilisateur> getAbonnement() {
        return abonnement;
    }

    public void setAbonnement(List<Utilisateur> followers) {
        this.abonnement = followers;
    }

    public List<Utilisateur> getAbonnée() {
        return abonnée;
    }

    public void setAbonnée(List<Utilisateur> abonnée) {
        this.abonnée = abonnée;
    }

    public List<Activite> getActivites() {
        return activites;
    }

    public void setActivites(List<Activite> activites) {
        this.activites = activites;
    }

    public List<Robot> getRobots() {
        return robots;
    }

    public void setRobots(List<Robot> robots) {
        this.robots = robots;
    }
}
