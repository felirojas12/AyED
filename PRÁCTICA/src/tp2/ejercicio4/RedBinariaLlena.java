package tp2.ejercicio4;
import tp2.ejercicio3.*;

public class RedBinariaLlena {
	BinaryTree<Integer> arbol;

	public RedBinariaLlena(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public int retardoEnvio() {
		return recursion(0,this.arbol);
	}
	
	private int recursion(int aux,BinaryTree<Integer> arbol) {
		if (arbol == null)
			return 0;
		aux += arbol.getData();
		if (arbol.isLeaf())
			return aux;
		int maxIzq = -1;
		int maxDer = -1;
		if (arbol.hasLeftChild())
			maxIzq = recursion(aux,arbol.getLeftChild());
		if (arbol.hasRightChild())
			maxDer = recursion(aux,arbol.getRightChild());
		return Math.max(maxIzq, maxDer);
	}
}
