/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosjavap4;
import java.util.ArrayList;
/**
 *
 * @author Luis
 */
public class EjerciciosJavaP4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     //   Casilla c = new Casilla("Pablo");
     //   Casilla cc = new CasillaCalle("Pablo", 4);
     //   c.recibeJugador();
     //   cc.recibeJugador(); //Se puede usar el metodo del padre puesto que es el mismo
                             // ejecuta el metodo del  hijo
                            // 
        
     //4
    // c.construirCasa(); da error de compilación
    //cc.construirCasa();
  //  ArrayList<Casilla> tablero = new ArrayList<>();
   // tablero.add(c); tablero.add(cc);
    
    //tablero.get(0).contruirCasa(); //no se puede porque Casilla no tiene ni el atrivuto ni el meotod construirCasa
    //se soluciona haciendo un casting ((CasillaCalle) tablero.get(1)).construirCasa();
    
    Casilla calle = new CasillaCalle("luis", 0);
        calle.recibeJugador();
        CasillaCalle casilla1 = new CasillaCalle("Juan", 0);
        
        Casilla casilla2 = new Casilla("Pedro");
        
        casilla2 = casilla1; //asignar el valor de la casilla1 a la casilla2
        
        casilla1.recibeJugador(); 
        casilla2.recibeJugador(); //ejecutan ambos el del hijo porque ahora casilla2 apunta en memoria al lugar de CasillaCalle por lo que ejecutaran el metodo del hijo
        casilla1.construirCasa(); 
        ((CasillaCalle) casilla2).construirCasa(); //es necesario hacer un casting
    }                       

    
}
