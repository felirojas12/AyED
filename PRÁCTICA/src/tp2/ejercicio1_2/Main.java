package tp2.ejercicio1_2;

public class Main {
	public static void main(String[] args) {
		BinaryTree<Integer> ab = new BinaryTree<Integer>(40);
		BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(25);
		hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(10));
		hijoIzquierdo.addRightChild(new BinaryTree<Integer>(32));
		BinaryTree<Integer> hijoDerecho= new BinaryTree<Integer>(78);
		ab.addLeftChild(hijoIzquierdo);
		ab.addRightChild(hijoDerecho);
		ab.printPreOrden();
		System.out.println();
		System.out.println("Cantidad de hojas del arbol: "+ab.contarHojas());
		ab.espejo().printPreOrden();
		System.out.println();
		ab.printLevelTraversal();
	}
}