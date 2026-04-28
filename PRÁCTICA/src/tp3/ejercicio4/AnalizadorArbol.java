package tp3.ejercicio4;
import tp3.ejercicio1.GeneralTree;
import tp1.ejercicio8.Queue;
import java.util.*;

public class AnalizadorArbol {
	public static double devolverMaximoPromedio (GeneralTree<AreaEmpresa> arbol) {
		Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();
		double promedioMax = -1, cant, total;
		cola.enqueue(arbol);
		while (!cola.isEmpty()) {
			cant = cola.size(); total = 0;
			for (int i = 0; i < cant;i++) {
				GeneralTree<AreaEmpresa> ab = cola.dequeue();
				total = total + ab.getData().getDelay();;
				List<GeneralTree<AreaEmpresa>> children = ab.getChildren();
				for (GeneralTree<AreaEmpresa> child : children) {
					cola.enqueue(child);
				}
			promedioMax = Math.max(promedioMax,total/cant);
			}
		}
		return promedioMax;
	}
}
