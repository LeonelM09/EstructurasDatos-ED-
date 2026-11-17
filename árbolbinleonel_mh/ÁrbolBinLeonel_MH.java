/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package árbolbinleonel_mh;

/**
 *
 * @author Matos
 */
public class ÁrbolBinLeonel_MH {
    NodoLeonel_MH raíz;
    
    public ÁrbolBinLeonel_MH(){
        raíz = null;
    }
    
    NodoLeonel_MH getRaiz() {
        return raíz;
    }
    
    public boolean isEmpty(){
        if(raíz == null)
            return true;
        return false;
    }
    
    public void borrar(){
        raíz = null;
    }
    
    public void insertar(int dato) {
        NodoLeonel_MH nuevo = new NodoLeonel_MH(dato);
        if (isEmpty()) {
            raíz = nuevo;
        } else {
            NodoLeonel_MH aux = raíz;
            while (aux != null) {
                if (dato < aux.getDato()) {
                    // Si es menor, va a la izquierda
                    if (aux.getIzq() == null) {
                        aux.setIzq(nuevo);
                        return; // Ya se conectó, terminamos
                    }
                    aux = aux.getIzq(); // Baja por la izquierda
                } else if (dato > aux.getDato()) {
                    // Si es mayor, va a la derecha
                    if (aux.getDer() == null) {
                        aux.setDer(nuevo);
                        return; // Ya se conectó, terminamos
                    }
                    aux = aux.getDer(); // Baja por la derecha
                } else {
                    // Si el dato ya existe en el árbol
                    System.out.println("El dato " + dato + " ya existe en el árbol.");
                    return;
                }
            }
        }
    }
    public void mostrarAcostado() {
        if (isEmpty()) {
            System.out.println("El árbol está vacío.");
        } else {
            mostrarAcostadoRec(raíz, 0);
        }
    }

    // Método recursivo de apoyo que controla los espacios según el nivel
    public void mostrarAcostadoRec(NodoLeonel_MH aux, int nivel) {
        if (aux != null) {
            // 1. Subimos por toda la rama DERECHA
            mostrarAcostadoRec(aux.getDer(), nivel + 1);

            // 2. Imprime espacios según el nivel en el que esta
            for (int esp = 0; esp < nivel; esp++) {
                System.out.print("    "); // 4 espacios por cada nivel de profundidad
            }
            // Imprime el dato del nodo actual
            System.out.println(aux.getDato());

            // 3. Bajamos por la rama IZQUIERDA
            mostrarAcostadoRec(aux.getIzq(), nivel + 1);
        }
    }
    
    // Método de apoyo para saber cuántos niveles de profundidad tiene el árbol
    public int obtenerAltura(NodoLeonel_MH aux) {
        if (aux == null) {
            return 0;
        }
        int alturaIzq = obtenerAltura(aux.getIzq());
        int alturaDer = obtenerAltura(aux.getDer());
        
        if (alturaIzq > alturaDer) {
            return alturaIzq + 1;
        } else {
            return alturaDer + 1;
        }
    }

    // Método de apoyo que imprime todos los nodos de un nivel específico con sus espacios
    public void imprimirNivel(NodoLeonel_MH aux, int nivelActual, int espacios) {
        if (aux == null) {
            // Si no hay nodo en esta posición, dejamos el hueco vacío para no descuadrar el dibujo
            for (int cont = 0; cont < espacios * 2; cont++) {
                System.out.print(" ");
            }
            return;
        }
        
        if (nivelActual == 1) {
            // Espacios antes del número
            for (int cont = 0; cont < espacios; cont++) {
                System.out.print(" ");
            }
            System.out.print(aux.getDato());
            // Espacios después del número
            for (int cont = 0; cont < espacios - 1; cont++) {
                System.out.print(" ");
            }
        } else if (nivelActual > 1) {
            imprimirNivel(aux.getIzq(), nivelActual - 1, espacios);
            imprimirNivel(aux.getDer(), nivelActual - 1, espacios);
        }
    }

    public void graficarArbol() {
        if (isEmpty()) {
            System.out.println("El árbol está vacío.");
            return;
        }
        int altura = obtenerAltura(raíz);
        int espacios = 1;
        
        // Calcula el ancho máximo en la base (2 elevado a la altura)
        for (int p = 0; p < altura; p++) {
            espacios = espacios * 2;
        }

        // ImprimE renglón por renglón (nivel por nivel)
        for (int nivel = 1; nivel <= altura; nivel++) {
            imprimirNivel(raíz, nivel, espacios);
            System.out.println("\n"); // Salto de línea al terminar cada piso del árbol
            espacios = espacios / 2;  // En el siguiente piso hacia abajo, la separación se reduce a la mitad
        }
    }

