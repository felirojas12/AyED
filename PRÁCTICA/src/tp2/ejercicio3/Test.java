package tp2.ejercicio3;

public class Test {
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
		ContadorArbol contador = new ContadorArbol(ab);
		System.out.println(contador.numerosPares().toString());
		System.out.println(contador.numerosParesInOrden().toString());
		System.out.println(contador.numerosParesPostOrden().toString());
	}
}