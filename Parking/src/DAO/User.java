package DAO;

public class User {
	
	int id;
	String prenom;
	String nom;
	String mail;
	String mdp;
	
	public User(String prenom, String nom, String mail, String mdp) {
		this.prenom = prenom;
		this.nom = nom;
		this.mail = mail;
		this.mdp = mdp;
	}
	
	public User() {
		
	}

	public int getId() {
		return id;
	}

	public User setId(int id) {
		this.id = id;
		return this;
	}

	public String getPrenom() {
		return prenom;
	}

	public User setPrenom(String prenom) {
		this.prenom = prenom;
		return this;
	}

	public String getNom() {
		return nom;
	}

	public User setNom(String nom) {
		this.nom = nom;
		return this;
	}

	public String getMail() {
		return mail;
	}

	public User setMail(String mail) {
		this.mail = mail;
		return this;
	}

	public String getMdp() {
		return mdp;
	}

	public User setMdp(String mdp) {
		this.mdp = mdp;
		return this;
	}

}
