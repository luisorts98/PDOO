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
public abstract class Sorpresa {
    String texto;
    int valor;
 
    /*Sorpresa(String unTexto, int unValor, Sorpresa tipo){
        this.valor = unValor;
        this.texto = unTexto;
        tipo = tipo;
    }*/
     void informe(int actual, ArrayList<Jugador> todos) //informa al diario que se está aplicando una sorpresa a un jugador ( se indica el nombre de este)
    {
     
            Diario.getInstance().ocurreEvento("Aplicando sorpresa("+toString()+")a "+todos.get(actual).getNombre());
        
       
               
    }
    
  abstract  void aplicarAJugador(int actual, ArrayList<Jugador> todos); 
      //  if(this.jugadorCorrecto(actual, todos)){
            //this.informe(actual, todos);
        
 
  public  String toString(){ //MIRARRRR
        return texto;
    }
} 
