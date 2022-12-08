/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejerciciosS1;

/**
 *
 * @author Luis
 */
public class Parcela {
    private String nombre;
    private float precioCompra;
    private float precioEdificar;  ///TODO ESYO SON ATRIBUTOS DE INSTANCIA
    private float precioBaseAlquiler;
    private int numCasas;
    private int numHoteles;
    static private float FACTORALQUILERCALLE = 1.0f;
    static private float FACTORALQUILERCASA = 1.0f;
    static private float FACTORALQUILERHOTEL = 4.0f;
    
    
    
    //una clase con los atributos previos y le añadimos un constructor que reciba  todo eso
   
    Parcela (String _nombre, float _precioCompra, float _precioEdificar, float _precioBaseAlquiler ) {
        
        
        this.nombre = _nombre;
        this.precioCompra = _precioCompra;
        this.precioEdificar = _precioEdificar;
        this.precioBaseAlquiler = _precioBaseAlquiler;
        this.numCasas = 0;
        this.numHoteles = 0;
       
        
    }
    
     String getNombre () { return nombre;   //CONSULTORES
     }
     
      float getPrecioCompra () {
         return precioCompra;
     }
     
      float getPrecioEdificar () {
         return precioEdificar;
         
     }
     
      int getNumCasas () {
         return numCasas;
        
     }
      int getNumHoteles () {
          return numHoteles;
          
      }
     
     
   public  float getPrecioAlquilerCompleto () {    //calcula y devuelve el precio completo de alquilar dicha parcela teniendo en cuenta tanto
       //el solar como sus edificaciones.
       
       
       return (precioBaseAlquiler*FACTORALQUILERCALLE*(1+numCasas*FACTORALQUILERCASA + (numHoteles*FACTORALQUILERHOTEL*4)));
       
}
   
   boolean construirCasa (){
       
      numCasas++;
      
       return true;
        
   }
   
   boolean construirHotel (){
       numHoteles++;
       return true;
   }
   
   boolean igualdadIdentidad(Parcela otraParcela){
      boolean resultado = (this == otraParcela)?true:false; //devuelve a nivel de identidad(comparandolo con this) si el parametro es igual al receptor del mensaje
      //esta parcela
      return resultado;
   }
   public boolean igualdadEstado (Parcela otraParcela){
       boolean resultado = (this.equals(otraParcela))?true:false; //devuelve truie si el objeto receptor del mensaje es igual a cuanto estado, lo mismo pero con equals
       return resultado;
   }
   

}