    public boolean buscar(int dato) {
        if (isEmpty()) {
            System.out.println("El árbol está vacío.");
            return false;
        }
        
        NodoLeonel_MH aux = raíz;
        int nivel = 0; 
        
        while (aux != null) {
            if (dato == aux.getDato()) {
                System.out.println("Dato " + dato + " encontrado en el nivel: " + nivel);
                return true;
            } else if (dato < aux.getDato()) {
                aux = aux.getIzq(); // Busca por la rama izquierda
            } else {
                aux = aux.getDer(); // Busca por la rama derecha
            }
            nivel++;
        }
        
        System.out.println("El dato " + dato + " no se encuentra en el árbol.");
        return false;
    }
    
    public void preOrden() {
        if (isEmpty()) {
            System.out.println("El árbol está vacío.");
        } else {
            System.out.print("Recorrido PreOrden: ");
            preOrdenRec(raíz);
            System.out.println();
        }
    }

    // Método recursivo de apoyo: Raíz -> Izquierda -> Derecha
    public void preOrdenRec(NodoLeonel_MH aux) {
        if (aux != null) {
            System.out.print(aux.getDato() + " -> "); // 1. Visita la Raíz
            preOrdenRec(aux.getIzq());                // 2. Recorre la Izquierda
            preOrdenRec(aux.getDer());                // 3. Recorre la Derecha
        }
    }
    
    public void inOrden() {
        if (isEmpty()) {
            System.out.println("El árbol está vacío.");
        } else {
            System.out.print("Recorrido InOrden: ");
            inOrdenRec(raíz);
            System.out.println(); // Salto de línea al terminar
        }
    }

    // Método recursivo de apoyo: Izquierda -> Raíz -> Derecha
    public void inOrdenRec(NodoLeonel_MH aux) {
        if (aux != null) {
            inOrdenRec(aux.getIzq());                 // 1. Recorre toda la Izquierda
            System.out.print(aux.getDato() + " -> "); // 2. Visita la Raíz (en medio)
            inOrdenRec(aux.getDer());                 // 3. Recorre toda la Derecha
        }
    }
    
    public void postOrden() {
        if (isEmpty()) {
            System.out.println("El árbol está vacío.");
        } else {
            System.out.print("Recorrido PostOrden: ");
            postOrdenRec(raíz);
            System.out.println(); // Salto de línea al terminar
        }
    }

    // Método recursivo de apoyo: Izquierda -> Derecha -> Raíz
    public void postOrdenRec(NodoLeonel_MH aux) {
        if (aux != null) {
            postOrdenRec(aux.getIzq());               // 1. Recorre toda la Izquierda
            postOrdenRec(aux.getDer());               // 2. Recorre toda la Derecha
            System.out.print(aux.getDato() + " -> "); // 3. Visita la Raíz (al final)
        }
    }
    
    public void eliminarPredecesor(int dato) {
        if (isEmpty()) {
            System.out.println("El árbol está vacío.");
            return;
        }

        NodoLeonel_MH aux = raíz;
        NodoLeonel_MH padre = null;
        boolean esHijoIzq = false;

        // 1. Busca el nodo que queremos eliminar y guardamos quién es su padre
        while (aux != null && aux.getDato() != dato) {
            padre = aux;
            if (dato < aux.getDato()) {
                aux = aux.getIzq();
                esHijoIzq = true;
            } else {
                aux = aux.getDer();
                esHijoIzq = false;
            }
        }

        // Si sale del while y aux es null, el número no existe
        if (aux == null) {
            System.out.println("El dato " + dato + " no se encontró en el árbol.");
            return;
        }

        // --- CASO 1: El nodo es una HOJA (no tiene hijos) ---
        if (aux.getIzq() == null && aux.getDer() == null) {
            if (aux == raíz) {
                raíz = null;
            } else if (esHijoIzq) {
                padre.setIzq(null);
            } else {
                padre.setDer(null);
            }
        }
        // --- CASO 2a: Solo tiene hijo IZQUIERDO (no tiene derecho) ---
        else if (aux.getDer() == null) {
            if (aux == raíz) {
                raíz = aux.getIzq();
            } else if (esHijoIzq) {
                padre.setIzq(aux.getIzq());
            } else {
                padre.setDer(aux.getIzq());
            }
        }
        // --- CASO 2b: Solo tiene hijo DERECHO (no tiene izquierdo) ---
        else if (aux.getIzq() == null) {
            if (aux == raíz) {
                raíz = aux.getDer();
            } else if (esHijoIzq) {
                padre.setIzq(aux.getDer());
            } else {
                padre.setDer(aux.getDer());
            }
        }
        // --- CASO 3: Tiene DOS HIJOS (Reemplazo por PREDECESOR) ---
        else {
            // Regla del Predecesor: 1 paso a la IZQUIERDA y luego todo a la DERECHA
            NodoLeonel_MH padrePredecesor = aux;
            NodoLeonel_MH predecesor = aux.getIzq();

            while (predecesor.getDer() != null) {
                padrePredecesor = predecesor;
                predecesor = predecesor.getDer();
            }

            // Copia el valor del predecesor en el nodo que queríamos borrar
            aux.setDato(predecesor.getDato());

            // Desconecta el nodo predecesor de su posición original abajo
            if (padrePredecesor == aux) {
                // Si el predecesor fue el hijo izquierdo inmediato (no avanzó a la derecha)
                padrePredecesor.setIzq(predecesor.getIzq());
            } else {
                // Si avanzó hacia la derecha, conectamos su posible hijo izquierdo al lado derecho de su padre
                padrePredecesor.setDer(predecesor.getIzq());
            }
        }

        System.out.println("Dato " + dato + " eliminado con Predecesor.");
    }
    
