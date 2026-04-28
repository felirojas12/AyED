package tp3.ejercicio10;
import tp3.ejercicio1.GeneralTree;
import java.util.List;
import java.util.LinkedList;

public class ParcialArboles {

	public static List<Integer> resolver(GeneralTree<Integer> arbol) {
		List<Integer> mejorCamino = new LinkedList<>();
		if (arbol != null && !arbol.isEmpty()) {
			resolverRec(arbol, 0, 0, new LinkedList<>(), mejorCamino, new int[]{-1});
		}
		return mejorCamino;
	}
	
	private static void resolverRec(GeneralTree<Integer> nodo, int nivel, int suma,
									List<Integer> actual, List<Integer> mejor, int[] max) {
		suma += nodo.getData() * nivel;
		if (nodo.getData() == 1) {
			actual.add(1);
		}
		if (nodo.isLeaf()) {
			if (suma > max[0]) {
				max[0] = suma;
				mejor.clear();
				mejor.addAll(actual);
			}
		} else {
			for (GeneralTree<Integer> hijo : nodo.getChildren()) {
				resolverRec(hijo, nivel + 1, suma, actual, mejor, max);
			}
		}
		if (nodo.getData() == 1) {
			actual.remove(actual.size() - 1);
		}
	}
}