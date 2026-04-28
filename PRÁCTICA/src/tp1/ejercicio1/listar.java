package tp1.ejercicio1;

public class listar {
	
	public static void conFor(int a, int b) {
		for (int i = a; i <= b; i++) {
			System.out.println(i);
		}
	}
	
	public static void conWhile(int a, int b) {
		while (a <= b) {
			System.out.println(a++);
		}
	}
	
	public static void sinIteracion(int a, int b) {
		if (a > b) {
			return;
		} 
		System.out.println(a);
		sinIteracion(a+1,b);
	}
}