    public void eliminarSucesor(int dato) {
        if (isEmpty()) {
            System.out.println("El árbol está vacío.");
            return;
        }

        NodoLeonel_MH aux = raíz;
        NodoLeonel_MH padre = null;
        boolean esHijoIzq = false;

        // 1. Busca el nodo que queremos eliminar y guardamos quién es su padre
        while (aux != null && aux.getDato() != dato) {
            padre = aux;
            if (dato < aux.getDato()) {
                aux = aux.getIzq();
                esHijoIzq = true;
            } else {
                aux = aux.getDer();
                esHijoIzq = false;
            }
        }

        // Si sale del while y aux es null, el número no existe
        if (aux == null) {
            System.out.println("El dato " + dato + " no se encontró en el árbol.");
            return;
        }

        // --- CASO 1: El nodo es una HOJA (no tiene hijos) ---
        if (aux.getIzq() == null && aux.getDer() == null) {
            if (aux == raíz) {
                raíz = null;
            } else if (esHijoIzq) {
                padre.setIzq(null);
            } else {
                padre.setDer(null);
            }
        }
        // --- CASO 2a: Solo tiene hijo IZQUIERDO (no tiene derecho) ---
        else if (aux.getDer() == null) {
            if (aux == raíz) {
                raíz = aux.getIzq();
            } else if (esHijoIzq) {
                padre.setIzq(aux.getIzq());
            } else {
                padre.setDer(aux.getIzq());
            }
        }
        // --- CASO 2b: Solo tiene hijo DERECHO (no tiene izquierdo) ---
        else if (aux.getIzq() == null) {
            if (aux == raíz) {
                raíz = aux.getDer();
            } else if (esHijoIzq) {
                padre.setIzq(aux.getDer());
            } else {
                padre.setDer(aux.getDer());
            }
        }
        // --- CASO 3: Tiene DOS HIJOS (Reemplazo por SUCESOR) ---
        else {
            // Regla del Sucesor: 1 paso a la DERECHA y luego todo a la IZQUIERDA
            NodoLeonel_MH padreSucesor = aux;
            NodoLeonel_MH sucesor = aux.getDer();

            while (sucesor.getIzq() != null) {
                padreSucesor = sucesor;
                sucesor = sucesor.getIzq();
            }

            // Copia el valor del sucesor en el nodo que queríamos borrar
            aux.setDato(sucesor.getDato());

            // Desconecta el nodo sucesor de su posición original abajo
            if (padreSucesor == aux) {
                // Si el sucesor fue el hijo derecho inmediato (no avanzó a la izquierda)
                padreSucesor.setDer(sucesor.getDer());
            } else {
                // Si avanzó hacia la izquierda, conectamos su posible hijo derecho al lado izquierdo de su padre
                padreSucesor.setIzq(sucesor.getDer());
            }
        }

        System.out.println("Dato " + dato + " eliminado con Sucesor.");
    }
    
    public void amplitud() {
        if (isEmpty()) {
            System.out.println("El árbol está vacío.");
        } else {
            System.out.print("Recorrido por Niveles (Amplitud): ");
            int altura = obtenerAltura(raíz);
            // Recorremos piso por piso desde el nivel 1 (raíz) hasta el último
            for (int nivel = 1; nivel <= altura; nivel++) {
                imprimirNivelAmplitud(raíz, nivel);
            }
            System.out.println(); // Salto de línea al terminar
        }
    }

