package tp5.ejercicio3;
import tp5.ejercicio1.*;
import tp5.ejercicio1.listaAdy.AdjListGraph;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Mapa {
    private Graph<String> mapaCiudades;
    public Mapa(Graph<String> mapaCiudades) {
        this.mapaCiudades =  mapaCiudades;
    }

    public List<String> devolverCamino(String ciudad1, String ciudad2) {
        List<String> resultado = new ArrayList<>();
        if (!this.mapaCiudades.isEmpty()) {
            Vertex<String> origen = this.mapaCiudades.search(ciudad1);
            Vertex<String> destino = this.mapaCiudades.search(ciudad2);
            if (origen != null && destino != null)
                devolverCamino(origen,destino,resultado, new boolean[this.mapaCiudades.getSize()]);
        }
        return resultado;
    }

    private boolean devolverCamino(Vertex<String> origen, Vertex<String> destino, List<String> resultado, boolean[] visitados){
        boolean encontre = false;
        visitados[origen.getPosition()] = true;
        resultado.add(origen.getData());
        if (origen.getData().equals(destino.getData()))
            encontre = true;
        else {
            List<Edge<String>> aristas = this.mapaCiudades.getEdges(origen);
            Iterator<Edge<String>> it = aristas.iterator();
            while (it.hasNext() && !encontre) {
                Vertex<String> v = it.next().getTarget();
                int j = v.getPosition();
                if (!visitados[j])
                    encontre = devolverCamino(v,destino,resultado, visitados);
            }
        }
        if (!encontre) {
            resultado.removeLast();
            visitados[origen.getPosition()] = false;
        }
        return encontre;
    }

    public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> excepciones) {
        List<String> resultado = new ArrayList<>();
        if (!this.mapaCiudades.isEmpty()) {
            Vertex<String> origen = this.mapaCiudades.search(ciudad1);
            Vertex<String> destino = this.mapaCiudades.search(ciudad2);
            if (origen != null && destino != null){
                boolean[] visitados = new boolean[this.mapaCiudades.getSize()];
                marcarRestringidos(excepciones, visitados);
                devolverCamino(origen,destino, resultado, visitados);
            }
        }
        return resultado;
    }

    private void marcarRestringidos(List<String> excepciones, boolean[] visitados){
        for (String excepcion : excepciones) {
            int j = this.mapaCiudades.search(excepcion).getPosition();
            visitados[j] = true;
        }
    }

    public List<String> caminoMasCorto(String ciudad1, String ciudad2) {
        List<String> resultado = new ArrayList<>();
        if (!this.mapaCiudades.isEmpty()) {
            Vertex<String> origen = this.mapaCiudades.search(ciudad1);
            Vertex<String> destino = this.mapaCiudades.search(ciudad2);
            if (origen != null && destino != null)
                caminoMasCorto(origen, destino, resultado, new ArrayList<String>(), new boolean[this.mapaCiudades.getSize()],0,Integer.MAX_VALUE);
        }
        return resultado;
    }

    private int caminoMasCorto(Vertex<String> origen, Vertex<String> destino, List<String> resultado, List<String> caminoActual, boolean[] visitados, int total, int minimo){
        visitados[origen.getPosition()] = true;
        caminoActual.add(origen.getData());
        if (origen == destino && total < minimo) {
            resultado.clear();
            resultado.addAll(caminoActual);
            minimo = total;
        } else {
            List<Edge<String>> aristas = this.mapaCiudades.getEdges(origen);
            Iterator<Edge<String>> it = aristas.iterator();
            while (it.hasNext() && total < minimo) {
                Edge<String> e = it.next();
                int j = e.getTarget().getPosition();
                int aux = total + e.getWeight();
                if (!visitados[j] && aux < minimo)
                    minimo = caminoMasCorto(e.getTarget(), destino, resultado, caminoActual, visitados, aux, minimo);
            }
        }
        caminoActual.remove(caminoActual.size()-1);
        visitados[origen.getPosition()] = false;
        return minimo;
    }

    public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
        List<String> resultado = new ArrayList<>();
        if (!this.mapaCiudades.isEmpty()) {
            Vertex<String> origen = this.mapaCiudades.search(ciudad1);
            Vertex<String> destino = this.mapaCiudades.search(ciudad2);
            if (origen != null && destino != null)
                caminoSinCargarCombustible(origen, destino, resultado, new boolean[this.mapaCiudades.getSize()], tanqueAuto);
        }
        return resultado;
    }

    private boolean caminoSinCargarCombustible(Vertex<String> origen,  Vertex<String> destino, List<String> resultado, boolean[] visitados, int tanqueAuto) {
        visitados[origen.getPosition()] = true;
        boolean encontre = false;
        resultado.add(origen.getData());
        if (origen.getData().equals(destino.getData())) {
            encontre = true;
        } else {
            List<Edge<String>> aristas =  this.mapaCiudades.getEdges(origen);
            Iterator<Edge<String>> it = aristas.iterator();
            while (it.hasNext() && !encontre) {
                Edge<String> e = it.next();
                int j = e.getTarget().getPosition();
                int aux = tanqueAuto - e.getWeight();
                if (!visitados[j] && aux >= 0) {
                    encontre = caminoSinCargarCombustible(e.getTarget(), destino, resultado, visitados, aux);
                }
            }
        }
        if (!encontre) {
            resultado.remove(resultado.size()-1);
        }
        visitados[origen.getPosition()] = false;
        return encontre;
    }

    public List<String> caminoConMenorCargaCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
        List<String> camino = new ArrayList<>();
        if(!this.mapaCiudades.isEmpty()) {
            Vertex<String> origen = this.mapaCiudades.search(ciudad1);
            Vertex<String> destino = this.mapaCiudades.search(ciudad2);
            if(origen != null && destino != null) {
                caminoConMenorCargaCombustible(origen, destino, camino, new ArrayList<>(), new boolean[this.mapaCiudades.getSize()], tanqueAuto, tanqueAuto, 0, Integer.MAX_VALUE);
            }
        }
        return camino;
    }

    private int caminoConMenorCargaCombustible(Vertex<String> origen, Vertex<String> destino, List<String> caminoMinimo, List<String> caminoAct, boolean[] marcas, int tanqueActual, int tanque, int recargas, int recargasMin) {
        marcas[origen.getPosition()] = true;
        caminoAct.add(origen.getData());
        if (origen == destino && recargas < recargasMin) {
            caminoMinimo.clear();
            caminoMinimo.addAll(caminoAct);
            recargasMin = recargas;
        } else {
            List<Edge<String>> ady = this.mapaCiudades.getEdges(origen);
            Iterator<Edge<String>> it = ady.iterator();
            while (it.hasNext() && recargas < recargasMin) {
                Edge<String> v = it.next();
                int j = v.getTarget().getPosition();
                int distancia = v.getWeight();
                if (!marcas[j]) {
                    if (tanqueActual >= distancia) {
                        recargasMin = caminoConMenorCargaCombustible(v.getTarget(), destino, caminoMinimo, caminoAct, marcas, tanqueActual - distancia, tanque, recargas, recargasMin);
                    } else if (tanque >= distancia) {
                        recargasMin = caminoConMenorCargaCombustible(v.getTarget(), destino, caminoMinimo, caminoAct, marcas, tanque - distancia, tanque, recargas + 1, recargasMin);
                    }
                }
            }
        }
        marcas[origen.getPosition()] = false;
        caminoAct.remove(caminoAct.size() - 1);
        return recargasMin;
    }

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
        ciudades.connect(v3, v5, 8); //"Asunción", "Madrid"

        Mapa mapa = new Mapa(ciudades);

        System.out.println(mapa.devolverCamino("Asunción","Santiago"));
        System.out.println(mapa.devolverCamino("Buenos Aires", "Madrid"));
        List<String> excepciones = new ArrayList<>();
        excepciones.add("Santiago");
        excepciones.add("Caracas");
        System.out.println("Exceptuando a " + excepciones.toString());
        System.out.println(mapa.devolverCaminoExceptuando("Buenos Aires", "Madrid",excepciones));
        System.out.println(mapa.devolverCaminoExceptuando("Buenos Aires", "Asunción",excepciones));
        System.out.println("Camino mas corto de Buenos Aires a Madrid: ");
        System.out.println(mapa.caminoMasCorto("Buenos Aires", "Madrid"));
        System.out.println("Camino con combustible 10 de Caracas a Buenos Aires: ");
        System.out.println(mapa.caminoSinCargarCombustible("Caracas","Buenos Aires", 15));
    }
}
