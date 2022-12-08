/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.ArrayList;

public class Diario {
//Es un singleton.La propia clase almacena la referencia a la única instancia
  static final private Diario instance = new Diario();
  
  private final ArrayList<String> eventos;
  //Metodo de clase para obtener la instancia
  static public Diario getInstance() {
    return instance;
  }

    public ArrayList<String> getEventos() {
        return eventos;
    }
  
  
  //constructor privado apra evitar que se puedan crear más instancias
  public Diario () { //LO PONEMOS PUBLICO POR LA P5
    eventos = new ArrayList<>();
  }
 
  
  void ocurreEvento (String e) {
    eventos.add (e);
  }
  
  public boolean eventosPendientes () {
    return !eventos.isEmpty();
  }
  
  public String leerEvento () {
    String salida = "";
    if (!eventos.isEmpty()) {
      salida = eventos.remove(0);
    }
    return salida;
  }
  
}
