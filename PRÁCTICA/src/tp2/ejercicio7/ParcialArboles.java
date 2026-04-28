package tp2.ejercicio7;
import tp2.ejercicio3.*;

public class ParcialArboles {
	BinaryTree<Integer> arbol;

	public ParcialArboles(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public boolean isLeftTree(int num) {
		BinaryTree<Integer> subArbol = encontrarNodo(this.arbol,num);
		if (subArbol == null) return false;
		int hijoIzq = hijosUnicos(subArbol.getLeftChild());
		int hijoDer = hijosUnicos(subArbol.getRightChild());
		return hijoIzq > hijoDer;
	}
	
	private BinaryTree<Integer> encontrarNodo(BinaryTree<Integer> ab, int num) {
	    if (ab == null) return null;
	    if (ab.getData() == num) return ab;
	    BinaryTree<Integer> izq = encontrarNodo(ab.getLeftChild(), num);
	    if (izq != null) return izq;
	    return encontrarNodo(ab.getRightChild(), num);
	}
	
	private int hijosUnicos(BinaryTree<Integer> ab) {
		if (ab == null) return -1;
		int suma = 0;
		if ((ab.hasLeftChild() && !ab.hasRightChild()) || (!ab.hasLeftChild() && ab.hasRightChild()))
			suma = 1;
		return suma + hijosUnicos(ab.getLeftChild()) + hijosUnicos(ab.getRightChild());
	}
}
	

