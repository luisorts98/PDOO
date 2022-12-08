/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

/**
 *
 * @author Luis
 */
public class CasillaCalleSostenible extends CasillaCalle {
    
    private float porcentajeInversion;
    
    public CasillaCalleSostenible(String nombre, float precioCompra, float precioEdificar, float precioBaseAlquiler, float porcentajeInversion){
        super(nombre,precioCompra,precioEdificar,precioBaseAlquiler);
        this.porcentajeInversion=porcentajeInversion;
        
    }
    public boolean soySostenible(){
        return true;
    }
    public float getImportehHacermeSostenible(){
        return 0;
    }
    public CasillaCalleSostenible hacermeSostenible(Jugador jugador){
        return null;
    }
    public String toString(){
        return "la casilla "+super.toString()+"essotenible con un porcentaje"+porcentajeInversion+'}';
    
    
}
    public float getPrecioAlquilerCompleto(){
        float precioAlquilerCompletoAntiguo = super.getPrecioAlquilerCompleto();
        return precioAlquilerCompletoAntiguo + precioAlquilerCompletoAntiguo*porcentajeInversion/100;
        
    }
    
}
