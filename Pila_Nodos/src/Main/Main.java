/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;
import Estructuras.*;

/**
 *
 * @author Matos
 */
public class Main {

   
    public static void main(String[] args) {
        PilaNodo pilaA = new PilaNodo(5);
        PilaNodo pilaB = new PilaNodo(5);

        System.out.println("--- LLENANDO PILA A (PUSH) ---");
        pilaA.push(new Nodo(10));
        pilaA.push(new Nodo(20));
        pilaA.push(new Nodo(30));

        System.out.println("\nEstado de Pila A (Original):");
        pilaA.mostrarPila();

        System.out.println("\n--- CONSULTANDO EL TOPE (PEEK) ---");
        System.out.println("El dato en el tope es: " + pilaA.obtenerTope());

        System.out.println("\n--- MOVIENDO DE PILA A -> PILA B ---");
        pilaA.moverA(pilaB);

        System.out.println("\nEstado de Pila A (después de mover):");
        pilaA.mostrarPila(); // Debe decir que está vacía

        System.out.println("\nEstado de Pila B (Destino):");
        pilaB.mostrarPila(); // Debe mostrar [30] en el tope, luego [20], luego [10]
      
    }
    
}
