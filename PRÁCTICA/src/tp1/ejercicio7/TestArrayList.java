package tp1.ejercicio7;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestArrayList {
	public static void main(String[] args) {
		List<Integer> listaArray = new ArrayList<Integer>();
		
		for (int i = 0; i < args.length; i++) {
			int numero = Integer.parseInt(args[i]);
			listaArray.add(numero);
		}
		
		for (int i = 0; i < listaArray.size(); i++) {
			System.out.println(listaArray.get(i));
		}
		
		System.out.println();
		
		List<Integer> listaLinked = new LinkedList<Integer>();
		
		for (int i = 0; i < args.length; i++) {
			int numero = Integer.parseInt(args[i]);
			listaLinked.add(numero);
		}
		
		for (Integer numero: listaLinked) {
			System.out.println(numero);
		}
	}
}