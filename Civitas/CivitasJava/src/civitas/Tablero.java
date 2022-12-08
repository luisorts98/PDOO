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
public class Tablero {
    
    private ArrayList<Casilla> casillas; //atributo de instancia
    private boolean porSalida; //si ha pasado por la
    
    
    Tablero(){
        
        casillas = new ArrayList<Casilla>(); //inicializa casillas a un arrayList vacio 
        casillas.add(new Casilla("Salida")); //Añade una nueva casilla de nombre "Salida" 
        
        porSalida = false;
        
    }
    
    private Boolean correcto(int numCasilla){   //METODO DE INSTANCIA QUE DEVUELVE TRUE SI SU PARAMETRO ES UN INDICE VALIDO PARA 
                                                // ACCEDER A ELEMENTOS DE CASILLA
    
     return (casillas.size()>numCasilla)   ? true : false; //num casu¡illa >=0 && numCasilla <=talero.size()
                                                
         
               
    }
    public int getTamañoTablero(){ //TAMAÑO TRABLERO
        return casillas.size();
    }
    
    boolean computarPasoPorSalida(){ // devuelve el atributo por salida y lo deja en false
        porSalida = false;
        return porSalida;
    }
    
    void añadeCasilla(Casilla casilla){ //añade casilla pasada como parámetro
        casillas.add(casilla);
    }
    
    int nuevaPosición(int actual, int tirada){ 
     
        int posicion;
        posicion = (actual + tirada) % casillas.size();
        if(posicion !=  actual + tirada){
            porSalida = true;
        
        
        }
     return posicion;
    }
    
   public Casilla getCasilla(int numCasilla){ //Devuelve la casilla de la posición numCasilla si este índice es válido. Devuelve null en otro caso
        if(correcto(numCasilla)) //utilizar internamiente el método boolean correcto (int numCasilla)
            return casillas.get(numCasilla);
        else{
            return null;
        }
    }
    public ArrayList<Casilla> getCasillas() {
        return casillas;
    }
     /* private int getPosicionSiguienteEstacion(int posCalle){
        int d = -1;
        boolean encontrada = false;
        if(getCasilla(posCalle).getTipo() == TipoCasilla.CALLE)
            for(int i = posCalle; i < TAMANIOTABLERO && !encontrada; i++)
                if(casillas.get(i).getTipo() == TipoCasilla.ESTACION){
                    d=i;
                    encontrada = true;
                }
        return d;
    }*/
    /*private void añadirEstacionADiario(int posCalle, int posEstacion){
        if (posEstacion > -1){
             int d = posEstacion - posCalle;
            Diario.getInstance().ocurreEvento("La calle " + getCasilla(posCalle).getNombre()
                            + "(" + posCalle + ")"
                            + " se encuentra a " + d + " casillas de la estacion "
                            + getCasilla(posEstacion).getNombre()
                            + "(" + posEstacion + ")");   
        }
        else{
            Diario.getInstance().ocurreEvento("La calle " + getCasilla(posCalle).getNombre()
                + "(" + posCalle + ")" + " no tiene cerca ninguna estación");
        }
    }*/
       
   /* void calcularFactoresComunicacion(){
        for(int i = 0; i < TAMANIOTABLERO; i++)
            calcularFactorComunicacion(i, getPosicionSiguienteEstacion(i));
    }
    
    private void calcularFactorComunicacion(int posCalle, int posEstacion){
        float factor = 0;
        int d = posEstacion - posCalle;
        Casilla calle = getCasilla(posCalle);
        if(calle.getTipo() == TipoCasilla.CALLE){   
            if(posEstacion != -1){
                Casilla casillaEstacion = getCasilla(posEstacion);
                Estacion estacion = casillaEstacion.getEstacion();
                switch(estacion.getTipo()){
                    case CERCANIAS:
                        factor = 1/(d*10f);
                        break;
                    case LARGADISTANCIA:
                        factor = 2/(d*10f);
                        break;
                    case MULTIPLE:
                        factor = 3/(d*10f);
                }
                calle.setFactorComunicacion(factor);
            }
        añadirEstacionADiario(posCalle, posEstacion);
        }
    }    
    */
}
