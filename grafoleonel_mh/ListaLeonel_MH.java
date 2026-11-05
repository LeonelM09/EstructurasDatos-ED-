/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafoleonel_mh;

/**
 *
 * @author Matos
 */
public class ListaLeonel_MH {
    NodoArisLeonel_MH ini;
    
    public ListaLeonel_MH(){
        ini = null;
    }
    
    public boolean isEmpty(){
        return ini == null;
    }
    
    public void insertar(AristaLeonel_MH dato){ // Inserción al frente
        NodoArisLeonel_MH nuevo = new NodoArisLeonel_MH(dato);
        nuevo.sig = ini;
        ini = nuevo;
    }
    
    public void insertarUlt(AristaLeonel_MH dato){ // Inserción al final
        NodoArisLeonel_MH nuevo = new NodoArisLeonel_MH(dato);
        if (isEmpty()) {
            ini = nuevo;
        } else {
            NodoArisLeonel_MH aux = ini;
            while (aux.sig != null) {
                aux = aux.sig;
            }
            aux.sig = nuevo;
        }
    }
    
    public AristaLeonel_MH getPrim(){
        if (isEmpty()) {
            return null;
        }
        return ini.dato;
    }
    
    public AristaLeonel_MH desencolar(){
        if (isEmpty()) {
            return null;
        }
        AristaLeonel_MH dato = ini.dato;
        ini = ini.sig;
        return dato;
    }
    
    public AristaLeonel_MH getElem(int ind){ 
        NodoArisLeonel_MH aux, aux2;
        if (isEmpty()) {
            return null;
        }
        aux = ini;
        if (ini.dato.nodoIni == ind) {
            ini = ini.sig;
            return aux.dato;
        }
        
        while (aux.sig != null && aux.sig.dato.nodoIni != ind) {
            aux = aux.sig;
        }
        
        if (aux.sig != null) {
            aux2 = aux.sig;
            aux.sig = aux2.sig;
            return aux2.dato;
        }
        return null;
    }
    
    public int getTam(){
        int tam = 0;
        NodoArisLeonel_MH aux = ini;
        while (aux != null) {
            tam++;
            aux = aux.sig;
        }
        return tam;
    }
    
    public void ordenar() {
        if (!isEmpty() && ini.sig != null) {
            boolean huboCambio;
            do {
                huboCambio = false;
                NodoArisLeonel_MH aux = ini;
                while (aux.sig != null) {
                    boolean swap = false;
                    // Manda los -1 (infinito) al final y ordena de menor a mayor los valores válidos
                    if (aux.dato.peso == -1 && aux.sig.dato.peso != -1) {
                        swap = true;
                    } else if (aux.dato.peso != -1 && aux.sig.dato.peso != -1 && aux.dato.peso > aux.sig.dato.peso) {
                        swap = true;
                    }

                    if (swap) {
                        AristaLeonel_MH auxAris = aux.dato;
                        aux.dato = aux.sig.dato;
                        aux.sig.dato = auxAris;
                        huboCambio = true;
                    }
                    aux = aux.sig;
                }
            } while (huboCambio);
        }
    }
    
    public void mostrar() {
        if (isEmpty()) {
            System.out.println("Lista vacía");
            return;
        }
        NodoArisLeonel_MH aux = ini;
        while (aux != null) {
            System.out.print("(" + aux.dato.nodoIni + " -> " + aux.dato.nodoFin + " | Peso: " + aux.dato.peso + ") ");
            aux = aux.sig;
        }
        System.out.println();
    }  
}
    

