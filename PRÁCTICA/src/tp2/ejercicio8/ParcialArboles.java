package tp2.ejercicio8;
import tp2.ejercicio3.*;

public class ParcialArboles {
	public static boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		if (arbol1 == null) return true;
		if (arbol2 == null) return false;
		if (!arbol1.getData().equals(arbol2.getData())) return false;
		return esPrefijo(arbol1.getLeftChild(),arbol2.getLeftChild()) && 
			   esPrefijo(arbol1.getRightChild(),arbol2.getRightChild());
	}
	
	public static void main(String[] args) {

	    // ===== ARBOL 1 =====
	    BinaryTree<Integer> arbol1 = new BinaryTree<>(65);

	    BinaryTree<Integer> n37 = new BinaryTree<>(37);
	    BinaryTree<Integer> n81 = new BinaryTree<>(81);
	    BinaryTree<Integer> n47 = new BinaryTree<>(47);
	    BinaryTree<Integer> n93 = new BinaryTree<>(93);

	    arbol1.addLeftChild(n37);
	    arbol1.addRightChild(n81);

	    n37.addRightChild(n47);
	    n81.addRightChild(n93);


	    // ===== ARBOL 2 =====
	    BinaryTree<Integer> arbol2 = new BinaryTree<>(65);

	    BinaryTree<Integer> n37_2 = new BinaryTree<>(37);
	    BinaryTree<Integer> n81_2 = new BinaryTree<>(81);
	    BinaryTree<Integer> n22 = new BinaryTree<>(22);
	    BinaryTree<Integer> n47_2 = new BinaryTree<>(47);
	    BinaryTree<Integer> n76 = new BinaryTree<>(76);
	    BinaryTree<Integer> n93_2 = new BinaryTree<>(93);
	    BinaryTree<Integer> n11 = new BinaryTree<>(11);
	    BinaryTree<Integer> n29 = new BinaryTree<>(29);
	    BinaryTree<Integer> n85 = new BinaryTree<>(85);
	    BinaryTree<Integer> n94 = new BinaryTree<>(94);

	    arbol2.addLeftChild(n37_2);
	    arbol2.addRightChild(n81_2);

	    n37_2.addLeftChild(n22);
	    n37_2.addRightChild(n47_2);

	    n22.addLeftChild(n11);
	    n22.addRightChild(n29);

	    n81_2.addLeftChild(n76);
	    n81_2.addRightChild(n93_2);

	    n93_2.addLeftChild(n85);
	    n93_2.addRightChild(n94);


	    // ===== PRUEBA =====


	    boolean resultado = ParcialArboles.esPrefijo(arbol1, arbol2);

	    System.out.println("¿Arbol1 es prefijo de Arbol2? " + resultado);
	}
}
