/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafoleonel_mh;
import java.util.Scanner;


/**
 *
 * @author Matos
 */
public class GrafosLeonel_MH {
    int matriz[][];
    String nombres[];
    int numNodos;
    int visitados[];
    ColaLeonel_MH cola;
    int distancia[][];
    int recorrido[][];
    
    public GrafosLeonel_MH(int numNodos) {
        this.numNodos = numNodos;
        matriz = new int[numNodos][numNodos];
        nombres = new String[numNodos];
        visitados = new int[numNodos];
        cola = new ColaLeonel_MH();
        initGrafos();
    }
    
    public int getTam() {
        return numNodos;
    }
    
    public void initGrafos() {
        for (int fila = 0; fila < numNodos; fila++) {
            for (int col = 0; col < numNodos; col++) {
                matriz[fila][col] = -1;
            }
        }
    }
    
    public void setNombres() {
        int pos;
        String nodo;
        Scanner entrada = new Scanner(System.in);
        for (pos = 0; pos < numNodos; pos++) {
            System.out.println("Agrega Nodo " + (pos + 1));
            nodo = entrada.nextLine();
            nombres[pos] = nodo;
        }
    }
    
    public boolean setArista(String nodoA, String nodoB) {
        int ind;
        int indNodoA = -1;
        int indNodoB = -1;
        
        for (ind = 0; ind < numNodos; ind++) {
            if (nombres[ind] != null && nombres[ind].equals(nodoA)) {
                indNodoA = ind;
            }
            if (nombres[ind] != null && nombres[ind].equals(nodoB)) {
                indNodoB = ind;
            }
        }
        if (indNodoA != -1 && indNodoB != -1) {
            matriz[indNodoA][indNodoB] = 1;
            matriz[indNodoB][indNodoA] = 1;
            return true;
        }
        return false;
    }
    
    public boolean addArista(int nodoA, int nodoB, int peso) {
        if (nodoA >= 0 && nodoA < numNodos && nodoB >= 0 && nodoB < numNodos) {
            matriz[nodoA][nodoB] = peso;
            matriz[nodoB][nodoA] = peso;
            return true;
        }
        return false;
    }
    
    public void imprimirMAdy() {
        for (int fila = 0; fila < numNodos; fila++) {
            System.out.print(fila + "\t");
            for (int col = 0; col < numNodos; col++) {
                System.out.print(matriz[fila][col] + "\t");
            }
            System.out.println("");
        }
    }
    
    public int buscaInd(String nodo) {
        for (int i = 0; i < numNodos; i++) {
            if (nombres[i] != null && nombres[i].equals(nodo)) {
                return i;
            }
        }
        return -1;
    }
    
    public void recoAnchura(int nodoIni) {
        for (int i = 0; i < numNodos; i++) {
            visitados[i] = 0;
        }
        cola.encolar(nodoIni);
        visitados[nodoIni] = 1;
        
        while (!cola.isEmpty()) {
            int nodo = cola.desencolar();
            System.out.print(nombres[nodo] + " --> ");
            for (int ind = 0; ind < numNodos; ind++) {
                if (matriz[nodo][ind] > 0) {
                    if (visitados[ind] != 1) {
                        cola.encolar(ind);
                        visitados[ind] = 1;
                    }
                }
            }
        }
        System.out.println("fin");
    }
    
    public void recoProfundidad(int nodoIni) {
        for (int i = 0; i < numNodos; i++) {
            visitados[i] = 0;
        }
        profundidadAux(nodoIni);
        System.out.println("fin");
    }
    
    private void profundidadAux(int nodo) {
        visitados[nodo] = 1;
        System.out.print(nombres[nodo] + " --> ");
        for (int ind = 0; ind < numNodos; ind++) {
            if (matriz[nodo][ind] > 0 && visitados[ind] == 0) {
                profundidadAux(ind);
            }
        }
    }
    
    public void dijkstra(int nodoIni) {
        ColaArisLeonel_MH noProc = new ColaArisLeonel_MH();
        ListaLeonel_MH proc = new ListaLeonel_MH();
        int ind;
        AristaLeonel_MH aux;
        
        for (ind = 0; ind < numNodos; ind++) {
            if (ind == nodoIni) {
                noProc.encolar(new AristaLeonel_MH(ind, -1, 0));
            } else {
                noProc.encolar(new AristaLeonel_MH(ind));
            }
        }
        noProc.ordenar();
        
        while (!noProc.isEmpty()) {
            aux = noProc.desencolar();
            if (aux.peso == -1) {
                break;
            }
            proc.insertarUlt(aux);
            int nodoAct = aux.nodoIni;
            
            for (ind = 0; ind < numNodos; ind++) {
                if (matriz[nodoAct][ind] > 0) {
                    noProc.actualiza(ind, nodoAct, (aux.peso + matriz[nodoAct][ind]));
                }
            }
            noProc.ordenar();
        }
        
        System.out.println("--- Rutas más cortas (Dijkstra) ---");
        proc.mostrar();
    }
    
