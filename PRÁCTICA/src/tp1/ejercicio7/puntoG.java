package tp1.ejercicio7;
import java.util.ArrayList;
import java.util.List;

public class puntoG {
	public static void main(String[] args) {
		List<Integer> lista = new ArrayList<Integer>();
		System.out.println(calcularSucesion(lista,8).toString());
	}
	public static List<Integer> calcularSucesion(List<Integer> lista,int n) {
		lista.add(n);
		if (n !=1) {
			if (n % 2 == 0) {
				calcularSucesion(lista,n/2);
			} else {
				calcularSucesion(lista,3*n+1);
			}
		}
		return lista;
	}
}