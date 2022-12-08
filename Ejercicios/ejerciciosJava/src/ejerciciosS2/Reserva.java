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
public class Reserva {
    private String fechaEntrada;
    private String fechaSalida;
    private Cliente cliente; //PARA PODER HACER LO DE GETCLIENTE Y QUE SE PUEDA PONER EL RETURN
    private Hotel hotel; //para poder poner lo de hotel en el constructor
    
    public Reserva(String fechaEntrada, String fechaSalida, Cliente cliente, Hotel hotel){
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.cliente = cliente;
        this.hotel = hotel;
    }
    
    public String getFechaEntrada(){
        return fechaEntrada;
    }
    public Cliente getCliente(){
        return cliente;
    }
}

