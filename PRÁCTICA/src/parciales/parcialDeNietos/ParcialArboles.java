package parciales.parcialDeNietos;
import tp2.ejercicio1_2.BinaryTree;

public class ParcialArboles {
	public static BinaryTree<Integer> arbolDeNietos(BinaryTree<Integer> arbol) {
		BinaryTree<Integer> arbolNuevo = new BinaryTree<Integer>();
		if ((arbol != null) && (!arbol.isEmpty()))
			arbolNuevo = recorrer(arbol);
		return arbolNuevo;
	}
	
	private static BinaryTree<Integer> recorrer(BinaryTree<Integer> arbol) {
		BinaryTree<Integer> arbolNuevo = new BinaryTree<Integer>();
		int cantHijos = 0;
		if (arbol.hasLeftChild()) {
			if (arbol.getLeftChild().hasLeftChild())
				cantHijos++;
			if (arbol.getLeftChild().hasRightChild())
				cantHijos++;
		}
		if (arbol.hasRightChild()) {
			if (arbol.getRightChild().hasLeftChild())
				cantHijos++;
			if (arbol.getRightChild().hasRightChild())
				cantHijos++;
		}
		arbolNuevo.setData(cantHijos);
		if (arbol.hasLeftChild()) {
			BinaryTree<Integer> hijoIzq = recorrer(arbol.getLeftChild());
			arbolNuevo.addLeftChild(hijoIzq);
		}
		if (arbol.hasRightChild()) {
			BinaryTree<Integer> hijoDer = recorrer(arbol.getRightChild());
			arbolNuevo.addRightChild(hijoDer);
		}
		return arbolNuevo;
	}
}
