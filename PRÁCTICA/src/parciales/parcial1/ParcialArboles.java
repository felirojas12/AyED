package parciales.parcial1;
import java.util.*;
import tp3.ejercicio1.GeneralTree;

public class ParcialArboles {
	public static List<Integer> caminoParidadAlternante(GeneralTree<Integer> arbol) {
		List<Integer> resultado = new LinkedList<>();
		if ((arbol != null) && (!arbol.isEmpty()))
			recorrer(arbol, resultado, new LinkedList<Integer>());
		return resultado;
	}
	
	private static void recorrer(GeneralTree<Integer> arbol, List<Integer> resultado, List<Integer> camino) {
		camino.add(arbol.getData());
		if (arbol.isLeaf()) {
			if (camino.size() > resultado.size()) {
				resultado.clear();
				resultado.addAll(camino);
			} 
		} else {
				boolean condicionPadre = esPar(arbol.getData());
				for (GeneralTree<Integer> child : arbol.getChildren()) {
					boolean condicionHijo = esPar(child.getData());
					if (condicionHijo != condicionPadre)
						recorrer(child,resultado,camino);
				}
			}
		camino.remove(camino.size() - 1);
		}
	
	private static boolean esPar(int valor) {
		return (valor % 2 == 0);
	}
}
