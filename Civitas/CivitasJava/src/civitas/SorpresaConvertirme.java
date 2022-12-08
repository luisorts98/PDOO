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
public class SorpresaConvertirme extends Sorpresa {
    Civitas juego;
    
    
    SorpresaConvertirme(Civitas _juego){
        //super(titulo,precioCompra, precioEdificar,precioBaseAlquiler); si tuviera esos atributos en el constructor padre
        this.texto = "Sorpresa convierte a Especulador";
        juego = _juego;
        
    }
    
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        
    
    if(!todos.get(actual).esEspeculador()){ 
        informe(actual,todos);
        juego.convertir(todos.get(actual));
        Jugador jugador = todos.get(actual);
        //JugadorEspectualdor especulador = jugador.convertir();
        int indice = todos.indexOf(jugador);
        todos.remove(jugador);
       // todos.add(indice, especulador);
    }
    }
    void informe(int actual, ArrayList<Jugador> todos){
        String evento ="El jugador" + todos.get(actual).getNombre() + "es especulador ahora" + toString();
        Diario.getInstance().ocurreEvento(evento);
    }
    
}
