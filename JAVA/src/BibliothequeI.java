
public interface BibliothequeI {
	
	public boolean ajouter(String nom);
	public boolean emprunter(String nom);
	public boolean rendre(String nom);
	
	@Deprecated
	public void ajouter(String nom, MediaEnum mediaEnum);

}