    public void prim(int nodoIni) {
        ColaArisLeonel_MH noProc = new ColaArisLeonel_MH();
        ListaLeonel_MH proc = new ListaLeonel_MH();
        AristaLeonel_MH aux;
        
        for (int ind = 0; ind < numNodos; ind++) {
            if (ind == nodoIni) {
                noProc.encolar(new AristaLeonel_MH(ind, ind, 0));
            } else {
                noProc.encolar(new AristaLeonel_MH(ind));
            }
        }
        
        while (!noProc.isEmpty()) {
            noProc.ordenar();
            aux = noProc.desencolar();
            
            if (aux.peso == -1) {
                break;
            }
            
            proc.insertarUlt(aux);
            int nodoAct = aux.nodoIni;
            
            for (int ind = 0; ind < numNodos; ind++) {
                if (matriz[nodoAct][ind] > 0) {
                    noProc.actualiza(ind, nodoAct, matriz[nodoAct][ind]);
                }
            }
        }
        
        System.out.println("--- Árbol de Expansión Mínima (Prim) ---");
        proc.mostrar();
    }
    
    public int sinCiclos(int search, int nodoTrabajo, int indTrabajo, ListaLeonel_MH lista) {
        int ciclo = 0;
        NodoArisLeonel_MH aux = lista.ini;
        int ind = 0;

        while (aux != null) {
            if (ind != indTrabajo) {
                AristaLeonel_MH act = aux.dato;
                if (nodoTrabajo == act.nodoIni || nodoTrabajo == act.nodoFin) {
                    int proximoNodo = (nodoTrabajo == act.nodoIni) ? act.nodoFin : act.nodoIni;
                    if (proximoNodo == search) {
                        return 1;
                    } else {
                        ciclo = sinCiclos(search, proximoNodo, ind, lista);
                        if (ciclo == 1) return 1;
                    }
                }
            }
            aux = aux.sig;
            ind++;
        }
        return ciclo;
    }
    
    public void kruskal() {
        ColaArisLeonel_MH arbol = new ColaArisLeonel_MH();
        ListaLeonel_MH mini = new ListaLeonel_MH();
        AristaLeonel_MH info;
        int cont = 0;

        for (int i = 0; i < numNodos; i++) {
            for (int j = i + 1; j < numNodos; j++) {
                if (matriz[i][j] > 0) {
                    arbol.encolar(new AristaLeonel_MH(i, j, matriz[i][j]));
                }
            }
        }

        arbol.ordenar();

        while (!arbol.isEmpty()) {
            info = arbol.desencolar();
            mini.insertarUlt(info);
            cont++;
            if (cont > 1) {
                if (sinCiclos(info.nodoIni, info.nodoFin, -1, mini) > 0) {
                    mini.getElem(info.nodoIni);
                    cont--;
                }
            }
        }
        
        System.out.println("--- Árbol de Expansión Mínima (Kruskal) ---");
        mini.mostrar();
    }
    
    public void agregarNodos() {
        int ind;
        Scanner cad = new Scanner(System.in);
        for (ind = 0; ind < numNodos; ind++) {
            System.out.println("Dame nodo " + ind);
            nombres[ind] = cad.nextLine();
        }
    }
    
    public void limpiarFloyd() {
    distancia = new int[numNodos][numNodos];
    recorrido = new int[numNodos][numNodos];
    for (int fila = 0; fila < numNodos; fila++) {
        for (int col = 0; col < numNodos; col++) {
            if (fila == col) {
                distancia[fila][col] = 0;
                recorrido[fila][col] = -1;
            } else if (matriz[fila][col] > 0) {
                distancia[fila][col] = matriz[fila][col];
                recorrido[fila][col] = col;
            } else {
                distancia[fila][col] = -1;
                recorrido[fila][col] = -1;
               }
            }
        }
    } 
    
    public void floyd() {
    distancia = new int[numNodos][numNodos];
    recorrido = new int[numNodos][numNodos];
    limpiarFloyd();

    int fila, col, block, suma, inf = -1, valor;

    for (block = 0; block < numNodos; block++) {
        for (fila = 0; fila < numNodos; fila++) {
            if (fila != block) {
                for (col = 0; col < numNodos; col++) {
                    if (col != block) {
                        valor = distancia[fila][col];
                        if (valor != 0 && distancia[fila][block] != inf && distancia[block][col] != inf) {
                            suma = distancia[fila][block] + distancia[block][col];
                            if (valor == inf || suma < valor) {
                                distancia[fila][col] = suma;
                                recorrido[fila][col] = recorrido[fila][block];
                            }
                        }
                    }
                }
            }
        }
    }
}
    public void muestraCamino(int origen, int destino) {
    if (distancia[origen][destino] == -1) {
        System.out.println("No hay camino");
    } else {
        int inicio = origen;
        System.out.print(nombres[origen]);
        while (origen != destino) {
            origen = recorrido[origen][destino];
            System.out.print(" -> " + nombres[origen]);
        }
        System.out.println();
        System.out.println("Peso total: " + distancia[inicio][destino]);
    }
}
    
}
