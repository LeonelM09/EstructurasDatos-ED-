/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author Matos
 */
public class Nodo {
    private int dato;
    private Nodo sig; 

    // 2. Constructor
    public Nodo(int dato) {
        this.dato = dato;
        this.sig = null; 
    }

    // 3. Getters y Setters para el dato
    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    // 4. Getters y Setters para el apuntador
    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }

    @Override
    public String toString() {
        return "[" + dato + "]";
    }   
}
