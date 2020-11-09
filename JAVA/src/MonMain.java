public class MonMain {

	public static void main(String[] args) {
		
		BibliothequeI biblio = BiblioFactory.getBiblio(1);

//		boolean response1 = biblio.ajouterLivre("hello");
//		boolean response2 = biblio.ajouterLivre("test");
//		boolean response = biblio.ajouterLivre("ouai");
//		
//		System.out.println(biblio);
		
//		System.out.println(response1);
//		System.out.println(response2);
//		System.out.println(response);
		
		//System.out.println("Affichage contenu Bibliothèque avant emprunt livre 'Java' \n" + biblio);
		
////		test emprunt OK livre existant
//		boolean isEmpruntOk = biblio.emprunterLivre("java");
//		if (isEmpruntOk == true) {
//		System.out.println("Emprunt livre 'Java' : Tout s'est bien passé");
//		}
////		 test emprunt KO déjà emprunté
//		isEmpruntOk = biblio.emprunterLivre("Java");
//		if (isEmpruntOk != true) {
//		System.out.println("Emprunt livre 'Java' : KO déjà emprunté");
//		}
////		 test emprunt KO livre non existant
//		isEmpruntOk = biblio.emprunterLivre("Pas là");
//		if (isEmpruntOk != true) {
//		System.out.println("Emprunt livre 'Pas Là' : KO pas dans la bibliothèque");
//		}
		
		
	
	}
}
