import java.util.HashMap;


public class Biblioteque  implements BibliothequeI {
	private HashMap<String, MediaI> liste;

	
	public boolean ajouterLivre(String nom) {
		Livre l = new Livre(nom);
		liste.put(nom, l);
		return true;
	}
	
	public boolean emprunterLivre(String nom) {
		MediaI l = liste.get(nom);

		if (l == null) {
			return false;
		}
		else {
			return l.emprunter();
		}
	}
	
	@Override
	public String toString() {
		return "Biblioteque [liste=" + liste + "]";
	}

	public boolean rendreLivre(String nom) {
		MediaI l = liste.get(nom);
		
		if (l != null) {
			l.rendre();
			return true;
		}
		else {
			return false;
		}
		
	}
	
	Biblioteque() {
		liste = new HashMap<String , MediaI>();
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
		MediaI media = null ;
		if (MediaEnum.LIVRE == mediaEnum) media = new Livre(nom);
		if (MediaEnum.DVD == mediaEnum) media = new Dvd(nom);
		liste.put(nom, media);
		}

}
