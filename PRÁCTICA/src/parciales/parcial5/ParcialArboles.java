package parciales.parcial5;

import tp2.ejercicio1_2.BinaryTree;
import tp2.ejercicio1_2.Queue;

public class ParcialArboles {
    public static int diferenciaHojasInternos(BinaryTree<Integer> arbol) {
        int resultado = 0;
        if ((arbol != null) && (!arbol.isEmpty())) {
            Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
            int sumaHojas = 0, sumaInternos = 0;
            cola.enqueue(arbol);
            while (!cola.isEmpty()) {
                BinaryTree<Integer> nodo = cola.dequeue();
                if (nodo.isLeaf()) {
                    if (esPar(nodo.getData()))
                        sumaHojas += nodo.getData();
                } else {
                    if ((!esPar(nodo.getData())) && (nodo.hasLeftChild()) && (nodo.hasRightChild()))
                        sumaInternos += nodo.getData();
                    if (nodo.hasLeftChild())
                        cola.enqueue(nodo.getLeftChild());
                    if (nodo.hasRightChild())
                        cola.enqueue(nodo.getRightChild());
                }
            }
            resultado = sumaHojas - sumaInternos;
        }
        return resultado;
    }

    private static boolean esPar(int dato) {
        return dato % 2 == 0;
    }
}
