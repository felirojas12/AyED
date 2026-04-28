package tp1.ejercicio7;
import java.util.ArrayList;

public class puntoH {
	public static void main(String[] args) {
		ArrayList<Integer> arreglo = new ArrayList<Integer>();
		arreglo.add(3);
		arreglo.add(2);
		arreglo.add(1);
		arreglo.add(8);
		invertirArrayList(arreglo);
		System.out.println(arreglo.toString());
	}
	
	public static void invertirArrayList(ArrayList<Integer> arreglo) {
		int x, y;
		for (int i = 0; i<arreglo.size()/2;i++) {
			x = arreglo.get(i);
			y = arreglo.get(arreglo.size()-1-i);
			arreglo.set(i, y);
			arreglo.set(arreglo.size()-1-i,x);
		}
	}
}