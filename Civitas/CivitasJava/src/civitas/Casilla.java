   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package civitas;
import java.util.ArrayList;
/**
 *
 * @author Luis
 */
public class Casilla {
    private String nombre; //contiene el nombre de la casilla
   // private TipoCasilla tipo; //indicará si esta instancia de la clase es una casilla calle, sorpresa o descanso
  //  private float precioCompra;
   /* private float precioEdificar;  ///TODO ESYO SON ATRIBUTOS DE INSTANCIA
    private float precioBaseAlquiler;
    private int numCasas;
    private int numHoteles;
    static private float FACTORALQUILERCALLE = 1.0f;
    static private float FACTORALQUILERCASA = 1.0f;
    static private float FACTORALQUILERHOTEL = 4.0f;
    private Jugador propietario;*/
    MazoSorpresas mazo;
    
    Tablero tablero;
     private void init() {
       nombre="";
       // precioCompra = 0;
        //precioEdificar
    }
    //una clase con los atributos previos y le añadimos un constructor que reciba  todo eso y ese constructor sirve
    // para creae casillas
   //constructor casilla calle
     //constructor casilla descanso
    Casilla ( String nombre/*, float unPrecioCompra, float unPrecioEdificar, float unPrecioAlquilerBase*/ ) {
        
        this.init();
        this.nombre = nombre;
       // this.precioCompra = unPrecioCompra;
       // this.precioEdificar = unPrecioEdificar;
       // this.precioBaseAlquiler = unPrecioAlquilerBase;
        //this.numCasas = 0;
       // this.numHoteles = 0;
      
       
        
    }
  /* Casilla(TipoCasilla tipo, String nombre, TipoEstacion tipoEstacion){
       this.nombre = nombre;
       this.tipo = tipo;
       this.estacion = newEstacion(nombre,tipoEstacion);
   }*/
    
    
    
    //CONSTRUCTOR SORPRESA CREO QUE ES ASI PERO QUIZAS ES SACANDO A UNA CLASE
   /* Casilla( String unNombre, MazoSorpresas mazo){
        this.init();
        nombre = unNombre;
        this.mazo = mazo;
    }
*/
  
    
    
    
    
  
 /*  boolean comprar(Jugador jugador ) {
  
       if(propietario==null && jugador.getSaldo()>=precioCompra){
           jugador.paga(precioCompra);
           propietario = jugador;
           return true;
   }
       return false;
   }*/
     public String getNombre () { return nombre;   //CONSULTORES //LO PONEMOS PUBLIC POR LA P5
     }
     
   /*   float getPrecioCompra () {
         return precioCompra;
     }
     
      float getPrecioEdificar () {
         return precioEdificar;
         
     }
     
     public int getNumCasas () { //LO POENMOS PUBLIC POR LA P5 ERAN ANTES DE VISIBILIDAD PAQUETE
         return numCasas;
        
     }
     public int getNumHoteles () { //AQUI IGUAL POR LA P5
          return numHoteles;
          
      }
     
     
   public  float getPrecioAlquilerCompleto () {    //calcula y devuelve el precio completo de alquilar dicha parcela teniendo en cuenta tanto
       //el solar como sus edificaciones.
       
       
       return (precioBaseAlquiler*FACTORALQUILERCALLE*(1+numCasas*FACTORALQUILERCASA + (numHoteles*FACTORALQUILERHOTEL*4)));
       
}*/
   void informe(int actual, ArrayList<Jugador> todos){ //informa a diario acerca del jugador caido en la casilla actual. Para dar info usamos el metodo toString
      // if(jugadorCorrecto(iactual, todos)){
           Diario.getInstance().ocurreEvento("Jugador" + todos.get(actual).getNombre() + " ha caido en casilla " + nombre);
    //   
            System.out.println("Informacion de la casilla: " + toString());
   }
 
 // void recibeJugador_descanso(int iactual, ArrayList<Jugador> todos){
  //     informe(iactual, todos);
 // }
  
  void recibeJugador(int actual, ArrayList<Jugador> todos){
   
     
           informe(actual, todos);
     
  
  }
  /*
  void actualizaPropietarioPorConversion(Jugador jugador){
      propietario = jugador;
  }
 
   
   public boolean tienePropietario(){
       return propietario!=null;
   }
   public void tramitarAlquiler(Jugador jugador){ //jugador pasado como parametro
      
       if(tienePropietario() && !esEsteElPropietario(jugador)){ //si la casilla tiene propietario y el jugador pasado como parametro no es propietario de la casilla
           jugador.pagaAlquiler(getPrecioAlquilerCompleto()); //ese jugador paga el alquier completo
           propietario.recibe(getPrecioAlquilerCompleto());
           
       }
      
       
   }
   boolean construirCasa (Jugador jugador){
       if(esEsteElPropietario(jugador) && numCasas<4){
           propietario.paga(precioEdificar);
           numCasas++;
       }
      
      
       return true;
        
   }
   
   boolean construirHotel (Jugador jugador){
        
        if (esEsteElPropietario(jugador) && numCasas>=4){
        jugador.paga(precioEdificar); //ESTO ERA DE CONSTRUIR CASA DE JUGADOR PERO CREO QUE VA AQUI MEJOR
        numHoteles++; 
   }       return true;
   }
  boolean derruirCasas(int n, Jugador jugador){ //si el jugador pasado como parámetro es el propietario de la casilla
      if(jugador.getNombre()==propietario.getNombre() && numCasas>=n){ //y el numero de casas es mayor o migual que el parametro n, se decrementa
          numCasas -= n; //se decrementa el contador de cassa construidads en n unidades en caso contrario no realzia la operacion
          return true;
      }
      return false;
      
  }

  public boolean esEsteElPropietario(Jugador jugador){
      if(propietario==null)
          return false;
      else
          return jugador.getNombre()==propietario.getNombre();
      
  }
  Jugador getPropietario(){
      return propietario;
  }
  
  int cantidadCasasHoteles(){
      return numCasas+numHoteles;
      
  }
   /*
   boolean igualdadIdentidad(Casilla otraParcela){
      boolean resultado = (this == otraParcela)?true:false;
      return resultado;
   }
   public boolean igualdadEstado (Casilla otraParcela){
       boolean resultado = (this.equals(otraParcela))?true:false;
       return resultado;
   }*/ //DE LA SESION 1*/
   @Override
   public String toString() {
       
       /*
       System.out.println(unTipo.toString());
       System.out.println(nombre.toString());
       //FALTAN COSAS Y NOSE SI ESTA BIEN
       */
       return "Casilla " + nombre + ":"; //Esto creo que si, se tiene que dar info y si es una calle con propietario solo mostrar el nombre del
       //propietario
   }

}

/* public String toString(){
        String cadena = tipo + " " + nombre + ". ";
        switch(tipo){
            case CALLE:
                if(tienePropietario())
                    cadena += "Propiedad de " + propietario.getNombre() + ". ";
                else
                    cadena += "Sin propietario. ";
                cadena += "Precios: " + "Compra: " + precioCompra + ", " + "Edificar: " + 
                precioEdificar + ", " + "Alquiler base: " + precioBaseAlquiler + 
                ", " + "Casas: " + numCasas + ", " + "Hoteles: " + numHoteles;
                break;
            case ESTACION:
                cadena = estacion.toString();
                break;
        }
        
        return cadena;
    }
}
*/