    // Método recursivo de apoyo que imprime únicamente los nodos del nivel indicado
    public void imprimirNivelAmplitud(NodoLeonel_MH aux, int nivel) {
        if (aux != null) {
            if (nivel == 1) {
                // Cuando llega al piso buscado, imprimimos el dato
                System.out.print(aux.getDato() + " -> ");
            } else if (nivel > 1) {
                // Si aún falta bajar pisos, resta 1 al nivel y bajamos por izquierda y derecha
                imprimirNivelAmplitud(aux.getIzq(), nivel - 1);
                imprimirNivelAmplitud(aux.getDer(), nivel - 1);
            }
        }
    }
    
    public void alturaArbol() {
        if (isEmpty()) {
            System.out.println("El árbol está vacío (Altura: 0).");
        } else {
            int altura = obtenerAltura(raíz);
            System.out.println("La altura del árbol es: " + altura);
        }
    }
    
    public void cantidadHojas() {
        if (isEmpty()) {
            System.out.println("El árbol está vacío (Hojas: 0).");
        } else {
            int totalHojas = contarHojasRec(raíz);
            System.out.println("La cantidad de hojas del árbol es: " + totalHojas);
        }
    }

    // Método recursivo de apoyo que cuenta cuántos nodos no tienen hijos
    public int contarHojasRec(NodoLeonel_MH aux) {
        if (aux == null) {
            return 0;
        }
        // Si no tiene hijo izquierdo ni hijo derecho, este nodo es una hoja
        if (aux.getIzq() == null && aux.getDer() == null) {
            return 1;
        }
        // Si tiene al menos un hijo, sigue buscando abajo y suma ambos lados
        return contarHojasRec(aux.getIzq()) + contarHojasRec(aux.getDer());
    }
    
    public void cantidadNodos() {
        if (isEmpty()) {
            System.out.println("El árbol está vacío (Nodos: 0).");
        } else {
            int totalNodos = contarNodosRec(raíz);
            System.out.println("La cantidad total de nodos del árbol es: " + totalNodos);
        }
    }

    // Método recursivo de apoyo que cuenta todos los nodos del árbol
    public int contarNodosRec(NodoLeonel_MH aux) {
        if (aux == null) {
            return 0;
        }
        // Cuenta 1 (el nodo actual) + los de su izquierda + los de su derecha
        return 1 + contarNodosRec(aux.getIzq()) + contarNodosRec(aux.getDer());
    }
    
    public void esCompleto() {
        if (isEmpty()) {
            System.out.println("El árbol está vacío.");
        } else {
            int totalNodos = contarNodosRec(raíz);
            if (esCompletoRec(raíz, 0, totalNodos)) {
                System.out.println("El árbol SÍ es un árbol binario completo.");
            } else {
                System.out.println("El árbol NO es un árbol binario completo.");
            }
        }
    }

    // Método recursivo de apoyo que verifica que ningún nodo se salte un hueco
    public boolean esCompletoRec(NodoLeonel_MH aux, int indice, int totalNodos) {
        // Un subárbol vacío no rompe la regla
        if (aux == null) {
            return true;
        }
        // Si el índice del nodo actual supera o iguala al total de nodos, hubo un hueco antes
        if (indice >= totalNodos) {
            return false;
        }
        // Revisa que tanto la rama izquierda como la derecha cumplan la regla
        return esCompletoRec(aux.getIzq(), 2 * indice + 1, totalNodos) &&
               esCompletoRec(aux.getDer(), 2 * indice + 2, totalNodos);
    }
    
    public void esLleno() {
        if (isEmpty()) {
            System.out.println("El árbol está vacío.");
        } else {
            if (esLlenoRec(raíz)) {
                System.out.println("El árbol SÍ es un árbol binario lleno.");
            } else {
                System.out.println("El árbol NO es un árbol binario lleno.");
            }
        }
    }

    // Método recursivo de apoyo: verifica que cada nodo tenga 0 o 2 hijos
    public boolean esLlenoRec(NodoLeonel_MH aux) {
        if (aux == null) {
            return true;
        }
        // Si es una hoja (0 hijos), cumple la regla
        if (aux.getIzq() == null && aux.getDer() == null) {
            return true;
        }
        // Si tiene ambos hijos (2 hijos), revisamos que sus dos ramas también sean llenas
        if (aux.getIzq() != null && aux.getDer() != null) {
            return esLlenoRec(aux.getIzq()) && esLlenoRec(aux.getDer());
        }
        // Si llegó aquí, significa que solo tiene 1 hijo (no es lleno)
        return false;
    }
      
}
