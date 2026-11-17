/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package árbolbinleonel_mh;
import java.util.Scanner;

/**
 *
 * @author Matos
 */
public class MainÁrbolBinLeonel_MH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ÁrbolBinLeonel_MH arbol = new ÁrbolBinLeonel_MH();
        int opcion = 0;
        int dato;

        do {
            System.out.println("\n--- MENÚ ÁRBOLES BINARIOS DE BÚSQUEDA ---");
            System.out.println("[1] Insertar elemento");
            System.out.println("[2] Mostrar árbol completo acostado (raíz a la izquierda)");
            System.out.println("[3] Graficar árbol completo");
            System.out.println("[4] Buscar un elemento en el árbol");
            System.out.println("[5] Recorrer el árbol en PreOrden");
            System.out.println("[6] Recorrer el árbol en InOrden");
            System.out.println("[7] Recorrer el árbol en PostOrden");
            System.out.println("[8] Eliminar un nodo del árbol PREDECESOR");
            System.out.println("[9] Eliminar un nodo del árbol SUCESOR");
            System.out.println("[10] Recorrer el árbol por niveles (Amplitud)");
            System.out.println("[11] Altura del árbol");
            System.out.println("[12] Cantidad de hojas del árbol");
            System.out.println("[13] Cantidad de nodos del árbol");
            System.out.println("[15] Revisa si es un árbol binario completo");
            System.out.println("[16] Revisa si es un árbol binario lleno");
            System.out.println("[17] Eliminar el árbol (borrar)");
            System.out.println("[0] Salir");
            System.out.print("Elige una opción: ");
            
            opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el dato a insertar: ");
                    dato = sc.nextInt();
                    arbol.insertar(dato);
                    break;
                case 2:
                    System.out.println("Árbol acostado:");
                    arbol.mostrarAcostado();
                    break;
                case 3:
                    System.out.println("Gráfico del árbol:");
                    arbol.graficarArbol();
                    break;
                case 4:
                    System.out.print("Ingresa el dato a buscar: ");
                    dato = sc.nextInt();
                    arbol.buscar(dato);
                    break;
                case 5:
                    arbol.preOrden();
                    break;
                case 6:
                    arbol.inOrden();
                    break;
                case 7:
                    arbol.postOrden();
                    break;
                case 8:
                    System.out.print("Ingresa el dato a eliminar (Predecesor): ");
                    dato = sc.nextInt();
                    arbol.eliminarPredecesor(dato);
                    break;
                case 9:
                    System.out.print("Ingresa el dato a eliminar (Sucesor): ");
                    dato = sc.nextInt();
                    arbol.eliminarSucesor(dato);
                    break;
                case 10:
                    arbol.amplitud();
                    break;
                case 11:
                    arbol.alturaArbol();
                    break;
                case 12:
                    arbol.cantidadHojas();
                    break;
                case 13:
                    arbol.cantidadNodos();
                    break;
                case 15:
                    arbol.esCompleto();
                    break;
                case 16:
                    arbol.esLleno();
                    break;
                case 17:
                    arbol.borrar();
                    System.out.println("El árbol ha sido borrado por completo.");
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
                    break;
            }
        } while (opcion != 0);
    }
    
}
