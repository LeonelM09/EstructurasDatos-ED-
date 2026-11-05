/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafoleonel_mh;

/**
 *
 * @author Matos
 */
public class ColaLeonel_MH {
    NodoLeonel_MH ini;
    NodoLeonel_MH fin;

    public ColaLeonel_MH() {
        this.ini = null;
        this.fin = null;
    }

    public boolean isEmpty() {
        return ini == null;
    }

    public void encolar(int dato) {
        NodoLeonel_MH nuevo = new NodoLeonel_MH(dato);
        if (isEmpty()) {
            ini = nuevo;
            fin = nuevo;
        } else {
            fin.sig = nuevo;
            fin = nuevo;
        }
    }

    public int desencolar() {
        if (isEmpty()) {
            return -1;
        }
        int valor = ini.dato;
        ini = ini.sig;
        if (ini == null) {
            fin = null;
        }
        return valor;
    }
}
