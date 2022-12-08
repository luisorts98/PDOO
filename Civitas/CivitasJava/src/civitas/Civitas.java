/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Luis
 */
public class Civitas {
static final int tamaniotablero = 20;
private int indiceJugadorActual;
ArrayList<Jugador> jugadores;
GestorEstados gestorEstados;
EstadosJuego estado;
MazoSorpresas mazo;
Tablero tablero;
private Dado dado = Dado.getInstance();
//constructor:

public Civitas(ArrayList<String> nombres, boolean debug){ //constructor
    jugadores = new ArrayList<Jugador>(); //inicializar el atributo jugadores creando 
    for(int i = 0; i<nombres.size(); i++){ 
        jugadores.add(new Jugador(nombres.get(i))); //y añadiendo un jugador por cada nombre suministrado como parametros
        
    }
    gestorEstados = new GestorEstados(); //crear el gestor estados 
    estado = gestorEstados.estadoInicial(); // y fijar el estado actual como el estado inicial (metodo estadoInicial) indicado por ese gestor
    indiceJugadorActual = Dado.getInstance().quienEmpieza(jugadores.size());  //inicializar el indice del jugador actual (quien tenga el primer turno) y usamos el metodo adecuado de dado
    mazo = new MazoSorpresas(false); //crear mazo sorpresa //PONEMOS FALSE PARA NO INICIARLO EN MODO DEBUG
    inicializarMazoSorpresas();
    tablero = new Tablero();
   inicializaTablero(mazo);
   Dado.getInstance().setDebug(debug); //poner el dado en modo debug o no segun el argumento correspondiente al constructor
   //REVISARR
    
}
    private void inicializaTablero(MazoSorpresas mazo) {
   
        //tablero.añadeCasilla(new Casilla("Salida"));
    
         CasillaCalle casilla1 = new CasillaCalle( "Calle Dr Doolitle", 1200f, 3500f, 1700f); //REVISARRRRR
         tablero.añadeCasilla(casilla1);
        CasillaCalle casilla2 = new CasillaCalle( "Calle del amor", 1000f, 3200f, 1600f);
        tablero.añadeCasilla(casilla2);
        CasillaCalle casilla3 = new CasillaCalle( "Calle Emperatriz Ugenia", 900f, 3000f, 1500f);
        tablero.añadeCasilla(casilla3);
           CasillaSorpresa s2 = new CasillaSorpresa( mazo,"Sorpresa2");
        tablero.añadeCasilla(s2);
       

        //El tablero por defecto, crea la casilla de Salida                 //Casilla 1
       // tablero.añadeCasilla(new Casilla(800.0f, "Impuesto por pensar"));
         CasillaCalle casilla4 = new CasillaCalle("Paseo de Gracia", 120f, 135f, 150f);
        tablero.añadeCasilla(casilla4);
        
     
       
         CasillaSorpresa s4 = new CasillaSorpresa( mazo,"Sorpresa4");
        tablero.añadeCasilla(s4);
        
        CasillaCalle casilla5 = new CasillaCalle("Calle Clamores", 145, 180f, 200f);
        tablero.añadeCasilla(casilla5);
        
        CasillaCalle casilla6 = new CasillaCalle("Campo del principe", 230, 255f, 290f);
        tablero.añadeCasilla(casilla6);
          CasillaSorpresa s3 = new CasillaSorpresa( mazo,"Sorpresa3");
        tablero.añadeCasilla(s3);
                    //Casilla 2
        CasillaCalle casilla7 = new CasillaCalle("Avenida Calvo sotelo", 220f, 245f, 265f);
        tablero.añadeCasilla(casilla7);
        
         tablero.añadeCasilla(new Casilla("Parking"));
         CasillaCalle casilla8 = new CasillaCalle("Calle Trajano", 250f, 260f, 300f);
        tablero.añadeCasilla(casilla8);
          tablero.añadeCasilla(new CasillaSorpresa(mazo, "sorpresa1")); 
        CasillaCalle casilla9 = new CasillaCalle("Plaza Colon", 180f, 195f, 220f);
        tablero.añadeCasilla(casilla9);
         CasillaCalle casilla10 = new CasillaCalle("Paseo de la isla", 160f, 175f, 200f);
        tablero.añadeCasilla(casilla10);
        
        CasillaCalle casilla11 = new CasillaCalle("Paseo de almeria", 155f, 210f, 265f);
        tablero.añadeCasilla(casilla11);
        
        CasillaCalle casilla12 = new CasillaCalle("Avenida España", 135f, 170f, 185f);
        tablero.añadeCasilla(casilla12); 
        
        CasillaCalle casilla13 = new CasillaCalle("Rambla", 135f, 170f, 185f);
        tablero.añadeCasilla(casilla13);
        
        CasillaCalle casilla14 = new CasillaCalle("Paseo del violin", 195f, 75f, 185f);
        tablero.añadeCasilla(casilla14);
        
            //tablero.añadeCasilla(new Casilla(700.0f, "Impuesto por jugar"));    //Casilla 3
          //Casilla 4
        //tablero.añadeCasilla(new Casilla(720.0f, "Impuesto por teclear"));  //Casilla 5
       // tablero.añadeCasilla(new CasillaCalle(casilla1));                         //Casilla 7
       // tablero.añadeCasilla(new CasillaImpuesto(830.0f, "Impuesto por avanzar"));
      //  tablero.añadeCasilla(new CasillaCalle(casilla2));                         //Casilla 8
      //  tablero.añadeCasilla(new CasillaImpuesto(730.0f, "Impuesto por leer"));    //Casilla 10
      //  tablero.añadeCasilla(new CasillaSorpresa(mazo, "sorpresa 3"));              //Casilla 13
      //  tablero.añadeCasilla(new CasillaCalle(casilla3));                         //Casilla 14
      //  tablero.añadeCasilla(new CasillaImpuesto(830.0f, "Impuesto por pagar"));
       
    }
     //Crea e inicializa mazo de sorpresas
    //MODIFICACIÓN DE GUIÓN
    //  -Eliminar Tablero como parámetro, ya que es un atributo de instancia
    private void inicializarMazoSorpresas() {
        mazo.alMazo(new SorpresaPagarCobrar( tablero, 750 , "has ganado la loteria GANAS 750"));//TipoSorpresa.PAGARCOBRAR,
        mazo.alMazo(new SorpresaPagarCobrar( tablero, 500 , "INVIERTES EN DUCKCOINS Y GANAS 500"));
        mazo.alMazo(new SorpresaPagarCobrar( tablero, -200 , "pierdes dinero en inversion"));
        mazo.alMazo(new SorpresaPagarCobrar( tablero, -750, "Te han robado pierdes 750"));//TipoSorpresa.PAGARCOBRAR,
        mazo.alMazo(new SorpresaPorCasaHotel(tablero,-150 ,"Reformass"));
        mazo.alMazo(new SorpresaPorCasaHotel(tablero,-200 ,"sube la luz"));
        mazo.alMazo(new SorpresaPorCasaHotel(tablero,200 ,"Encuentras un yacimiento en la casa"));
        mazo.alMazo(new SorpresaPorCasaHotel(tablero,300 ,"tu casa se revaloriza"));
       // mazo.alMazo(new SorpresaIrACasilla( tablero, 1, "Vuelve al principio(Casilla siguiente a salida)"));//TipoSorpresa.IRACASILLA,
        mazo.alMazo(new SorpresaPagarCobrar( tablero, -850, "PAGA 850"));//TipoSorpresa.PAGARCOBRAR,
      //  mazo.alMazo(new SorpresaSalirCarcel( mazo,"Salir Cárcel"));//TipoSorpresa.SALIRCARCEL,
       // mazo.alMazo(new SorpresaIrACasilla( tablero, 5, "Ve a la casilla 5(A pagar por teclear)"));//TipoSorpresa.IRACASILLA,
        mazo.alMazo(new SorpresaConvertirme(this));
    }
    public Jugador getJugadorActual(){
        return jugadores.get(indiceJugadorActual); //devuelve el jugador actual referenciado por indiceJugadorActual
         
     }
    
