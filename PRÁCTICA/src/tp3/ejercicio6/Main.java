package tp3.ejercicio6;
import tp3.ejercicio1.*;

public class Main {
	public static void main(String[] args) {
		GeneralTree<Character> arbol = RedDeAguaPotable.crearArbolEjemplo();
		RedDeAguaPotable red = new RedDeAguaPotable(arbol);
		double resultado = red.minimoCaudal(1000);
		System.out.println(resultado);
	}

}
