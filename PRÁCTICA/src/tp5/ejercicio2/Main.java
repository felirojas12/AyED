package tp5.ejercicio2;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.listaAdy.AdjListGraph;

public class Main {
    public static void main(String[] args) {
        Graph<String> ciudades = new AdjListGraph<>();
        Vertex<String> v1 = ciudades.createVertex("Buenos Aires");
        Vertex<String> v2 = ciudades.createVertex("Santiago");
        Vertex<String> v3 = ciudades.createVertex("Asunción");
        Vertex<String> v4 = ciudades.createVertex("Caracas");
        Vertex<String> v5 = ciudades.createVertex("Madrid");

        ciudades.connect(v1, v2, 3); //"Buenos Aires", "Santiago"
        ciudades.connect(v1, v3, 6); //"Buenos Aires", "Asunción"
        ciudades.connect(v1, v5, 6); //"Buenos Aires", "Madrid"
        ciudades.connect(v2, v4, 4); //"Santiago", "Caracas"
        ciudades.connect(v4, v5, 6); //"Caracas", "Madrid"
        ciudades.connect(v2, v5, 5); //"Santiago", "Madrid"
        ciudades.connect(v3, v4, 4); //"Asuncion", "Caracas"

        Recorridos recorridos = new Recorridos();
        System.out.println(recorridos.bfs(ciudades));
        System.out.println(recorridos.dfs(ciudades));

    }
}
