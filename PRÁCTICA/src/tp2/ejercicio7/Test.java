package tp2.ejercicio7;

import tp2.ejercicio3.BinaryTree;

public class Test {
	public static void main(String[] args) {
		BinaryTree<Integer> raiz = new BinaryTree<>(2);
		BinaryTree<Integer> n7 = new BinaryTree<>(7);
		BinaryTree<Integer> n_5 = new BinaryTree<>(-5);
		raiz.addLeftChild(n7);
		raiz.addRightChild(n_5);
		BinaryTree<Integer> n23 = new BinaryTree<>(23);
		BinaryTree<Integer> n6 = new BinaryTree<>(6);
		n7.addLeftChild(n23);
		n7.addRightChild(n6);
		BinaryTree<Integer> n19 = new BinaryTree<>(19);
		n_5.addRightChild(n19);
		BinaryTree<Integer> n_3 = new BinaryTree<>(-3);
		n23.addLeftChild(n_3);
		BinaryTree<Integer> n55 = new BinaryTree<>(55);
		BinaryTree<Integer> n11 = new BinaryTree<>(11);
		n6.addLeftChild(n55);
		n6.addRightChild(n11);
		BinaryTree<Integer> n4 = new BinaryTree<>(4);
		n19.addRightChild(n4);
		BinaryTree<Integer> n18 = new BinaryTree<>(18);
		n4.addRightChild(n18);
		raiz.printPreOrden();
		ParcialArboles parcial = new ParcialArboles(raiz);
		System.out.println();
		System.out.println(parcial.isLeftTree(-5));
	}
}
