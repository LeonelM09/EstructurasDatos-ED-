/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package árbolbinleonel_mh;

/**
 *
 * @author Matos
 */
public class NodoLeonel_MH {
    int dato;
    NodoLeonel_MH izq,der;
    
    public NodoLeonel_MH(int dato){
        this.dato = dato;
        izq = null;
        der = null;
    }
    
    NodoLeonel_MH getIzq() {
        return izq;
    }
    
    void setIzq(NodoLeonel_MH izq) {
        this.izq = izq;
    }
    
    NodoLeonel_MH getDer() {
        return der;
    }
    
    void setDer(NodoLeonel_MH der) {
        this.der = der;
    }
    
    int getDato() {
        return dato;
    }
    
    void setDato(int dato) {
        this.dato = dato;
    }
    
}
