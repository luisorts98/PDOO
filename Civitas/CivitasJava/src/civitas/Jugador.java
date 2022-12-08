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
import java.util.ArrayList;
public class Jugador implements Comparable<Jugador> {

    protected static int CasasMax         = 4;
    protected static int CasasPorHotel    = 4;
    protected static int HotelesMax       = 4;
    private int casillaActual;
    protected static float PasoPorSalida  = 1000;
    private static float SaldoInicial     = 7500;
    private boolean puedeComprar;
    private String nombre;
    private float saldo;
    private ArrayList<CasillaCalle> propiedades = new ArrayList<>(); //Era casilla no casillCalle pero P5
    
    Jugador(String nombre) {
        this.nombre = nombre;
        casillaActual = 0;
        puedeComprar = false;
     
        saldo = SaldoInicial;
       propiedades = new ArrayList<CasillaCalle>(); 

    }

    //Constructor 2, de copia
    protected Jugador(Jugador otro) {
        this.nombre = otro.nombre;
    
        this.casillaActual = otro.casillaActual;
        this.puedeComprar = otro.puedeComprar;
        this.saldo = otro.saldo;
        this.propiedades = otro.propiedades;
       
    }
    private boolean existeLaPropiedad(int ip) { //co mprueba que el indice ip es un indice valido dentro de las prpedades del jugador
        boolean existe = false;
          if(ip < propiedades.size()){
                existe = true;
            }
        
        return existe;
    }
     //ESTE MÉTODO NO ES PARTE DEL GUIÓN. IMPLEMENTACIÓN PARA SOLUCIONAR VistasTextual::gestionar()
    //PARA EVITAR TENER QUE DEVOLVER TODO 'propiedades', devolvemos solo lo imprescindible
    //Devuelve el número de propiedades
    public ArrayList<String> getNombrePropiedades() {
        ArrayList<String> nombres = new ArrayList<String>();

        for (Casilla propiedad : propiedades) {
            nombres.add(propiedad.getNombre());
        }

        return nombres;
    }
    boolean puedeComprarCasilla(){ //fija el atributo puedeComprar a true y devuelve el valor de este atributo
        puedeComprar = true;
        return puedeComprar;
    }
    boolean paga(float cantidad){ ///llama al metodo modificaSaldo con el valor del parñametro multiplicado por -1 y devuelve el valro pro el metodo modificaSaldo
        
        return modificaSaldo(cantidad *-1);
        
    }
    
    boolean pagaAlquiler(float cantidad){ //llama al metdodo paga con al cantidad indicada y devuelve lo devuelto por este metodo
        return paga(cantidad);
        
    }
    boolean recibe (float cantidad){ //se llama al metodo modificaSaldo con la cantidad inidicada y se devuelve lo que devuelve este ultimo metodo 
        return modificaSaldo(cantidad);
        
    }
    boolean modificaSaldo(float cantidad){
        boolean verdadero = true;
        saldo = saldo + cantidad;
        Diario.getInstance().ocurreEvento("El jugador" + nombre + " tiene de saldo " + saldo); //INFORMAR AL DIARIO
        return verdadero;
    }
    boolean moverACasilla(int c){
        casillaActual = c; //fijar casillaActual a c //numCasilla
        puedeComprar = false;
        
        Diario.getInstance().ocurreEvento("El jugador" + nombre + " ha sido trasladado a la casilla " + c); //se iforma al diario del movimiento del jugador
        return true;
    }
    
    boolean puedoGastar(float precio){
        if(saldo>=precio)
            return true;
        else
            return false;
    }
    boolean tieneAlgoQueGestionar(){
        boolean tiene = false;
        if(!propiedades.isEmpty()){
            tiene = true;
            
        }
        return tiene;
    }
    boolean pasaPorSalida(){
    recibe(PasoPorSalida);
    Diario.getInstance().ocurreEvento("El jugador " + nombre + "pasa por salida y se lleva " + PasoPorSalida + "€");
    return true;
    
    } 
  public int compareTo(Jugador otro){
        int resultado = Float.compare(saldo, otro.saldo);
        
        return resultado;
        
         
    }
  boolean construirHotel(int ip){
     boolean result=false;
      if (existeLaPropiedad(ip)){
          CasillaCalle propiedad = propiedades.get(ip);
          boolean puedoEdificarHotel = puedoEdificarHotel(propiedad);
         puedoEdificarHotel = false;
          float precio = propiedad.getPrecioEdificar();
          if (puedoGastar(precio)){   //puedoEdificarHotel
              if (propiedad.getNumHoteles()<getHotelesMax()){
                  if(propiedad.getNumCasas()>=getCasasPorHotel()){
                      puedoEdificarHotel = true;
                  }
              }
              
          }
          if(puedoEdificarHotel){
               result = propiedad.construirHotel(this); 
              
           
              propiedad.derruirCasas(CasasPorHotel, this);
           
              Diario.getInstance().ocurreEvento("El jugador" + getNombre() + " construye hotel en la propiedad " + ip);
              
           
             
              
          }
          
      }
      return result;
  }
  boolean comprar(CasillaCalle titulo){
      boolean result = false;
      if (puedeComprar){
        float precio = titulo.getPrecioCompra();
          if(puedoGastar(precio)){
              result = titulo.comprar(this);
          
             // propietario = jugador; //ya lo hace en casilla en actualiza
              //jugador.paga(titulo.precioCompra()); LO PONGO EN COMPRAR DE CASILLA  
              propiedades.add(titulo);
             this.puedeComprar = false;
               Diario.getInstance().ocurreEvento("El jugador" + nombre + " compra la propiedad " + titulo.getNombre());
          }
              else {
                      Diario.getInstance().ocurreEvento("El jugador" + nombre + " no tiene saldo para comprar la propiedad " + titulo.getNombre());
                      }
          
          
      }
      return result;
  }
  boolean construirCasa(int ip){
      boolean result = false;
  
       boolean existe = existeLaPropiedad(ip);
      if(existe){
          CasillaCalle propiedad = propiedades.get(ip);
          
          if (puedoEdificarCasa(propiedad)) {
              result = propiedad.construirCasa(this);
                  Diario.getInstance().ocurreEvento("El jugador"+ nombre + "construye casa en la propiedad" + ip);
                 
              
              
          }
      }
      
      return result;
  }
  
