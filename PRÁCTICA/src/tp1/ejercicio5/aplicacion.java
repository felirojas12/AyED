package tp1.ejercicio5;

public class aplicacion {
	public static void main (String[] args) {
		int [] arreglo = new int[3];
		arreglo[0] = 12;
		arreglo[1] = 33;
		arreglo[2] = 30;
		
		Object [] resultado = new Object[3];
		
		resultado = operar.conRetorno(arreglo);
		for (int i = 0; i<resultado.length;i++) {
			System.out.println(resultado[i]+" ");
		}
		
		datos objetoResultado = new datos();
		operar.conObjeto(arreglo, objetoResultado);
		System.out.println(objetoResultado.toString());
	}
}