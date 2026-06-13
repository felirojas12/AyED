package tp5.ejercicio4;

import tp5.ejercicio1.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VisitaOslo {

    public VisitaOslo() {
    }

    public List<String> paseoEnBiciMio(Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos) {
        List<String> resultado = new ArrayList<>();
        if (!lugares.isEmpty()) {
            boolean[] marcas = new boolean[lugares.getSize()];
            Vertex<String> verticeDestino = lugares.search(destino);
            Vertex<String> origen = lugares.search("Ayuntamiento");
            marcarRestringidos(lugares, lugaresRestringidos, marcas);
            if (origen != null && verticeDestino != null) {
                paseoEnBici(lugares, origen, verticeDestino, maxTiempo, marcas, resultado);
            }
        }
        return resultado;
    }

    private boolean paseoEnBici(Graph<String> grafo, Vertex<String> origen, Vertex<String> destino, int maxTiempo,
                             boolean[] marcas, List<String> resultado) {
        boolean encontrado = false;
        marcas[origen.getPosition()] = true;
        resultado.add(origen.getData());
        if (origen == destino) {
            encontrado = true;
        } else {
            List<Edge<String>> edges = grafo.getEdges(origen);
            Iterator<Edge<String>> it = edges.iterator();
            while (it.hasNext() && !encontrado) {
                Edge<String> e = it.next();
                int j = e.getTarget().getPosition();
                if (!marcas[j] && maxTiempo - e.getWeight() >= 0) {
                    encontrado = paseoEnBici(grafo, e.getTarget(), destino, maxTiempo - e.getWeight(), marcas, resultado);
                }
            }
        }
        if (!encontrado) {
            resultado.remove(resultado.size() - 1);
            marcas[origen.getPosition()] = false;
        }
        return encontrado;
    }

    private void marcarRestringidos(Graph<String> grafo, List<String> lugaresRestringidos, boolean[] marcas) {
        for (String lugar : lugaresRestringidos) {
            int j = grafo.search(lugar).getPosition();
            marcas[j] = true;
        }
    }
}
