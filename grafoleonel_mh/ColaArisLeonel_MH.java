/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafoleonel_mh;

/**
 *
 * @author Matos
 */
public class ColaArisLeonel_MH {
    ListaLeonel_MH lista;
    
    public ColaArisLeonel_MH(){
        lista = new ListaLeonel_MH();
    }
    
    public boolean isEmpty(){
        return lista.isEmpty();
    }
    
    public void encolar(AristaLeonel_MH dato){ // No devuelve nada y pide una Arista
        lista.insertarUlt(dato); // Insertamos al último la Arista
    }
    
    public AristaLeonel_MH desencolar(){
        return lista.desencolar(); // Siempre que se quita un elemento se retorna
    }
    
    public void ordenar(){
        lista.ordenar();
    }
    
    public void actualiza(int nodoIni, int nodoFin, int peso){
        AristaLeonel_MH nodo = lista.getElem(nodoIni);
        
        if(nodo != null){
            if(nodo.peso == -1 || nodo.peso > peso){
                nodo.peso = peso;
                nodo.nodoFin = nodoFin;
            }
            lista.insertar(nodo);
        }
    }  
}
