package tp1.ejercicio3;

public class test {
	public static void main(String[] args) {
		estudiante[] estudiantes = new estudiante[2];
		profesor[] profesores = new profesor[3];
		
		estudiantes[0] = new estudiante("Rojas","Felipe","Gmail","Ensenada",3);
		estudiantes[1] = new estudiante("Pessini","Lucia","Hotmail","La Plata",2);
		profesores[0] = new profesor("Lopez","Veronica","Gmail","Bioquimica","Medicina");
		profesores[1] = new profesor("Rodriguez","Laura","Outlook","Matematica","Informatica");
		profesores[2] = new profesor("Ramirez","Antonio","Gmail","Anatomia","Medicina");
		
		for (int i = 0; i < estudiantes.length; i++) {
			System.out.println(estudiantes[i].tusDatos());
		}
		for (int i = 0; i < profesores.length; i++) {
			System.out.println(profesores[i].tusDatos());
		}
		
	}
}