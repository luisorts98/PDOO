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
public class CasillaCalle extends Casilla {
    private Casilla casilla;
    private float precioCompra;
    private float precioEdificar;  ///TODO ESYO SON ATRIBUTOS DE INSTANCIA
    private float precioBaseAlquiler;
    private int numCasas;
    private int numHoteles;
    static private float FACTORALQUILERCALLE = 1.0f;
    static private float FACTORALQUILERCASA = 1.0f;
    static private float FACTORALQUILERHOTEL = 4.0f;
    private Jugador propietario;
  
    private void init(){
        precioCompra = 0;
        precioEdificar = 0;
        precioBaseAlquiler = 0;
        numCasas = 0;
        numHoteles = 0;
        propietario = null;
    }
   public CasillaCalle(String nombre, float unPrecioCompra, float unPrecioEdificar, float unPrecioBaseAlquiler){
        super(nombre);
        this.init();
        this.precioCompra = unPrecioCompra;
        this.precioEdificar = unPrecioEdificar;
        this.precioBaseAlquiler = unPrecioBaseAlquiler;
        
    }
    
     void actualizaPropietarioPorConversion(Jugador jugador){
      propietario = jugador;
      Diario.getInstance().ocurreEvento("La propiedad " + getNombre() + " pasa de " + propietario.getNombre() + " " + propietario.getClass() +
              "a " + propietario.getNombre() + " " + propietario.getClass());
  }
      
   boolean construirCasa (Jugador jugador){
       if(esEsteElPropietario(jugador) && numCasas<4){
           jugador.paga(precioEdificar); 
           numCasas++;
       }
      
      
       return true;
        
   }
   int cantidadCasasHoteles(){
      return numCasas+numHoteles;
      
  }
   
  public int getNumHoteles(){
       return numHoteles;
   }
  public int getNumCasas(){
      return numCasas;
  }
   boolean comprar(Jugador jugador ) {
 
    boolean puedeComprar = jugador.puedeComprarCasilla();
        if(puedeComprar){
            jugador.paga(precioCompra);
            propietario = jugador;
        }
        
        return puedeComprar;
    }
  
    public void setPropietario(Jugador propietario) {
        this.propietario = propietario;
    }

    public void setNumCasas(int numCasas) {
        this.numCasas = numCasas;
    }

    public void setNumHoteles(int numHoteles) {
        this.numHoteles = numHoteles;
    }
 
