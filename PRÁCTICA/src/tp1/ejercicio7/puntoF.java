package tp1.ejercicio7;
import java.util.ArrayList;

public class puntoF {
	public static void main(String[] args) {
		ArrayList<Integer> arreglo = new ArrayList<Integer>();
		arreglo.add(1);
		arreglo.add(2);
		arreglo.add(3);
		arreglo.add(2);
		arreglo.add(2);
		
		System.out.println("El numero es capicua?: "+esCapicua(arreglo));
		
	}
	public static boolean esCapicua(ArrayList<Integer> arreglo) {
		for (int i = 0; i<arreglo.size()/2;i++) {
			if (!arreglo.get(i).equals(arreglo.get(arreglo.size()-1-i))) {
				return false;
			}
		}
		return true;
	}
}