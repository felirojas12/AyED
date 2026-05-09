package parciales.parcial4;
import java.util.*;
import tp3.ejercicio1.GeneralTree;

public class ParcialArboles {
	private GeneralTree<Integer> arbol;

	public ParcialArboles() {
	}

	public ParcialArboles(GeneralTree<Integer> arbol) {
		this.arbol = arbol;
	}

	public void setArbol(GeneralTree<Integer> arbol) {
		this.arbol = arbol;
	}

	public List<Integer> camino (int num) {
		List<Integer> resultado = new LinkedList<>();
		if ((this.arbol != null) && (!this.arbol.isEmpty()) && (this.arbol.getChildren().size() >= num))
			recorrer(this.arbol, new LinkedList<>(), resultado, num);
		return resultado;
	}
	
	private boolean recorrer(GeneralTree<Integer> arbol, List<Integer> camino, List<Integer> resultado, int num) {
		camino.add(arbol.getData());
		boolean encontre = false;
		if (arbol.isLeaf()) {
			resultado.addAll(camino);
			encontre = true;
		} else {
			if (arbol.getChildren().size() >= num) {
				for (GeneralTree<Integer> child: arbol.getChildren()) {
					encontre = recorrer(child,camino,resultado,num);
					if (encontre) break;
				}
			}
		}
		camino.removeLast();
		return encontre;
	}
}
