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
public class Empleado {
    private String nombre;
    private ArrayList<Hotel> numEmpleo;
    public Empleado(String nombre){
        this.nombre= nombre;
        
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public boolean addTrabajo(Hotel hotel){
        if ( this.numEmpleo.size() > 2){
            return false;
        }else{
            this.numEmpleo.add(hotel);
            return true;
        }
       
    }
}
