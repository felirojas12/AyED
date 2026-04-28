package tp3.ejercicio2;
import java.util.*;
import tp3.ejercicio1.*;
import tp1.ejercicio8.Queue;

public class RecorridosAG {
	
	public static List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a, Integer n) {
		List<Integer> resultado = new LinkedList<Integer>();
		if ((a != null) && (!a.isEmpty())) recursionPreOrden(a,n,resultado);
		return resultado;
	}
	
	private static void recursionPreOrden(GeneralTree<Integer> a, Integer n, List<Integer> resultado) {
		if ((a.getData() % 2 != 0) && (a.getData() > n)) resultado.add(a.getData());
		List<GeneralTree<Integer>> children = a.getChildren();
		for (GeneralTree<Integer> child: children) 
			recursionPreOrden(child,n,resultado);
	}
	
	public static List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n) {
		List<Integer> resultado = new LinkedList<Integer>();
		if ((a != null) && (!a.isEmpty())) recursionInOrden(a,n,resultado);
		return resultado;
	}
	
	private static void recursionInOrden(GeneralTree<Integer> a, Integer n, List<Integer> resultado) {
		List<GeneralTree<Integer>> children = a.getChildren();
		if (a.hasChildren()) 
			recursionInOrden(children.get(0),n,resultado);
		if ((a.getData() % 2 != 0) && (a.getData() > n)) resultado.add(a.getData());
		for(int i=1; i < children.size(); i++) //i empieza valiendo 1: IMPORTANTE para recorrer a partir del 2do hijo
            recursionInOrden(children.get(i), n, resultado);
	}
	
	public static List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n) {
		List<Integer> resultado = new LinkedList<Integer>();
		if ((a != null) && (!a.isEmpty())) recursionPostOrden(a,n,resultado);
		return resultado;
	}
	
	private static void recursionPostOrden(GeneralTree<Integer> a, Integer n, List<Integer> resultado) {
		List<GeneralTree<Integer>> children = a.getChildren();
		for (GeneralTree<Integer> child: children)
			recursionPostOrden(child,n,resultado);
		if ((a.getData() % 2 != 0) && (a.getData() > n)) resultado.add(a.getData());
	}
	
	public static List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> a, Integer n) {
		List<Integer> resultado = new LinkedList<Integer>();
		if ((a != null) && (!a.isEmpty())) {
			Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
			cola.enqueue(a);
			while (!cola.isEmpty()) {
				GeneralTree<Integer> nodo = cola.dequeue();
				if ((nodo.getData() % 2 != 0) && (nodo.getData() > n)) resultado.add(nodo.getData());
				List<GeneralTree<Integer>> children = nodo.getChildren();
				for (GeneralTree<Integer> child: children)
					cola.enqueue(child);
			}
		}
		return resultado;
	}
}
