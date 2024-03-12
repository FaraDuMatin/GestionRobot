package src;

import java.util.List;

public class Fournisseur extends Usager{
	private String nom;
	private String mdp;
	private String adresse;
	private String mail;
	private String téléphone;

	private List<Composante> composantes;


	public Fournisseur(){
		
	}

	public Fournisseur(String nom, String mdp, String adresse, String mail, String téléphone, List<Composante> composantes) {
		this.nom = nom;
		this.mdp = mdp;
		this.adresse = adresse;
		this.mail = mail;
		this.téléphone = téléphone;
		this.composantes = composantes;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getTéléphone() {
		return téléphone;
	}

	public void setTéléphone(String téléphone) {
		this.téléphone = téléphone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public List<Composante> getComposantes() {
		return composantes;
	}

	public void setComposante(Composante composante) {
		this.composantes = composantes;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



}
