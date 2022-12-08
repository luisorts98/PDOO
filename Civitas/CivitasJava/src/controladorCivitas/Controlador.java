/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorCivitas;

/**
 *
 * @author Luis
 */
import java.util.ArrayList;
import civitas.Civitas;
import civitas.GestionInmobiliaria;
import civitas.Jugador;
import civitas.OperacionInmobiliaria;
import civitas.OperacionJuego;
import controladorCivitas.Respuesta;
import GUI.VistaTextual;
import GUI.CivitasView;

public class Controlador {

    private final Civitas juego;
   
    private final CivitasView vista;
    //Constructor
    //MODIFICACIÓN AL MARGEN DE GUIÓN:
    //  -Lo he puesto 'public' ya que es necesario dado que el modelo se
    //   implementa en el paquete civitas
    public Controlador(Civitas juegoModel, CivitasView _vista)
    {
        this.juego = juegoModel;
        vista = _vista;
    }

    //Método único de Controlador. Donde se llevará a cabo la partida
    //MODIFICACIÓN AL MARGEN DE GUIÓN:
    //  -Lo he puesto 'public' ya que es necesario dado que el modelo se
    //   implementa en el paquete civitas
    public void juega()
    {
 
       
        System.out.println("\t======== 0 ========");
      

        int it = 0;
        while (!juego.finalDelJuego()) {
            it++;
            //Para separar en el terminal cada iteracion
            for (int i = 0; i < 3; i++) {
                System.out.println(" ");
            }

            System.out.println("\t======== " + it + " ========");

            for (int i = 0; i < 3; i++) {
                System.out.println(" ");
            }

            vista.actualiza(); 
            vista.pausa(); // indica a vista que haga una pausa. Esto hará que el juego espere la interacción del usuario entre turno y turno
          OperacionJuego  operacion = juego.siguientePaso(); //pedir al modelo que lleve acabo el siguietne paso
            vista.mostrarSiguienteOperacion(operacion); //pedir a vista que muestre la siguiente operación arealizar 

            if (operacion != OperacionJuego.PASAR_TURNO) { //si la operacion anterior no es pasar de turno  indicar a la vista que muestre los eventos
                vista.mostrarEventos(); //pendientes del diario
               //juegoModel.finalDelJuego();
            }
           
            if (!juego.finalDelJuego()) {
                switch (operacion) {
                    case COMPRAR:
                        if (vista.comprar() == Respuesta.SI) {
                            juego.comprar();
                              //juego.siguientePasoCompletado(operacion); //SI SALE ALGO RARO QUITAR
                        }
                        juego.siguientePasoCompletado(operacion);
                        vista.mostrarEventos();
                        break;

                    case GESTIONAR:
                        OperacionInmobiliaria opcion =   vista.elegirOperacion();
                         
                    //    vista.elegirPropiedad();
                        if(opcion != OperacionInmobiliaria.TERMINAR){  
                     vista.elegirPropiedad();
                        }
                         GestionInmobiliaria gestInmobiliaria
                                = new GestionInmobiliaria(opcion, vista.elegirPropiedad());
                        
                        
                   
                        

                      

                        switch (gestInmobiliaria.getOperacion()) {
                          
                            case CONSTRUIR_CASA:
                                juego.construirCasa(vista.elegirPropiedad());
                                juego.siguientePasoCompletado(operacion);
                                break;
                            case CONSTRUIR_HOTEL:
                                juego.construirHotel(vista.elegirPropiedad());
                                juego.siguientePasoCompletado(operacion); //ANTES NO ESTABA SIRVE POR SI QUEREMOS QUE SE QUEDE EL TURNO AL COMPRAR O PASA EL TURNO AL COMPRAR 1 SOLA CASA O HOTEL
                                break;
                            case TERMINAR:
                                juego.siguientePasoCompletado(operacion);
                                vista.mostrarEventos(); //NO SE SI PONERLO
                                break; 
                        }     
                }
            }
        }
        
        //RANKING
        int i = 1;
        System.out.print("**********Juego terminado**********\n");
        for (Jugador jugador:juego.ranking())  {
            System.out.print("\n====================================\n"+i+")"+jugador.toString());
            i++;
        }
        vista.actualiza(); //MIRAR
        
    }
    // Case HACERME:
                           //juego.hacerCalleSostenible(vista.elegirPropiedad());
}