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
public class Director {
    private String nombre;
    private long telefono;
    
    public Director(String nombre, long telefono){
        this.nombre = nombre;
        this.telefono = telefono;
    }
    
    
    //CREAMOS UN CONSTRUCTOR NUEVO PARA PONER LO DE DIRECTOR
    Director(Director unDirector){
        this.nombre = unDirector.nombre;
        this.telefono = unDirector.telefono;
    }
    
    public String getNombre(){
        return nombre;
    }
    
}
