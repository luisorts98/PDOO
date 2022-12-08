/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;
import GUI.CapturaNombres;
import java.util.ArrayList;
import civitas.Civitas;
import controladorCivitas.Controlador;
import civitas.Dado;
import GUI.CivitasView;

/**
 *
 * @author Luis
 */
public class TestP5 {
   public static void main(String[] args) {
        // TODO code application logic here
        CivitasView vista=new CivitasView(); //crear un objeto civitasView
       // Dado.createInstance(civitas);
       // Dado.getInstance().setDebug(false); // Si debug = true -> Valor = 1
        
        CapturaNombres capturaNombres=new CapturaNombres(vista, true); //creamos una instancia de captura nombres usando dos argumentos
        //deberia ser vista y true pero no se porque ponemos civitas creo que poe lo de arriba
        ArrayList<String> nombres=new ArrayList<>(); //creamos un arraylist con nombres vacios y asignamos los nombres que se obteengan
        nombres=capturaNombres.getNombres(); //tras enviar el mensaje getNombres a la instancia de CapturaNombres
        
        Civitas juego=new Civitas(nombres, true); //crear un objeto de civitas que reciba como argumento de sus constructor los nombres
        //anteriores y el mdodo debug
        Controlador controlador=new Controlador(juego,vista ); 
        
        vista.setCivitasJuego(juego); //enviar un mensaje setCivitasJuego con el objetod civitasjuego creado
        
        controlador.juega(); //se pide al controlador que empiece el juego
    }
    
}