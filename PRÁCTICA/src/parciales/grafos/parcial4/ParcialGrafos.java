package parciales.grafos.parcial4;

import tp5.ejercicio1.*;

import java.util.ArrayList;
import java.util.List;

public class ParcialGrafos {
    public List<String> rutaOptimaDistribucion(Graph<String> reino, String castillo, String aldea, int maxPociones) {
        List<String> resultado = new ArrayList<>();
        if (!reino.isEmpty()) {
            Vertex<String> origen = reino.search(castillo);
            Vertex<String> destino = reino.search(aldea);
            if (origen != null && destino != null) {
                recorrer(reino, origen, destino, resultado, new ArrayList<String>(),
                        1, Integer.MIN_VALUE, 0, maxPociones, new boolean[reino.getSize()]);
            }
        }
        return resultado;
    }

    private void recorrer(Graph<String> grafo, Vertex<String> origen, Vertex<String> destino, List<String> resultado,
                         List<String> camino, int cant, int max, int pesos, int maxPociones, boolean[] marcas) {
        marcas[origen.getPosition()] = true;
        camino.add(origen.getData());
        if (origen.getData().equals(destino.getData()) && camino.size() > max) {
            resultado.clear();
            resultado.addAll(camino);
            max = resultado.size();
        } else {
            for (Edge<String> arista: grafo.getEdges(origen)) {
                Vertex<String> v = arista.getTarget();
                int j = v.getPosition();
                if (!marcas[j] && pesos + arista.getWeight() < maxPociones) {
                    recorrer(grafo, v, destino, resultado, camino, cant + 1, max,
                            pesos + arista.getWeight(), maxPociones, marcas);
                }
            }
        }
        camino.remove(camino.size() - 1);
        marcas[origen.getPosition()] = false;
    }
}
