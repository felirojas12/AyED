package tp1.ejercicio2;
import java.util.Scanner;

public class aplicacion {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Escriba un numero entero: ");
		int n = s.nextInt();
		int [] arreglo = multiplos.enArreglo(n);
		System.out.print("Vector:");
		for (int i = 0; i<arreglo.length; i++) {
			System.out.print("| "+arreglo[i]+" ");
		}
		s.close();
	}
}