  int cantidadCasasHoteles(){
      int total = 0;
      for(int i = 0; i <propiedades.size(); i++){
         // total = propiedades.get(i).cantidadCasasHoteles();
         total = propiedades.get(i).getNumCasas() + propiedades.get(i).getNumHoteles();
         
      }
      return total;
  }
  

  boolean puedoEdificarHotel(CasillaCalle propiedad){
    
    boolean puedo = false;
    float precio = propiedad.getPrecioEdificar();
    
    if(puedoGastar(precio)){ //Devolvera true solo si tiene dinero para edificarhotel, no supera el numero de hoteles edificables
        if(propiedad.getNumHoteles()< HotelesMax){
            if(propiedad.getNumCasas()>= CasasPorHotel){ //Y TIENE SUFICIENTES CASAS PARA PONER HOTELES
                puedo = true;
            }
        }
    }
      return puedo;
  }
  boolean puedoEdificarCasa(CasillaCalle propiedad){
           
    boolean puedo = false;
    float precioEdificar = propiedad.getPrecioEdificar();
    
    if(puedoGastar(precioEdificar)){
        if(propiedad.getNumCasas()< CasasMax){
            puedo =true;
    } 
       else if (propiedad.getNumCasas() >= getCasasMax()) {
            Diario.getInstance().ocurreEvento(this.nombre + 
                    " ha intentado edificar una casa en " + propiedad.getNombre() +
                    " pero ha excedido el limite de casas");
             puedo = false;
               }
    
    }    
  
return puedo;
  }
  
  boolean enBancarrota(){
      boolean enBancarrota = false;
      if(saldo < 0 ){
          enBancarrota = true;
      }
     
          return enBancarrota;
      
          
  }  
  private static int getCasasMax(){
      return CasasMax;
  }
  static int getCasasPorHotel(){
      return CasasPorHotel;
  }
 public int getCasillaActual(){
      return casillaActual;
      
  }
  private static int getHotelesMax(){
      return HotelesMax;
  }
  public  String getNombre(){ //antes era protected pero lo poenmos por la p5
      return nombre;
     
  }
  private static float getPremioPasoSalida(){
      return PasoPorSalida;
      
  }
  
  public ArrayList<CasillaCalle> getPropiedades(){ 
      return propiedades;
  }
  boolean getPuedeComprar(){
      return puedeComprar;
  }
 public float getSaldo(){ //antes era protected pero por la p5 la ponemos a public
      return saldo;
  }
  
  public void cedePropiedadesA(Jugador otroJugador){
      for (CasillaCalle propiedad : propiedades) {
          propiedad.actualizaPropietarioPorConversion(otroJugador);
      }
  }
  //DEVUELVE SI EL JUGADOR ES ESPECULADOR
  public boolean esEspeculador(){
      boolean resultado = false;
      
      if(this instanceof JugadorEspeculador){
          resultado = true;
      }
      return resultado;
      
  }private boolean puedoConvertirCalle(CasillaCalle calle){
      return puedoConvertirCalle(calle);
  }
  
  
  //DEVUELVE JUGADOR CONVERTIDO A ESPECULADOR
  public JugadorEspeculador aEspeculador(){
      return new JugadorEspeculador(this);
  }
  
  public String toString(){
        
    
        return "Jugador :"                   + nombre
                + "\n\tCasilla = "           + casillaActual
                + "\n\tPuede comprar =  "    + puedeComprar
               
                + "\n\tSaldo = "             + saldo
               
                + "\n\tPropiedades = "       + getPropiedades().toString();

    
  }
  /*public boolean puedoConvertirCalle(CasillaCalle casilla){ //NO COINCIDE CON DIGRAMA
        return puedoGastar(casilla.getImporteHacermeSostenible());
    }*/
 /* CasillaCalleSostenible hacerCalleSostenible(int ip){
      CasillaCalleSostenible calleS = null;
      if(existeLaPropiedad(ip)){
          CasillaCalle propiedad =propiedades.get(ip);
          if(puedoConvertirCalle(propiedad)){
              calleS = propiedad.hacermeSostenible();
          }
          if(calleS != null){
              Diario.getInstance().ocurreEvento("taltal");
              propiedades.set(ip, calleS);
          }
      }
      return calleS;
  }*/
  /*public boolean hacerCalleSostenible(int ip){
       CasillaCalle  calleS = null;
      if(existeLaPropiedad(ip)){
       
          
          CasillaCalle propiedad = propiedades.get(ip);
          if(puedoConvertirCalle(propiedad)){
              calleS = propiedad.hacermeSostenible();
          if(calleS != null){
              Diario.getInstance().ocurreEvento("vflf");
              propiedades.set(ip, calleS);
          }
          }
      }*/
  
}
