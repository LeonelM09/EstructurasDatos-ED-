/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package colaarray;

/**
 *
 * @author Matos
 */
public class ColaArray {
    public static void main(String[] args) {
        Cola colaA = new Cola(5);
        Cola colaB = new Cola(5);

        System.out.println("--- LLENANDO COLA A ---");
        colaA.encolar(10);
        colaA.encolar(20);
        colaA.encolar(30);
        colaA.mostrarCola();

        System.out.println("Saca al primero: " + colaA.desencolar());
        colaA.encolar(40);
        colaA.encolar(50);
        colaA.encolar(60); 
        colaA.mostrarCola();

        System.out.println("\n--- MOVIENDO DE COLA A -> COLA B ---");
        colaA.moverA(colaB);
        
        System.out.println("Estado final Cola A (Original):");
        colaA.mostrarCola(); 
        
        System.out.println("Estado final Cola B (Destino):");
        colaB.mostrarCola();  
    }
    
}
