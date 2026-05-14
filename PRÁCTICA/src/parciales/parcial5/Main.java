package parciales.parcial5;
import tp2.ejercicio1_2.BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> dos = new BinaryTree<>(2);
        BinaryTree<Integer> tres = new BinaryTree<>(3);
        BinaryTree<Integer> cinco = new BinaryTree<>(5);
        BinaryTree<Integer> uno = new BinaryTree<>(1);
        BinaryTree<Integer> seis = new BinaryTree<>(6);
        BinaryTree<Integer> ocho = new BinaryTree<>(8);
        BinaryTree<Integer> siete = new BinaryTree<>(7);
        BinaryTree<Integer> cuatro = new BinaryTree<>(4);

        seis.addLeftChild(siete); seis.addRightChild(cuatro);
        tres.addLeftChild(uno); tres.addRightChild(seis);
        cinco.addRightChild(ocho);
        dos.addLeftChild(tres); dos.addRightChild(cinco);

        System.out.println(ParcialArboles.diferenciaHojasInternos(dos));

    }
}
