/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author Matos
 */
public class PilaNodo {
    private Nodo[] arreglo;
    private int tope;
    private int capacidadMaxima;

    // 1. Constructor
    public PilaNodo(int tamaño) {
        this.capacidadMaxima = tamaño;
        this.arreglo = new Nodo[capacidadMaxima]; 
        this.tope = -1;
    }

    public boolean estaVacia() {
        return tope == -1;
    }

    public boolean estaLlena() {
        return tope == capacidadMaxima - 1;
    }

    // 2. PUSH (Insertar un Nodo)
    public void push(Nodo nuevoNodo) {
        if (estaLlena()) {
            System.out.println("Error de desbordamiento: La pila está llena.");
            return;
        }
        tope++;
        arreglo[tope] = nuevoNodo; 
    }

    // 3. POP (Extraer el Nodo del tope)
    public Nodo pop() {
        if (estaVacia()) {
            System.out.println("Error: La pila está vacía.");
            return null; 
        }
        
        Nodo extraido = arreglo[tope];
        arreglo[tope] = null; // Limpieza de memoria (Garbage Collector)
        tope--;
        return extraido;
    }

    // 4. PEEK (Consultar sin extraer)
    public Nodo obtenerTope() {
        if (estaVacia()) {
            System.out.println("La pila está vacía.");
            return null;
        }
        return arreglo[tope];
    }

    // 5. MOSTRAR ELEMENTOS
    public void mostrarPila() {
        if (estaVacia()) {
            System.out.println("La pila está vacía.");
            return;
        }
        System.out.println("=== TOPE ===");
        for (int i = tope; i >= 0; i--) {
            System.out.println(arreglo[i].toString()); 
        }
        System.out.println("=== BASE ===");
    }

    // 6. MOVER A OTRA PILA (Conservando el orden)
    public void moverA(PilaNodo destino) {
        if (this.estaVacia()) {
            System.out.println("No hay elementos para mover.");
            return;
        }

        // Pila puente auxiliar
        PilaNodo aux = new PilaNodo(this.capacidadMaxima);

        // PASO 1: Vacia la original hacia la auxiliar (Orden invertido)
        while (!this.estaVacia()) {
            aux.push(this.pop());
        }

        // PASO 2: Vacia la auxiliar hacia el destino (Orden restaurado)
        while (!aux.estaVacia()) {
            destino.push(aux.pop());
        }
    }
}
