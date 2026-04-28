package tp3.ejercicio7;
import java.util.*;
import tp3.ejercicio1.GeneralTree;


public class Caminos {
	private GeneralTree<Integer> arbol;
	
	public Caminos() {
		this.arbol = new GeneralTree<Integer>();
	}
	
	public Caminos(GeneralTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public List<Integer> caminoAHojaMasLejana () {
		List<Integer> resultado = new LinkedList<Integer>();
		if ((this.arbol != null) && (!this.arbol.isEmpty()))
			recursion(this.arbol, resultado, new LinkedList<Integer>(),Integer.MIN_VALUE);
		return resultado;
	}
	
	private int recursion(GeneralTree<Integer> arbol, List<Integer> resultado, List<Integer> caminoActual, int longMaxima) {
		caminoActual.add(arbol.getData());
		int longActual = caminoActual.size();
		if (arbol.isLeaf()) {
			if (longActual > longMaxima) {
				longMaxima = longActual;
				resultado.clear();
				resultado.addAll(caminoActual);
			}
		} else {
			for (GeneralTree<Integer> child : arbol.getChildren())
				longMaxima = recursion(child,resultado,caminoActual,longMaxima);
		}
		caminoActual.remove(caminoActual.size()-1);
		return longMaxima;
	}
}
