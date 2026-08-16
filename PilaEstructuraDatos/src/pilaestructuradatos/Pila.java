/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilaestructuradatos;

/**
 *
 * @author Matos
 */
public class Pila {
    int tope;
    int tam;
    int []datos;
    
//Método 1:Constructor
    public Pila(){
        this.tam = 3;
        this.tope = -1;
        this.datos = new int[this.tam];
    }
    
//Método 2:Está vacía?    
    public boolean estaVacia(){
        return tope==-1;
    }

//Método extra (Está llena)
    public boolean estaLlena() {
        return tope == tam - 1; 
    }
    
//Método 3:Agregar elemento (push)
    public void agregar(int elemento){
        if (!estaLlena()){
            tope ++;
            datos[tope] = elemento;
        }    
    }
    
//Método 4:Eliminar elemento (pop)
    public void eliminar(){
        if(!estaVacia()){
           tope--; 
        }
    }
    
//Método 5:Mostrar los datos
    public String mostrar(){
        if(estaVacia()){
            return "La pila esta vacía";
        }
        
        String resultado = "";
        for (int posicionActual = tope; posicionActual >=0; posicionActual--){
            resultado += "[" + datos[posicionActual] + "]\n";
        }
        return resultado;
    }
    
//Método 6:Vaciar la pila
    public void vaciar(){
        tope = -1;
    }
    
//Método 7: Obtener el nodo de la pila
    public int obtenerTope(){
        if(!estaVacia()){
            return datos[tope];
        } else {
            return -1; //indica que no hay nada
        }
    }
    
//Método 8: Mover 
    public void moverPila(Pila p1) {
        
        //Pila temporal
        Pila auxiliar = new Pila();

        while (!p1.estaVacia()) {
            int elemento = p1.obtenerTope(); 
            p1.eliminar();                   
            auxiliar.agregar(elemento);      
        }

        while (!auxiliar.estaVacia()) {
            int elemento = auxiliar.obtenerTope(); 
            auxiliar.eliminar();                   
            this.agregar(elemento);          
        }
    }
}
