
public class Dvd implements MediaI {
	private String nom;
	private boolean emprunt;
	
	public boolean emprunter() {
		if (this.emprunt == true) {
			return false;
		}
		else {
			this.emprunt = true;
			return true;
		}	
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public boolean isEmprunt() {
		return emprunt;
	}

	public void setEmprunt(boolean emprunt) {
		this.emprunt = emprunt;
	}

	@Override
	public String toString() {
		return  nom;
	}

	public void rendre() {
		this.emprunt = false;
	}
	
	Dvd(String nom) {
		this.nom = nom;	
		this.emprunt = false;	
	}
	
}
