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
public class Habitacion {
    private int numero;
    private int capacidad;
    private Hotel hotel;
    
    public Habitacion(int numero, int capacidad){
        this.numero = numero;
        this.capacidad = capacidad;
        
    }
    public int getCapacidad(){
        return capacidad;
    }
    
    public int getNumero(){
        return numero;
    }
}
