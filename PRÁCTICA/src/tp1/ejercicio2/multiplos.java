package tp1.ejercicio2;

public class multiplos {
	
	public static int[] enArreglo(int n) {
		int[] arreglo = new int[n];
		int k = 1;
		for (int i = 0; i<n; i++) {
			arreglo[i] = n * k++;
		}
		return arreglo;
	}
}