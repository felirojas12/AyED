package tp3.ejercicio11;
import tp3.ejercicio1.GeneralTree;
import tp1.ejercicio8.Queue;
import java.util.List;

public class ParcialArboles {
	
	public static boolean resolver(GeneralTree<Integer> arbol) {
		if ((arbol == null) || (arbol.isEmpty())) return false;
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		boolean resultado = true;
		int nodosAnterior = 0, nodosActual;
		cola.enqueue(arbol);
		while ((!cola.isEmpty()) && (resultado)) {
			nodosActual = cola.size();
			if (nodosActual != (nodosAnterior + 1)) {
				resultado = false;
			} else {
				for (int i = 0; i < nodosActual;i++) {
					GeneralTree<Integer> subArbol = cola.dequeue();
					List<GeneralTree<Integer>> children = subArbol.getChildren();
					for (GeneralTree<Integer> child: children)
						cola.enqueue(child);
				}
				nodosAnterior = nodosActual;
			}			
		}
		return resultado;
	}
}
