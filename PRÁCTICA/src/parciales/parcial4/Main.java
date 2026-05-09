package parciales.parcial4;

import java.util.List;

import tp3.ejercicio1.GeneralTree;

public class Main {

	public static void main(String[] args) {
		GeneralTree<Integer> raiz = new GeneralTree<>(1);

		GeneralTree<Integer> nodo2 = new GeneralTree<>(2);
		GeneralTree<Integer> nodo3 = new GeneralTree<>(3);
		raiz.addChild(nodo2);
		raiz.addChild(nodo3);

		// Rama inválida para num = 2: el nodo 2 solo tiene un hijo.
		nodo2.addChild(new GeneralTree<>(4));

		// Rama válida para num = 2.
		GeneralTree<Integer> nodo5 = new GeneralTree<>(5);
		GeneralTree<Integer> nodo6 = new GeneralTree<>(6);
		nodo3.addChild(nodo5);
		nodo3.addChild(nodo6);
		nodo5.addChild(new GeneralTree<>(7));
		nodo5.addChild(new GeneralTree<>(8));
		nodo6.addChild(new GeneralTree<>(9));
		nodo6.addChild(new GeneralTree<>(10));

		ParcialArboles parcial = new ParcialArboles(raiz);

		imprimirResultado(parcial, 2);
		imprimirResultado(parcial, 3);
		imprimirResultado(parcial, 1);
	}

	private static void imprimirResultado(ParcialArboles parcial, int num) {
		List<Integer> camino = parcial.camino(num);
		System.out.println("camino(" + num + ") = " + camino);
	}
}

