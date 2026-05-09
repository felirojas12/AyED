package parciales.parcialesPunto1;
import tp3.ejercicio1.GeneralTree;
import java.util.*;

public class ParcialArboles {
	public static List<Integer> devolverCamino(GeneralTree<Integer> arbol) {
		List<Integer> camino = new LinkedList<>();
		if ((arbol != null) && (!arbol.isEmpty()))
			recorrer(arbol,camino);
		return camino;
	}
	
	private static void recorrer(GeneralTree<Integer> arbol, List<Integer> camino) {
		camino.add(arbol.getData());
		if (!arbol.isLeaf()) {
			List<GeneralTree<Integer>> children = arbol.getChildren();
			int pos = arbol.getData() - 1;
			if (children.size() > pos)
				recorrer(children.get(pos),camino);
		}
	}
}
