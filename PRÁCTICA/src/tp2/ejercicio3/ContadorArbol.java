package tp2.ejercicio3;
import java.util.*;

public class ContadorArbol {
	BinaryTree<Integer> arbol;
	
	public ContadorArbol(BinaryTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}

	public BinaryTree<Integer> getArbol() {
		return arbol;
	}

	public void setArbol(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}

	public ArrayList<Integer> numerosPares() {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		recursion(this.arbol,lista);
		return lista;
	}
	
	private void recursion(BinaryTree<Integer> ab, ArrayList<Integer> lista) {
		if (ab.getData() % 2 == 0)
			lista.add(ab.getData());
		if (ab.hasLeftChild()) {
			recursion(ab.getLeftChild(),lista);
		}
		if (ab.hasRightChild()) {
			recursion(ab.getRightChild(),lista);
		}
	}
	
	
	public ArrayList<Integer> numerosParesInOrden() {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		recursionInOrden(arbol,lista);
		return lista;
	}
	
	public ArrayList<Integer> numerosParesPostOrden() {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		recursionPostOrden(arbol,lista);
		return lista;
	}
	
	private void recursionInOrden(BinaryTree<Integer> arbol, ArrayList<Integer> lista) {
		if (arbol.hasLeftChild()) {
			recursion(arbol.getLeftChild(),lista);
		}
		if (arbol.getData() % 2 == 0)
			lista.add(arbol.getData());
		if (arbol.hasRightChild()) {
			recursion(arbol.getRightChild(),lista);
		}
	}
	private void recursionPostOrden(BinaryTree<Integer> arbol, ArrayList<Integer> lista) {
		if (arbol.hasLeftChild()) {
			recursion(arbol.getLeftChild(),lista);
		}
		if (arbol.hasRightChild()) {
			recursion(arbol.getRightChild(),lista);
		}
		if (arbol.getData() % 2 == 0)
			lista.add(arbol.getData());
	}
}