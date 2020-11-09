import java.util.HashMap;

public class Biblioteque2  implements BibliothequeI {

 private Livre[] liste;
 private int nb_livre;

	
	public boolean ajouterLivre(String nom) {
		if (this.nb_livre < 100) {
			
			Livre l = new Livre(nom);
			liste[this.nb_livre] = l;
			this.nb_livre += 1;
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean emprunterLivre(String nom) {
		int long_liste = liste.length;
		int i = 0;
		while (i < long_liste) {
			if(liste[i].getNom() == nom ) {
				return liste[i].emprunter();
			}
			else {
				return false;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		String response = "";

		for (Livre livre : liste) {
			if(livre != null) {
				response += " " + livre;
			}
			
		}
		
		return response;
	}

	public boolean rendreLivre(String nom) {
		int i = 0;
		int long_liste = liste.length;
		do {
			if(liste[i].getNom() == nom ) {
				liste[i].rendre();
			}
		} while (i < long_liste);
		return true;
	}
	
	Biblioteque2() {
		this.liste =  new Livre[100];
		this.nb_livre = 0;
	}

	@Override
	public boolean ajouter(String nom) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean emprunter(String nom) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean rendre(String nom) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void ajouter(String nom, MediaEnum mediaEnum) {
		// TODO Auto-generated method stub
		
	}

	
}
