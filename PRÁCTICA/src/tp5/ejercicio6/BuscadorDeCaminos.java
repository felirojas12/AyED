package tp5.ejercicio6;


import tp5.ejercicio1.*;
import tp5.ejercicio1.listaAdy.AdjListGraph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BuscadorDeCaminos {
    private Graph<String> bosque;

    public BuscadorDeCaminos(Graph<String> bosque) {
        this.bosque = bosque;
    }

    public List<List<String>> recorridosMasSeguros() {
        List<List<String>> resultado = new ArrayList<>();
        if (!this.bosque.isEmpty()) {
            Vertex<String> origen = this.bosque.search("Casa Caperucita");
            Vertex<String> destino = this.bosque.search("Casa Abuelita");
            if (origen != null && destino != null) {
                recorridosMasSeguros(this.bosque, origen, destino, new boolean[this.bosque.getSize()], resultado, new ArrayList<String>());
            }
        }
        return resultado;
    }

    private void recorridosMasSeguros(Graph<String> grafo, Vertex<String> origen, Vertex<String> destino, boolean[] marca,List<List<String>> resultado ,List<String> caminoActual) {
        marca[origen.getPosition()] = true;
        caminoActual.add(origen.getData());
        if (origen == destino) {
            resultado.add(new ArrayList<>(caminoActual));
        } else {
            List<Edge<String>> aristas = grafo.getEdges(origen);
            Iterator<Edge<String>> it = aristas.iterator();
            while (it.hasNext()) {
                Edge<String> e = it.next();
                int j = e.getTarget().getPosition();
                if (!marca[j] && e.getWeight() < 5) {
                    recorridosMasSeguros(grafo, e.getTarget(), destino, marca, resultado, caminoActual);
                }
            }
        }
        caminoActual.remove(caminoActual.size() - 1);
        marca[origen.getPosition()] = false;
    }

    public static void main (String[] args) {
        Graph<String> bosque = new AdjListGraph<String>();
        Vertex<String> v1 = bosque.createVertex("Casa Caperucita");
        Vertex<String> v2 = bosque.createVertex("Claro 3");
        Vertex<String> v3 = bosque.createVertex("Claro 1");
        Vertex<String> v4 = bosque.createVertex("Claro 2");
        Vertex<String> v5 = bosque.createVertex("Claro 5");
        Vertex<String> v6 = bosque.createVertex("Claro 4");
        Vertex<String> v7 = bosque.createVertex("Casa Abuelita");
        bosque.connect(v1, v2, 4);
        bosque.connect(v2, v1, 4);
        bosque.connect(v1, v3, 3);
        bosque.connect(v3, v1, 3);
        bosque.connect(v1, v4, 4);
        bosque.connect(v4, v1, 4);
        bosque.connect(v2, v5, 15);
        bosque.connect(v5, v2, 15);
        bosque.connect(v3, v5, 3);
        bosque.connect(v5, v3, 3);
        bosque.connect(v4, v3, 4);
        bosque.connect(v3, v4, 4);
        bosque.connect(v4, v5, 11);
        bosque.connect(v5, v4, 11);
        bosque.connect(v4, v6, 10);
        bosque.connect(v6, v4, 10);
        bosque.connect(v4, v3, 4);
        bosque.connect(v3, v4, 4);
        bosque.connect(v5, v7, 4);
        bosque.connect(v7, v5, 4);
        bosque.connect(v6, v7, 9);
        bosque.connect(v7, v6, 9);
        BuscadorDeCaminos bos = new BuscadorDeCaminos(bosque);
        List<List<String>> lis = bos.recorridosMasSeguros();
        for (List<String> l : lis) {
            System.out.println(l);
        }
    }
}
