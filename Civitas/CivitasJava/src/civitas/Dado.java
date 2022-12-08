/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package civitas;
import java.util.Random;
import java.util.ArrayList;
/**
 *
 * @author Luis
 */

public class Dado  {
    //atributo de instancia
    private Random random = new Random();
    private int ultimoResultado;
    private boolean debug;
    //atributo de clase instance de la clase dado
    private static Dado instance = new Dado();
    
    //constructor privado qie inicializa todos los atributos de instancia
    private Dado(){
        debug = false;
        ultimoResultado = 0;
        random = new Random();
    }
    
    //Implementación de clase Singleton
   public static Dado getInstance() { return instance;}
    
   // genera y devuelve un numero aleatroio entero entre 1 y 6, el numero a devolver se almacena en el atributo ultimo resultado
  public  int tirar(){
        int resultado;
        if(debug== false)
            resultado = random.nextInt(6)+1;
        else 
            resultado = 1;
        ultimoResultado = resultado;
        return resultado;
        }
    //metodo para decidir quien empieza el juego. Devolver numeor entre 0 y n-1
   public int quienEmpieza(int n){
        return random.nextInt(n);
    }
    //modificador del atributo debug y deja constancia en el diario del modo en elque se ha puesto el ddado ( utilizando ocurreEvento
    //de diario
  public  void setDebug(boolean d){
        debug = d;
        if(debug==true)
            Diario.getInstance().ocurreEvento("Dado debug true");
        else
            Diario.getInstance().ocurreEvento("Dado debug false");
                    
    }
  public boolean getDebug(){
      return debug;
  }
 public   int getUltimoResultado(){
        return ultimoResultado;
    }
    
}
