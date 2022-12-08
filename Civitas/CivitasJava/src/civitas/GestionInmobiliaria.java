/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;
import civitas.OperacionInmobiliaria;
/**
 *
 * @author Luis
 */


//PARA ALMACENAR LA INFORMACIÓN DE UNA OPERACÓN INMOBILIARAI
public class GestionInmobiliaria {
    OperacionInmobiliaria operacion;
    int propiedad; //numPropiedad en la del año pasado
    




public GestionInmobiliaria(OperacionInmobiliaria gest, int ip){
    operacion = gest;
   propiedad = ip;//_numPropiedad
            
}

public OperacionInmobiliaria getOperacion(){
    return operacion;
}
       

public int getPropiedad(){ //lo de numPropiedad
    return propiedad;
}
}