/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colaarray;

/**
 *
 * @author Matos
 */
public class Cola {
    private int[] arreglo;
    private int frente;          
    private int fin;             
    private int capacidadMaxima;
    private int numElementos;    
    public Cola(int tamaño) {
        this.capacidadMaxima = tamaño;
        this.arreglo = new int[capacidadMaxima];
        this.frente = 0;
        this.fin = -1;
        this.numElementos = 0;
    }

    public boolean estaVacia() {
        return numElementos == 0;
    }

    public boolean estaLlena() {
        return numElementos == capacidadMaxima;
    }

    // 1. ENCOLAR (Insertar al final)
    public void encolar(int dato) {
        if (estaLlena()) {
            System.out.println("Error: La cola está llena (Overflow).");
            return;
        }
        fin = (fin + 1) % capacidadMaxima;
        arreglo[fin] = dato;
        numElementos++;
    }

    // 2. DESENCOLAR (Extraer del frente)
    public int desencolar() {
        if (estaVacia()) {
            System.out.println("Error: La cola está vacía (Underflow).");
            return -1;
        }
        int datoExtraido = arreglo[frente];
        
        frente = (frente + 1) % capacidadMaxima;
        numElementos--;
        
        return datoExtraido;
    }

    // 3. OBTENER FRENTE (Peek)
    public int obtenerFrente() {
        if (estaVacia()) {
            System.out.println("La cola está vacía.");
            return -1;
        }
        return arreglo[frente];
    }

    // 4. MOSTRAR ELEMENTOS
    public void mostrarCola() {
        if (estaVacia()) {
            System.out.println("La cola está vacía.");
            return;
        }
        
        System.out.print("Frente -> ");
        int posicionActual = frente;
        
        for (int i = 0; i < numElementos; i++) {
            System.out.print("[" + arreglo[posicionActual] + "] ");
            posicionActual = (posicionActual + 1) % capacidadMaxima; 
        }
        System.out.println("<- Fin");
    }

    // 5. MOVER A OTRA COLA
    public void moverA(Cola destino) {
        if (this.estaVacia()) {
            System.out.println("La cola original está vacía.");
            return;
        }
        while (!this.estaVacia()) {
            destino.encolar(this.desencolar());
        }
    }    
}
