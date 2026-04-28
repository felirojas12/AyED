package tp2.ejercicio6;
import tp2.ejercicio3.*;

public class Transformacion {
	BinaryTree<Integer> arbol;

	public Transformacion(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public BinaryTree<Integer> suma() {
		if (this.arbol == null & this.arbol.isEmpty()) {
			return null;
		} else {
			transformar(this.arbol);
			return this.arbol;
		}
	}
	private int transformar(BinaryTree<Integer> ab) {
		if (ab == null) return 0; 
		int hijoIzq = transformar(ab.getLeftChild());
		int hijoDer = transformar(ab.getRightChild());
		int valorActual = ab.getData();
		ab.setData(hijoIzq+hijoDer);
		return valorActual + hijoIzq + hijoDer;
	}
}
