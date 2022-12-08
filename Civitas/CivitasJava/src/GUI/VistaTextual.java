/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Luis
 */
package GUI;

import civitas.Casilla;
import civitas.Civitas;
import civitas.Diario;
import civitas.CasillaCalle;
import civitas.Jugador;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


import civitas.OperacionInmobiliaria;
import civitas.OperacionJuego;
import controladorCivitas.Respuesta;



public class VistaTextual implements Vista {
  
    
  private static String separador = "=====================";
  
  private Scanner in;
 private int iGestion = -1;
  int iPropiedad = -1;
  Civitas juegoModel;
  
  public VistaTextual (Civitas juegoModel) {
    in = new Scanner (System.in);
    this.juegoModel=juegoModel;
  }
  
  
           
 public  void pausa() {
    System.out.print ("\nPulsa una tecla");
    in.nextLine();
  }

 
  public void actualiza(){ //FALTAN COSAS
      Jugador jugadorActual = juegoModel.getJugadorActual();
     System.out.println("JUGADOR:\n" + juegoModel.getJugadorActual().toString());
    int numCasilla = jugadorActual.getCasillaActual();
    Casilla casillaActual = juegoModel.getTablero().getCasilla(numCasilla);
    System.out.println("CASILLA:\n" + casillaActual.toString());
       if (!juegoModel.finalDelJuego()) {
            int i = 1;
        System.out.print("**********Juego terminado**********\n");
        for (Jugador jugador:juegoModel.ranking())  {
            System.out.print("\n====================================\n"+i+")"+jugador.toString());
            i++;
        }
        
       }
 }
 @Override
 public controladorCivitas.Respuesta comprar(){
     int opcion = menu("¿DESEA COMPRAR ESTA CALLE?", new ArrayList<>(Arrays.asList("SI", "NO")));
     return controladorCivitas.Respuesta.values()[opcion]; //Para decir si o no a la pregunta desde teclado
 }
 @Override
 public OperacionInmobiliaria elegirOperacion(){ //REVISAR
     /*int gestion;
     
     gestion = menu("Qué gestion desea realizar?",
             new ArrayList<>(Arrays.asList( "Construir casa", "Construir hotel", "Terminar"))); //REVIAR ASLIST
     return civitas.OperacionInmobiliaria.values()[gestion];*/
     
      String titulo = "Elegir operación Inmobiliaria";
      ArrayList<String> lista = new ArrayList<>();
      lista.add("CONSTRUIR_CASA");
      lista.add("CONSTRUIR_HOTEL");
      lista.add("TERMINAR");
      
      int opcion = menu(titulo, lista);
      
      OperacionInmobiliaria operacion = OperacionInmobiliaria.values()[opcion];
      
      return operacion;
   }
 @Override
 public int elegirPropiedad(){ //SI NO FUNCIONA CAMBIAR 
   /*  int propiedad;
    propiedad = menu("¿Sobre que propiedad quiere operar?",
            juegoModel.getJugadorActual().getNombrePropiedades()); 
    
    propiedad = iPropiedad;
    return propiedad;*/
  Jugador jugadorActual = juegoModel.getJugadorActual();
      ArrayList<CasillaCalle> propiedades = jugadorActual.getPropiedades();
      
      String titulo = "Elije la propiedad sobre la que desea realizar la gestión";
      ArrayList<String> lista = new ArrayList<>();
      
      for(int i=0; i < propiedades.size(); i++){
          lista.add(propiedades.get(i).getNombre());
      }
      
      int indice = menu(titulo, lista);
      
      if(indice > propiedades.size()){
          indice = -1;
      }
      
      return indice;
    
}
 @Override
 public void mostrarEventos(){
     
     while (Diario.getInstance().eventosPendientes()){
         System.out.print(Diario.getInstance().leerEvento());
     }
     
 }
 
 public void mostrarSiguienteOperacion(OperacionJuego operacion){
     System.out.print("La siguiente operacion es: " + operacion.toString());
     
 }
 

  int leeEntero (int max, String msg1, String msg2) {
    Boolean ok;
    String cadena;
    int numero = -1;
    do {
      System.out.print (msg1);
      cadena = in.nextLine();
      try {  
        numero = Integer.parseInt(cadena);
        ok = true;
      } catch (NumberFormatException e) { // No se ha introducido un entero
        System.out.println (msg2);
        ok = false;  
      }
      if (ok && (numero < 0 || numero >= max)) {
        System.out.println (msg2);
        ok = false;
      }
    } while (!ok);

    return numero;
  }

  int menu (String titulo, ArrayList<String> lista) {
    String tab = "  ";
    int opcion;
    System.out.println (titulo);
    for (int i = 0; i < lista.size(); i++) {
      System.out.println (tab+i+"-"+lista.get(i));
    }

    opcion = leeEntero(lista.size(),
                          "\n"+tab+"Elige una opción: ",
                          tab+"Valor erróneo");
    return opcion;
  }

}
