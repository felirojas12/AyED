package tp2.ejercicio5;
import tp2.ejercicio3.*;

public class ProfundidadDelArbolBinario{
	BinaryTree<Integer> arbol;

	public ProfundidadDelArbolBinario(BinaryTree<Integer>arbol) {
		super();
		this.arbol = arbol;
	}
	
	public int sumaElementosProfundidad (int p) {
		int suma = 0;
		int nivel = 0;
		BinaryTree<Integer> ab = null;
		Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
		cola.enqueue(this.arbol);
		cola.enqueue(null);
		while (!cola.isEmpty()) {
			ab = cola.dequeue();
			if (ab != null) {
				if (nivel == p) 
					suma = suma + ab.getData();
				if (ab.hasLeftChild()) {
					cola.enqueue(ab.getLeftChild());
				}
				if (ab.hasRightChild()) {
					cola.enqueue(ab.getRightChild());
				}
			} else if (!cola.isEmpty()) {
				System.out.println();
				cola.enqueue(null);
				nivel++;
			}
		}
		return suma;
	}
}