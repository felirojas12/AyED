package tp3.ejercicio9;
import tp3.ejercicio1.GeneralTree;
import java.util.List;

public class ParcialArboles {

	public static boolean esDeSeleccion(GeneralTree<Integer> arbol) {
		boolean resultado = false;
		if ((arbol != null) && (!arbol.isEmpty())) resultado = recursion(arbol);
		return resultado;
	}
	
	private static boolean recursion(GeneralTree<Integer> arbol) {
		boolean cumple = false;
		if (arbol.isLeaf()) cumple = true;
		else {
			List<GeneralTree<Integer>> children = arbol.getChildren();
			if (arbol.getData().equals(minimo(children))) cumple = true;
			if (cumple) {
				for (GeneralTree<Integer> child: children)
					cumple = cumple && recursion(child);
			}
		}
		return cumple;
	}
	
	private static int minimo(List<GeneralTree<Integer>> lista) {
		int min = Integer.MAX_VALUE;
		for (GeneralTree<Integer> child: lista)
			min = Math.min(min, child.getData());
		return min;
	}
}
