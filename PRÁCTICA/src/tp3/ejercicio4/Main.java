package tp3.ejercicio4;

import tp3.ejercicio1.GeneralTree;

public class Main {

    public static void main(String[] args) {

        // Raíz
        GeneralTree<AreaEmpresa> arbol = new GeneralTree<>(new AreaEmpresa("CEO", 10));

        // Nivel 1
        GeneralTree<AreaEmpresa> hijo1 = new GeneralTree<>(new AreaEmpresa("Gerente1", 20));
        GeneralTree<AreaEmpresa> hijo2 = new GeneralTree<>(new AreaEmpresa("Gerente2", 30));

        arbol.addChild(hijo1);
        arbol.addChild(hijo2);

        // Nivel 2
        hijo1.addChild(new GeneralTree<>(new AreaEmpresa("Empleado1", 40)));
        hijo1.addChild(new GeneralTree<>(new AreaEmpresa("Empleado2", 50)));

        hijo2.addChild(new GeneralTree<>(new AreaEmpresa("Empleado3", 60)));
        hijo2.addChild(new GeneralTree<>(new AreaEmpresa("Empleado4", 70)));

        // Ejecutar método
        double resultado = AnalizadorArbol.devolverMaximoPromedio(arbol);

        System.out.println("Máximo promedio por nivel: " + resultado);
    }
}