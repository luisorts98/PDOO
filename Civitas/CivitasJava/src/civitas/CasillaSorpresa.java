/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Luis
 */
package civitas;

import java.util.ArrayList;


public class CasillaSorpresa extends Casilla {

    MazoSorpresas mazo = new MazoSorpresas();
    Sorpresa sorpresa;    
    
    private void init(){
        sorpresa = null;
    }
    //Constructor
   public CasillaSorpresa(MazoSorpresas mazo, String nombre) {
        super(nombre);
        this.mazo = mazo;
        init();
        sorpresa = this.mazo.siguiente();
        
    }
    void recibeJugador(int actual, ArrayList<Jugador> todos){
        super.recibeJugador(actual, todos);
        recibeJugador_sorpresa(actual, todos);
    }
    //CasillaSorpresa recibe a jugador
      
   void recibeJugador_sorpresa(int iactual, ArrayList<Jugador> todos){
        // todos.get(iactual).getPuedeComprar();
       // if (super.jugadorCorrecto(iactual, todos)) { MIRARRRRR
            this.informe(iactual, todos);
            Sorpresa sorpresa = mazo.siguiente();
            System.out.println(sorpresa.toString() + " es el tipo de la sorpresa");
            sorpresa.aplicarAJugador(iactual, todos);

       // }
    } 

    //toString
    @Override
    public String toString() {
        return super.toString()
                + "\n\tSorpresa = " + (sorpresa == null ? "null" : sorpresa.toString()
                        + "\n\tMazo = " + (mazo == null ? "null" : mazo.toString()));
    }
}