    private void pasarTurno() { // actualiza el indice del jugador acutal como consecuencia del cambio de turno se debe poner atencion
        if (indiceJugadorActual == jugadores.size() - 1) { //al caso en el que el jugador actual sea el ultimo de la lista
            indiceJugadorActual = 0;
            
        }else{
            indiceJugadorActual++;
        }
    }
    
    public void siguientePasoCompletado(OperacionJuego operacion) {
        estado = gestorEstados.siguienteEstado(jugadores.get(indiceJugadorActual), estado, operacion); //obtenerJugadorActual  
    }
    
    public OperacionJuego siguientePaso(){
         Jugador jugadorActual = getJugadorActual(); 
        OperacionJuego operacion = gestorEstados.siguienteOperacion(jugadorActual, estado);

        if (operacion == OperacionJuego.PASAR_TURNO) {
            pasarTurno();
            siguientePasoCompletado(operacion);
        } else if (operacion == OperacionJuego.AVANZAR) {
            avanzaJugador();
            siguientePasoCompletado(operacion);
        }

        return operacion;
    
    }
    public Casilla getCasillaActual(){ //NO SE SI SE PONE 
        return tablero.getCasilla(jugadores.get(indiceJugadorActual).getCasillaActual());
    }
    private void avanzaJugador(){
        
        int tirada = Dado.getInstance().tirar();
        Jugador jugadorActual = this.getJugadorActual();
        int posicionActual = jugadorActual.getCasillaActual();
        int posicionNueva = tablero.nuevaPosición(posicionActual, tirada);
        Casilla casilla = tablero.getCasilla(posicionNueva);
        this.ContabilizarPasosPorSalida(jugadorActual); //ANTES ESTABA () mirar lo de jugadorActual
        jugadorActual.moverACasilla(posicionNueva);
        casilla.recibeJugador(indiceJugadorActual, jugadores);
         
        
    }
  
 
    public boolean construirCasa(int ip){
        return  getJugadorActual().construirCasa(ip);//jugadores.get(indiceJugadorActual).construirCasa(ip); //este metodo delega totalmente en el metodo con el mismo nombre
    } //del jugador actual
    public boolean construirHotel(int ip){
        return getJugadorActual().construirHotel(ip);   //jugadores.get(indiceJugadorActual).construirHotel(ip); //lo mismo que el de arriba
    }
   
