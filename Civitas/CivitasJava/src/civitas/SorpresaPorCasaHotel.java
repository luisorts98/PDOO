/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.ArrayList;

/**
 *
 * @author Luis
 */
public class SorpresaPorCasaHotel extends Sorpresa {
    
    private String texto;
    private int valor;
    MazoSorpresas mazo;
    Tablero tablero;
    
    SorpresaPorCasaHotel(Tablero tablero, int valor, String texto){
        this.tablero = tablero;
        this.texto = texto;
        this.valor = valor;
        this.mazo = new MazoSorpresas();
        
    }
    public int getValor(){
        return valor;
    }
    
       void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        this.informe(actual, todos);
        todos.get(actual).modificaSaldo(this.getValor()*todos.get(actual).cantidadCasasHoteles());
    }
        public String toString(){
       String sorpresa = "Tipo: Sorpresa Por Casa Hotel \n";
       sorpresa += this.texto;
       return sorpresa;
    }
    
    
}
