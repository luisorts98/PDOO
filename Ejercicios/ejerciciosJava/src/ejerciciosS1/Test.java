/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosS1;

import ejerciciosS1.Parcela;
import ejerciciosS1.Parcela;

/**
 *
 * @author Luis
 */
public class Test {
    
    public static void imprimirParcela(Parcela a){
        System.out.println("\nNombre de la parcela: " + a.getNombre());
        System.out.println("\nPrecio de la parcela: " + a.getPrecioCompra());
        System.out.println("\nAlquiler de la parcela: " + a.getPrecioAlquilerCompleto());
        System.out.println("\nEdificar parcela: " + a.getPrecioEdificar());
        System.out.println("\nCasas de la parcela: " + a.getNumCasas());
        System.out.println("\nHoteles de la parcela: " + a.getNumHoteles());
        
    }
   
    public static void main(String[] args) {
        //Instancias de parcelas
        Parcela parcela1 = new Parcela("Parcela 1",10000,5000,1000);
        Parcela parcela2 = new Parcela("Parcela 2",12000,3000,1400);
        
        //Datos de almacenado de inicio
        System.out.println("\nInicio");
        imprimirParcela(parcela1);
        imprimirParcela(parcela2);
        //construccion de casda
        parcela1.construirCasa();
        parcela2.construirHotel();
        
    //Datos almacenados depsues
        System.out.println("\nConstruido");
        imprimirParcela(parcela1);
        imprimirParcela(parcela2);
      
        Parcela parcela3;
        Parcela parcela4 = new Parcela("Parcela 1", 10000,5000,1000);
        parcela3 = parcela1;
        
        System.out.println("IDENTIDADES");
        System.out.println(parcela1.igualdadIdentidad(parcela3));
        System.out.println(parcela1.igualdadIdentidad(parcela4));
        System.out.println("ESTADOS");
        System.out.println(parcela1.igualdadEstado(parcela3));
        //parcela 1 tiene una casa y parcela 4 no
        System.out.println(parcela1.igualdadEstado(parcela4));
        
        Parcela parcela5 = new Parcela("Parcela 1",10000,5000,10000);
        System.out.println(parcela4.igualdadEstado(parcela5));
    }
}
