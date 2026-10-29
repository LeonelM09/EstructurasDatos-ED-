/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafoleonel_mh;

/**
 *
 * @author Matos
 */
public class AristaLeonel_MH {
    int nodoIni, nodoFin, peso;
    
    public AristaLeonel_MH(int nodoIni, int nodoFin, int peso){
        this.nodoIni = nodoIni;
        this.nodoFin = nodoFin;
        this.peso = peso;
    }
    
    public AristaLeonel_MH(int nodoIni){
        this.nodoIni = nodoIni;
        this.nodoFin = -1;
        this.peso = -1;
    } 
}
