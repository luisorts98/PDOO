/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosS2;

/**
 *
 * @author Luis
 */
public class testhotel {
       /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Sesion 1: ");
        System.out.println("Ejercicio 1:");                             
        Hotel hotel1 = new Hotel("BACU", "Granada", 4);
        Hotel hotel2 = new Hotel("TETE", "Granada", 4);
        
        System.out.println("Num Hoteles " + Hotel.getNUM_HOTELES());
        
        
        System.out.println("\nEjercicio 2:");                             

        Director director = new Director("Pablo Perez", 613841912);
        hotel1.setDirector(director);
        System.out.println("Nombre del director del primer hotel: " + hotel1.getDirector());
       
        System.out.println("\nEjercicio 3:");
        Cliente cliente = new Cliente("32098765Q", "Juan Lopez");
        hotel2.addReserva(cliente, "6/10/2021", "10/10/2021", hotel1);

        
        System.out.println("Recorro hotel: ");
        for (int i = 0; i < hotel2.getReservas().size(); i++){
            System.out.println(hotel2.getReservas().get(i).getCliente().getNombre() + " " + hotel2.getReservas().get(i).getFechaEntrada());
        }
        
        System.out.println("\nRecorro cliente: ");
        for (int i = 0; i < cliente.getReservas().size(); i++){
            System.out.println(cliente.getReservas().get(i).getFechaEntrada());
        }
        
        
        System.out.println("\n\nSesion 2:");

        hotel1.addEmpleado("Pedro");
        hotel1.addEmpleado("Pablo");
        
        System.out.println("El hotel 1 tiene: " + hotel1.getEmpleados().size() + " empleado/s");
        System.out.println("Los empleados son: ");
        
        for (int i = 0; i < hotel1.getEmpleados().size(); i++){
            System.out.print(hotel1.getEmpleados().get(i).getNombre() + " ");
        }
        
        hotel2.addHabitacion(211, 3);
        hotel2.addHabitacion(240, 1);
        
        System.out.println("\nUna habitacion con capacidad para 3 personas es la habitación: " + hotel2.buscarHabitacionCapacidad(3));

    }
    

}
