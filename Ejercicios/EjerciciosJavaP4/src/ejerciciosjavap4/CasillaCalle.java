/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosjavap4;

/**
 *
 * @author Luis
 */
public class CasillaCalle extends Casilla {
   
    private int numCasas;
    
    public CasillaCalle(String nombre, int numCasas){
         super(nombre); //ES POR LO DE LA HERENCIA
         this.numCasas = numCasas;
    }
  /*   boolean recibeJugador(){
        System.out.println("se ha recibido un jugador");
                
        return true;        
    }*/
    /*  @Override
      boolean recibeJugador(){
        System.out.println("soy una casilla Calle y he recibido un jugador");
                
        return true;        
    }*/
    //Cambiamos codigo para ver que pasa cuando hacemos el main reutilizacion de padre
    @Override
    boolean recibeJugador(){
        boolean salidaPadre = super.recibeJugador(); //con esto creamos un objeto con lo que saca el padre
        if(salidaPadre){
            System.out.println("y además soy una casilla calle \n");
            return true;
        }else 
            return false;
    }
    
    public void construirCasa(){
        this.numCasas++;
        System.out.println("Tiene" + this.numCasas + "casas");
    }
    
}
