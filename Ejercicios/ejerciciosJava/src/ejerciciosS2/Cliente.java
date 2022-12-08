/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosS2;
import java.util.ArrayList;
/**
 *
 * @author Luis
 */
public class Cliente {
    private String dni;
    private String nombre;
    private ArrayList<Reserva> reservas; //porque sale en el diagrama en su relacion 0..* reserva
    
    public Cliente(String dni, String nombre){
        this.dni = dni;
        this.nombre = nombre;
        reservas = new ArrayList<>(); //para crear un arrayList de reserva suyo // son
        //dos reservas una las registran los hoteles y otras los clientes
    }
    
    public String getNombre(){
        return nombre;
    }
    public void addReserva(Reserva reserva){ //como solo añadimos pues 
        reservas.add(reserva); //Añadimos una reserva en el arraylist de reservas
    }
    
    public ArrayList<Reserva> getReservas(){
        return reservas;
    }
}
