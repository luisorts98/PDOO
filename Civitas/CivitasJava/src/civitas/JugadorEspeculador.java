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
public class JugadorEspeculador extends Jugador {

    protected static int CasasMax = 8;
    protected static int HotelesMax = 8;
    static int FactorEspeculador = 2;
 //   float fianza;

    //Constructor
    public JugadorEspeculador(Jugador jugador ) { // String nombre, int casillaActual, boolean puedeComprar //
        super(jugador);
        
   
        jugador.cedePropiedadesA(this); //Método para transicionar las propiedades a especulador
        actualizaPropietarioPorConversion(jugador);
    }
    void actualizaPropietarioPorConversion(Jugador jugador){
        int tam = jugador.getPropiedades().size();
        if(tam > 0){
            for(int i=0; i< tam; i++){
                jugador.getPropiedades().get(i).actualizaPropiedadesPorConversion(this);
            }
        }
        
        
    }
   

    //Realiza el proceso de pago de impuestos de ser posible. Devuelve si es posible
    
 
boolean paga(float cantidad){
    float nuevaCantidad = cantidad/FactorEspeculador;
    
    Diario.getInstance().ocurreEvento("Paga" + nuevaCantidad + "por ser especulador");
    return super.paga(nuevaCantidad);
}
   
    
    
    

    //Get de casasMax
    int getCasasMax() {
        return CasasMax * FactorEspeculador;
    }

    //Get de HotelesMax
    int getHotelesMax() {
        return HotelesMax * FactorEspeculador;
    }
    
    //Devuelve si el jugador puede edificar una casa en la Propiedad propiedad
    @Override
    boolean puedoEdificarCasa(CasillaCalle propiedad) {  //antes era casilla
        return (propiedad.getNumCasas() < CasasMax ? true : false);
    }

    //Devuelve si el jugador puede edificar un hotel en la Propiedad propiedad
    @Override
    boolean puedoEdificarHotel(CasillaCalle propiedad) {
       return (propiedad.getNumHoteles() < HotelesMax ? true : false);
    }

    //toString
    @Override
    public String toString() {
      String cadena = "";
        cadena = "Jugador: " + this.getNombre()+ ", es un jugador especulador" + ". Saldo: " + this.getSaldo() + ". Casilla Actual: " + this.getCasillaActual();
        
        if(this.getPropiedades().size() > 0){
            for (int i=0; i<this.getPropiedades().size(); i++){
                cadena += " Propiedad " + i + " " + this.getPropiedades().get(i).getNombre();
            }
        }
        
        return cadena; 
    }
    
}