package tp1.ejercicio7;
import java.util.ArrayList;
import java.util.List;

public class puntoD {
	public static void main(String[] args) {
		List<estudiante> listaEstudiantes = new ArrayList<estudiante>();
		
		listaEstudiantes.add(new estudiante("Rojas","Felipe","Gmail","Ensenada",3));
		listaEstudiantes.add(new estudiante("Lopez","Veronica","Gmail","La Plata",4));
		listaEstudiantes.add(new estudiante("Pessini","Lucia","Gmail","Ensenada",7));
		
		
		List<estudiante> listaCopiada = new ArrayList<estudiante>(listaEstudiantes);
		
		imprimirListas(listaEstudiantes);
		imprimirListas(listaCopiada);
		
		listaCopiada.get(2).setNombre("Jimena");
		
		imprimirListas(listaEstudiantes);
		imprimirListas(listaCopiada);
		
		List<estudiante> listaCopiadaDos = new ArrayList<estudiante>();
		listaCopiadaDos.addAll(listaEstudiantes);
		listaCopiadaDos.get(1).setApellido("Rodriguez");
		
		imprimirListas(listaEstudiantes);
		imprimirListas(listaCopiadaDos);
		
		System.out.println("ALUMNO AGREGADO");
		agregarALista(listaEstudiantes,new estudiante("Lopez","Veronica","Gmail","La Plata",4));
		imprimirListas(listaEstudiantes);
	}
	
	public static void imprimirListas(List<estudiante> lista) {
		for (estudiante e:lista) {
			System.out.println(e.tusDatos());
		}
	}
	public static void agregarALista(List<estudiante> lista, estudiante est) {
		if (!lista.contains(est)) {
			lista.add(est);
		}
	}
}