     boolean derruirCasas(int n, Jugador jugador){ //si el jugador pasado como parámetro es el propietario de la casilla
      if(jugador.getNombre()==propietario.getNombre() && numCasas>=n){ //y el numero de casas es mayor o migual que el parametro n, se decrementa
          numCasas -= n; //se decrementa el contador de cassa construidads en n unidades en caso contrario no realzia la operacion
          return true;
      }
      return false;
      
  }
     public void actualizaPropiedadesPorConversion(JugadorEspeculador jugador){ //LO HACEMOS POR EL JUGADOR ESPECULADOR
         this.propietario = jugador;
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
  public boolean tienePropietario(){
      boolean resultado = false;
      if( propietario!=null){
          resultado = true;
  }
      return resultado;
   }
   public  float getPrecioAlquilerCompleto () {    //calcula y devuelve el precio completo de alquilar dicha parcela teniendo en cuenta tanto
       //el solar como sus edificaciones.
       
       
       return (precioBaseAlquiler*FACTORALQUILERCALLE*(1+numCasas*FACTORALQUILERCASA + (numHoteles*FACTORALQUILERHOTEL*4)));
   }
     public float getPrecioCompra () {
         return precioCompra;
     }
      public  float getPrecioEdificar () {
         return precioEdificar;
         
     }
     
   boolean construirHotel (Jugador jugador){
        
        if (esEsteElPropietario(jugador) && numCasas>=4){
        jugador.paga(precioEdificar); //ESTO ERA DE CONSTRUIR CASA DE JUGADOR PERO CREO QUE VA AQUI MEJOR
        numHoteles++; 
   }       return true;
   }
     void recibeJugador_calle(int iactual, ArrayList<Jugador> todos){
     
        
            this.informe(iactual, todos);
            Jugador jugadorActual = todos.get(iactual);

            if (!tienePropietario()) {
                if(jugadorActual.puedeComprarCasilla())
                    System.out.println("La casilla no está comprada: jugador puede comprar casilla");
            }
            else
                this.tramitarAlquiler(jugadorActual);//JUGADORACTUAL = jugador si falla
        
    }
      public void tramitarAlquiler(Jugador jugador){ //jugador pasado como parametro
      
       if(tienePropietario() && !esEsteElPropietario(jugador)){ //si la casilla tiene propietario y el jugador pasado como parametro no es propietario de la casilla
           Diario.getInstance().ocurreEvento(jugador.getNombre()+"paga un alquiler de " + getPrecioAlquilerCompleto() + "€ a " + propietario.getNombre() + "por la propiedad " + getNombre());
           jugador.pagaAlquiler(getPrecioAlquilerCompleto()); //ese jugador paga el alquier completo
           propietario.recibe(getPrecioAlquilerCompleto());
           
       }
      
       
   }
     
     void recibeJugador(int actual, ArrayList<Jugador> todos){
         super.recibeJugador(actual, todos);
         recibeJugador_calle(actual, todos);
     }
         
     
     public String toString(){
          String cadena = "";
        cadena += super.toString();
        
        if(this instanceof CasillaCalle){
        
            if(tienePropietario()){
                cadena += ". Propietario " + propietario.getNombre() +". Precios: Compra: " + precioCompra + 
                ", Edificar: " + precioEdificar + ", Alquiler base: " + 
                precioBaseAlquiler + ", Casas: " + numCasas + ", Hoteles: " + 
                numHoteles;
            }else{
                cadena += ". Precios: Compra: " + precioCompra + 
                ", Edificar: " + precioEdificar + ", Alquiler base: " + 
                precioBaseAlquiler + ", Casas: " + numCasas + ", Hoteles: " + 
                numHoteles;
            }
        }
        
        return cadena;

    }

     
    public Casilla getCasilla() {
         return casilla;
     }
     /*  @Override
    public String toString() {
        return "CasillaCalleSostenible{" + super.toString() + "porcentajeInversion=" + porcentajeInversion + '}';
    }
    
*/
      /*TituloPropiedad mejor_propiedad(){
        TituloPropiedad mejor_titulo = null;
        ArrayList<TituloPropiedad> mejores_propiedades = new ArrayList();
        int maximo = 0;
        int indices[];
        // Actualizo el valor 'maximo' al mayor numero de hoteles
        for (TituloPropiedad tp: propiedades){
            if (tp.getNumHoteles() > maximo)
                maximo = tp.getNumHoteles();
        }
        
        // Cojo las propiedades que tienen como número de hoteles el valor 'maximo'
        for (TituloPropiedad tp: propiedades){
            if (tp.getNumHoteles() == maximo)
                mejores_propiedades.add(tp);
        }
        
        // Si hay más de una propiedad con el mismo número de hoteles
        // busco la que tiene mayor número de casas     
        if (mejores_propiedades.size() > 1){
            maximo = 0;
            ArrayList<TituloPropiedad> mejores_propiedades_2 = new ArrayList();
            for (TituloPropiedad tp: mejores_propiedades){
                if (tp.getNumCasas() > maximo)
                    maximo = tp.getNumCasas();
            }

            // Cojo las propiedades que tienen como número de casas el valor 'maximo'
            for (TituloPropiedad tp: mejores_propiedades){
                if (tp.getNumHoteles() == maximo)
                    mejores_propiedades_2.add(tp);
            }
            
            // Si hay más de una propiedad con el mismo número de casas
            // busco la que tenga el precio de compra más elevado
            
            if (mejores_propiedades_2.size() > 1){
                maximo = 0;
                // actualizo el maximo precio de compra y el titulo
                for (TituloPropiedad tp: mejores_propiedades_2){
                    if (tp.getPrecioCompra() > maximo)
                        maximo = tp.getPrecioCompra();
                        mejor_titulo = tp;
                }
                
            }
            else
                mejor_titulo = mejores_propiedades_2.get(0);
        }
        else
            mejor_titulo = mejores_propiedades.get(0);
        
        return mejor_titulo;
    }
    */
     /* private float calcularPorcentajeInversionPorSostenibilidad(){
            float porcentajeInversion=5;
            if(cantidadCasasHoteles()>0){
                porcentajeInversion=2;
                
            }
            return porcentajeInversion;
        }
   public float getImporteHacermeSostenible(){
       return getPrecioCompra()*calcularPorcentajeInversionPorSostenibilidad()/100;
       
   }
   
   public CasillaCalleSostenible hacermeSostenible(Jugador jugador){
       CasillaCalleSostenible convertido = new CasillaCalleSostenible(getNombre(),precioCompra,precioEdificar,precioBaseAlquiler,calcularPorcentajeInversionPorSostenibilidad());
       convertido.setPropietario(propietario);
       convertido.setNumCasas(numCasas);
       convertido.setNumHoteles(numHoteles);
       return convertido;
          
   }
  
   public boolean soySostenible(){
       return false;
   }
      /* boolean comprar(Jugador jugador ) {
 
    boolean puedeComprar = jugador.puedeComprarCasilla();
        if(puedeComprar){
            jugador.paga(precioComprac * (1+factorcomunicacion));
            propietario = jugador;
        }
        
        return puedeComprar;
    }*/
     /* private double calcularDecrementoRevaorizacionAlAsocializar(){
       double revalorizacion = 0;
       if (getNumCasas() >= 3){
           revalorizacion= 2*0.02;
       } else{
           revalorizacion = 1*0.02;
    }
       return revalorizacion;
    
}*/
   
}
