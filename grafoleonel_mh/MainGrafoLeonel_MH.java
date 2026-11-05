/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package grafoleonel_mh;
import java.util.Scanner;

/**
 *
 * @author Matos
 */
public class MainGrafoLeonel_MH {
    public static void main(String[] args) {
        Scanner nom = new Scanner(System.in);
        GrafosLeonel_MH g = null;
        int opc;

        do {
            System.out.println("1. Crear Grafo");
            if (g != null) {
                System.out.println("2. Insertar Nodos");
                System.out.println("3. Agregar Arista");
                System.out.println("4. Imprimir Matriz de Adyacencia");
                System.out.println("5. Recorrido en Anchura (BFS)");
                System.out.println("6. Recorrido en Profundidad (DFS)");
                System.out.println("7. Algoritmo de Dijkstra");
                System.out.println("8. Algoritmo de Prim");
                System.out.println("9. Algoritmo de Kruskal");
            }
            System.out.println("0. Salir");
            System.out.print("Dame la opción a realizar: ");
            opc = nom.nextInt();

            switch (opc) {
                case 1:
                    System.out.print("Dame el tamaño del Grafo: ");
                    int tam = nom.nextInt();
                    g = new GrafosLeonel_MH(tam);
                    System.out.println("Grafo creado exitosamente con " + tam + " nodos.");
                    break;

                case 2:
                    if (g != null) {
                        g.agregarNodos();
                    } else {
                        System.out.println("Primero debes crear el grafo (Opción 1).");
                    }
                    break;

                case 3:
                    if (g != null) {
                        System.out.println("--- Lista de Nodos ---");
                        for (int ind = 0; ind < g.numNodos; ind++) {
                            System.out.println(ind + " -> " + (g.nombres[ind] != null ? g.nombres[ind] : "Sin nombre"));
                        }
                        System.out.print("Dame el índice del nodo A: ");
                        int nodoA = nom.nextInt();
                        System.out.print("Dame el índice del nodo B: ");
                        int nodoB = nom.nextInt();
                        System.out.print("Dame el peso: ");
                        int peso = nom.nextInt();

                        if (!g.addArista(nodoA, nodoB, peso)) {
                            System.out.println("Error: índices fuera de rango.");
                        } else {
                            System.out.println("Arista agregada correctamente.");
                        }
                    } else {
                        System.out.println("Primero debes crear el grafo (Opción 1).");
                    }
                    break;

                case 4:
                    if (g != null) {
                        System.out.println("--- Matriz de Adyacencia ---");
                        g.imprimirMAdy();
                    } else {
                        System.out.println("Primero debes crear el grafo (Opción 1).");
                    }
                    break;

                case 5:
                    if (g != null) {
                        System.out.print("Dame el nodo de inicio para Anchura: ");
                        int nodoIni = nom.nextInt();
                        if (nodoIni >= 0 && nodoIni < g.numNodos) {
                            System.out.println("Recorrido en Anchura (BFS):");
                            g.recoAnchura(nodoIni);
                        } else {
                            System.out.println("Índice de nodo inválido.");
                        }
                    } else {
                        System.out.println("Primero debes crear el grafo (Opción 1).");
                    }
                    break;

                case 6:
                    if (g != null) {
                        System.out.print("Dame el nodo de inicio para Profundidad: ");
                        int nodoIni = nom.nextInt();
                        if (nodoIni >= 0 && nodoIni < g.numNodos) {
                            System.out.println("Recorrido en Profundidad (DFS):");
                            g.recoProfundidad(nodoIni);
                        } else {
                            System.out.println("Índice de nodo inválido.");
                        }
                    } else {
                        System.out.println("Primero debes crear el grafo (Opción 1).");
                    }
                    break;

                case 7:
                    if (g != null) {
                        System.out.print("Dame el nodo origen para Dijkstra: ");
                        int nodoIni = nom.nextInt();
                        if (nodoIni >= 0 && nodoIni < g.numNodos) {
                            g.dijkstra(nodoIni);
                        } else {
                            System.out.println("Índice de nodo inválido.");
                        }
                    } else {
                        System.out.println("Primero debes crear el grafo (Opción 1).");
                    }
                    break;

                case 8:
                    if (g != null) {
                        System.out.print("Dame el nodo raíz para Prim: ");
                        int nodoIni = nom.nextInt();
                        if (nodoIni >= 0 && nodoIni < g.numNodos) {
                            g.prim(nodoIni);
                        } else {
                            System.out.println("Índice de nodo inválido.");
                        }
                    } else {
                        System.out.println("Primero debes crear el grafo (Opción 1).");
                    }
                    break;

                case 9:
                    if (g != null) {
                        g.kruskal();
                    } else {
                        System.out.println("Primero debes crear el grafo (Opción 1).");
                    }
                    break;
                    
                case 10:
                    if (g != null) {
                        g.floyd();
                        System.out.println("Matrices calculadas con Floyd-Warshall.");
                        System.out.print("Dame el nodo origen: ");
                        int origen = nom.nextInt();
                        System.out.print("Dame el nodo destino: ");
                        int destino = nom.nextInt();
                        g.muestraCamino(origen, destino);
                    } else {
                        System.out.println("Primero debes crear el grafo (Opción 1).");
                    }
                    break;    

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opc != 0);
    }
}
    

    
