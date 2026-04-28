package tp2.ejercicio5;
import tp2.ejercicio3.BinaryTree;

public class Test {
	public static void main(String[] args) {
		BinaryTree<Integer> ab = new BinaryTree<Integer>(40);
		BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(25);
		hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(10));
		hijoIzquierdo.addRightChild(new BinaryTree<Integer>(32));
		BinaryTree<Integer> hijoDerecho= new BinaryTree<Integer>(78);
		hijoDerecho.addLeftChild(new BinaryTree<Integer>(20));
		hijoDerecho.addRightChild(new BinaryTree<Integer>(13));
		ab.addLeftChild(hijoIzquierdo);
		ab.addRightChild(hijoDerecho);
		ab.printPreOrden();
		ProfundidadDelArbolBinario arbol = new ProfundidadDelArbolBinario(ab);
		System.out.println(arbol.sumaElementosProfundidad(0));
	}
}