    public boolean finalDelJuego(){ //este metodo devuelve true si alguno de los jugadores esta en bancarrota
        boolean bancarrota = false;
        
        //recorrer el array  de jugadores
        for(Jugador jugador : jugadores) {
            if(!bancarrota){ //si el resultado ya es true, no necesitamos evaluar más
                bancarrota = jugador.enBancarrota();
            }
        }
        return bancarrota;    
    }
    
    public ArrayList<Jugador> ranking(){
        ArrayList<Jugador> ordenado = new ArrayList<>(jugadores);
        Collections.sort(ordenado); //esto sirve para ordenar una lista en este caso el del ranking
        Collections.reverse(ordenado);//crea una lista en orden inverso no se porque lo ponemos
        return ordenado;
    }
    
    private void ContabilizarPasosPorSalida(Jugador jugadorActual){ 
        while(tablero.computarPasoPorSalida() == true ){
         jugadorActual.pasaPorSalida();  // jugadores.get(indiceJugadorActual).pasaPorSalida();
        }
    }
     public Tablero getTablero(){
     return tablero;
 }
    
    public boolean comprar(){
        boolean res;
         Jugador jugadorActual = getJugadorActual();
        int numCasillaActual =jugadorActual.getCasillaActual();
        Casilla casilla = tablero.getCasilla(numCasillaActual);
       // Casilla titulo = casilla.getPropiedad();
      
       
        System.out.println("Nombre: " + casilla.getNombre());//NO SE SI PONER ESTOS PRINTLN
        System.out.println("Indice: " + numCasillaActual);
        res = jugadorActual.comprar((CasillaCalle) casilla);
        return res;
    }
    //Convierte a jugador indice en JugadorEspeculador
    
    void convertir(int indice){
        jugadores.add(indice, jugadores.get(indice).aEspeculador());
        jugadores.remove(indice +1);
    }
    //CONVIERTE A JUGADOR EN JUGADORESPECULADOR
    
    void convertir(Jugador jug){
        for (int i=0; i<jugadores.size()-1; i++) {
            if(jug == jugadores.get(i)) {
                jugadores.add(i, jugadores.get(i).aEspeculador());
                jugadores.remove(i + 1);
            }
        }
    }
    public GestorEstados getGestor(){
        return gestorEstados;
    }
    
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
    /*   public boolean hacerCalleSostenible(int ip){
       boolean result = false;
       Jugador jugador = jugadores.get(indiceJugadorActual);
       CasillaCalleSostenible calleS = jugadores.hacerCalleSostenible(ip);
       if(calleS !=null){
          int casillaActual = jugador.getCasillaActual();
          ArrayList<Casilla> casillas = tablero.getCasillas();
          casillas.set(casillaActual,calleS);
          result = true;
       }
       return result;
   }*/
// tablero.añadeCasilla(new CasillaCalleSostenible("Oficios", 1000, 750, 500, 5));