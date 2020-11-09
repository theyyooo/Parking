import java.util.HashMap;
import java.util.Map;

public class BiblioFactory {
	
	private static Map<Integer, BibliothequeI> mapBiblio;
	
	static {
		mapBiblio = new HashMap<Integer, BibliothequeI>();
		mapBiblio.put(1, new Biblioteque());
		mapBiblio.put(2, new Biblioteque2());
	}
	
	public static BibliothequeI getBiblio(int key) {
	
		return mapBiblio.get(key);
	
	}
}
