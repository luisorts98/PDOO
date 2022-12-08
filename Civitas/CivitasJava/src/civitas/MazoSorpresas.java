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
public class MazoSorpresas {
    private Boolean barajada;
    private Boolean debug; //cuando este activo el mazo no se baraja
    private int usadas; //atributo instancia para contar el numero de cartas usadas
    private ArrayList<Sorpresa> sorpresas;
 
    
    //metodo privado que inicializa los atributos sorpresas a un contenedor vacío (ArrayList<>)
    //Este método es el primero que se invoque desde los constructores 
    private void init() {
        sorpresas = new ArrayList<>();
        barajada = false;
        usadas = 0;
      
    }
    
    //constructor con parametro, el constructor recibe como parametro el valor para el atributo debug e iniiaiza este atributo, llama
    //al metodo init y si el modo debug está activado, se informa de este hecho a través del diario 
    public MazoSorpresas(Boolean debug){
        this.debug = debug; //inicializar atributo
        init(); //llamar al metodo init
        if (debug == true){
            Diario.getInstance().ocurreEvento("MazoSorpresa debug true ");
        }
      
    }
    //Constructor sin parametros, solamente llama al metodo init y fija el valor de debug a false;
    public MazoSorpresas(){
        init();
        debug = false;
        
    }
    //si el mazo no ha sido barajado se añade la sorpresa que recibe como argumento al mazo
    void alMazo(Sorpresa s){
        if(barajada == false){
            sorpresas.add(s);
        }
    }
    //di rl mazo no ha sido barajado o si el nuemro de cartas usafas es igual al tamaño del mazo
    Sorpresa siguiente(){
        if(barajada == false || usadas == sorpresas.size() ){
            if (debug == false){
                Collections.shuffle(sorpresas); // SHUFFLE sirve para barajar un array 
                usadas = 0;
                barajada = true;
                
            }
        }
        usadas++;
      Sorpresa  ultimaSorpresa = sorpresas.get(0); //quitar la primera carta sorpresa de la colección de sorpresas 
        sorpresas.remove(0);// la orden de arriba
        sorpresas.add(ultimaSorpresa); // añade al final de la misma y se guarda en una variable local de tipo sorpresa
        return ultimaSorpresa; //devuelve una referencia a esa carta sorpresa
    }
}
