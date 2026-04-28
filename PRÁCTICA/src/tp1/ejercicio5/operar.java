package tp1.ejercicio5;

public class operar {
	
	public static Object[] conRetorno(int[] arreglo) {
		int max = -1, min = 9999;
		double cant = 0, total = 0;
		Object [] datos = new Object[3];
		for (int i = 0; i < arreglo.length; i++) {
			if (arreglo[i] > max) {
				max = arreglo[i];
			}
			if (arreglo[i] < min) {
				min = arreglo[i];
			}
			total = total + arreglo[i];
			cant = cant + 1;
		}
		
		double promedio = total/cant;
		datos[0] = max;
		datos[1] = min;
		datos[2] = promedio;
		return datos;
	}
	
	public static void conObjeto(int[] arreglo, datos objeto) {
		int max = -1, min = 9999;
		double total = 0, cant = 0;
		for (int i = 0; i < arreglo.length; i++) {
			if (arreglo[i] > max) {
				max = arreglo[i];
			}
			if (arreglo[i] < min) {
				min = arreglo[i];
			}
			total = total + arreglo[i];
			cant = cant + 1;
		}
		
		double promedio = total/cant;
		objeto.setMaximo(max);
		objeto.setMinimo(min);
		objeto.setPromedio(promedio);
	}
}