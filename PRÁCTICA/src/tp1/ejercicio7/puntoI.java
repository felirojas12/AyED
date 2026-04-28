package tp1.ejercicio7;
import java.util.LinkedList;

public class puntoI{
	public static void main(String[] args) {
		LinkedList<Integer> lista = new LinkedList<Integer>();
		lista.add(3);
		lista.add(2);
		lista.add(4);
		lista.add(6);
		System.out.println("Suma de la lista: "+sumarLinkedList(lista));
	}
	public static int sumarLinkedList(LinkedList<Integer> lista) {
		int pos = 0;
		return sumaRecursiva(pos, lista);
	}
	
	private static int sumaRecursiva(int pos, LinkedList<Integer> lista) {
		int sumaAct;
		if (pos == lista.size()-1) {
			sumaAct = lista.get(pos);
		}
		else {
			sumaAct = lista.get(pos) + sumaRecursiva(pos+1,lista);
		}
		return sumaAct;
	}
}