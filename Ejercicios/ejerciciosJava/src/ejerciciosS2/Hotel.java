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
public class Hotel {
    private static int NUM_HOTELES;
    private String nombre;
    private String ciudad;
    private int estrellas;
    private Director director; //para hacer lo de setDirector
    private ArrayList<Reserva> reservas; //porque en el diagrama sale 1..* reservas
    private ArrayList<Empleado> empleados; // lista con los empleados para poder añadir más 
    //empleados y porque sale en el diagrama empleados 1..2
    private ArrayList<Habitacion> habitaciones; //para meter habitaciones; Y porque tiene una realacion
    //con hotel que pone tiene 1..* habitaciones
    public Hotel (String nombre, String ciudad, int estrellas){
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estrellas = estrellas;
        NUM_HOTELES++; // se debe de actualizar convenientemente en el constructor
        reservas = new ArrayList<>();
        empleados = new ArrayList<>();
        habitaciones = new ArrayList<>(); //CREO QUE NO HACEN FALTAN PERO BUENO inizializamos los arrays
        this.director=director;    
    }
   static public int getNUM_HOTELES(){ //por lo de las mayusculas
    return NUM_HOTELES;
}
    public void setDirector(Director unDirector){
        director = new Director(unDirector);
    }
    public String getDirector(){
        return director.getNombre(); //para pillar el nombre del director
    }
    
    public void addReserva(Cliente cliente, String fechaEntrada, String fechaSalida, Hotel hotel){
        Reserva r = new Reserva(fechaEntrada, fechaSalida, cliente, this); //creamos una reserva
        reservas.add(r); //la añadimos a reservas
        cliente.addReserva(r); //el cliente añade una reserva con esa reserva
    }
    public ArrayList<Reserva> getReservas(){
        return reservas;
    
    }
    
    public boolean addEmpleado(String nombre){ //Cambiamos Empleado empleado por String nombre que si no no vale
        Empleado e = new Empleado(nombre);
        return empleados.add(e);
    }
    
    public ArrayList<Empleado> getEmpleados(){
        return empleados;
    }
    
    public void addHabitacion(int numero, int capacidad){
        Habitacion h = new Habitacion(numero,capacidad); //crea una habitación para la reserva
        habitaciones.add(h);
    }
    
    public int buscarHabitacionCapacidad(int capacidad){
        int numHab = -1;
        for (int i = 0; i< habitaciones.size();i++){ //para todas las habitaciones
            if (capacidad == habitaciones.get(i).getCapacidad()){ //si la capacidad pasada por parametro es igaul que la capacidad
                //de la habitación se devuvle el numero de esa habitación
                numHab = habitaciones.get(i).getNumero();
            }
        }
        return numHab;
    }
}


