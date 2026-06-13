package parciales.grafos.parcial3;

import tp5.ejercicio1.*;
import tp5.ejercicio1.listaAdy.AdjListGraph;

import java.util.ArrayList;
import java.util.List;

public class Parcial {
    public List<Resultado> resolver(Graph<String> sitios, String origen, String destino, List<String> evitarPasarPor) {
        List<Resultado> resultado = new ArrayList<>();
        if (!sitios.isEmpty()) {
            Vertex<String> verticeOrigen = sitios.search(origen);
            Vertex<String> verticeDestino = sitios.search(destino);
            if (verticeOrigen != null && verticeDestino != null) {
                boolean[] marcas = new boolean[sitios.getSize()];
                marcarRestringidos(sitios, evitarPasarPor, marcas);
                recorrer(sitios, verticeOrigen, verticeDestino, marcas, resultado, new ArrayList<String>(),0);
            }
        }
        return resultado;
    }

    private void marcarRestringidos(Graph<String> sitios, List<String> evitarPasarPor, boolean[] marcas) {
        for (String lugar: evitarPasarPor) {
            Vertex<String> v = sitios.search(lugar);
            int j = v.getPosition();
            marcas[j] = true;
        }
    }

    private void recorrer(Graph<String> sitios, Vertex<String> origen, Vertex<String> destino,
                         boolean[] marcas, List<Resultado> resultado, List<String> camino, int suma) {
        marcas[origen.getPosition()] = true;
        camino.add(origen.getData());
        if (origen.getData().equals(destino.getData())) {
            Resultado res = new Resultado(new ArrayList<>(camino), suma);
            resultado.add(res);
        } else {
            List<Edge<String>> aristas = sitios.getEdges(origen);
            for (Edge<String> arista: aristas) {
                Vertex<String> v = arista.getTarget();
                if (!marcas[v.getPosition()]) {
                    recorrer(sitios, v, destino, marcas, resultado, camino, suma + arista.getWeight());
                }
            }
        }
        camino.remove(camino.size() - 1);
        marcas[origen.getPosition()] = false;
    }

    public static void main(String[] args) {
        Graph<String> grafo = new AdjListGraph();
        Vertex<String> v1 = grafo.createVertex("Estadio Diego Armando Maradona");
        Vertex<String> v2 = grafo.createVertex("Legislatura");
        Vertex<String> v3 = grafo.createVertex("Coliseo Podestá");
        Vertex<String> v4 = grafo.createVertex("MACLA");
        Vertex<String> v5 = grafo.createVertex("Catedral La Plata");
        Vertex<String> v6 = grafo.createVertex("Palacio Campodónico");
        Vertex<String> v7 = grafo.createVertex("Rectorado UNLP");
        Vertex<String> v8 = grafo.createVertex("Museo UNLP");

        grafo.connect(v1, v2, 25);
        grafo.connect(v2, v1, 25);
        grafo.connect(v1, v3, 20);
        grafo.connect(v3, v1, 20);
        grafo.connect(v1, v4, 35);
        grafo.connect(v4, v1, 35);
        grafo.connect(v1, v5, 40);
        grafo.connect(v5, v1, 40);
        grafo.connect(v2, v3, 25);
        grafo.connect(v3, v2, 25);
        grafo.connect(v4, v5, 8);
        grafo.connect(v5, v4, 8);
        grafo.connect(v5, v7, 5);
        grafo.connect(v7, v5, 5);
        grafo.connect(v3, v6, 10);
        grafo.connect(v6, v3, 10);
        grafo.connect(v6, v7, 30);
        grafo.connect(v7, v6, 30);
        grafo.connect(v7, v8, 15);
        grafo.connect(v8, v7, 15);

        List<String> evitarPasarPor = new ArrayList<>();
        evitarPasarPor.add("Legislatura");
        evitarPasarPor.add("MACLA");

        Parcial p = new Parcial();
        List<Resultado> lis = p.resolver(grafo, "Estadio Diego Armando Maradona", "Palacio Campodónico", evitarPasarPor);

        for(Resultado aux: lis) {
            System.out.println(aux.toString());
        }
    }
}
