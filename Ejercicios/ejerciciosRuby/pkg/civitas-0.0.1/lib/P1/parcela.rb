# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
# encoding:utf-8
# frozen_string_literal: true
module EjerciciosRuby
class Parcela
  
    attr_reader :nombre, :precioCompra, :precioEdificar, :precioAlquilerCompleto, :numCasas, :numHoteles  #atributos de instancia en java
    
     @FACTORALQUILERCALLE = 1.0
     @FACTORALQUILERCASA = 1.0
     @FACTORALQUILERHOTEL = 4.0 
    def initialize( nombre, precioCompra, precioEdificar, precioBaseAlquiler)   #una clase con los atributos previos y le añadimos un constructor que reciba  todo eso
        
       @nombre = nombre
       @precioCompra = precioCompra
       @precioEdificar = precioEdificar
       @precioBaseAlquiler = precioBaseAlquiler
       @numCasas = @numHoteles = 0 
       #@@FACTORALQUILERCALLE = 1.0
       #@@FACTORALQUILERCASA = 1.0
       #@@FACTORALQUILERHOTEL = 4.0
       @@Max_Casas = 2
      
    end
    
    def self.set_MAX_CASAS(n)
      @@Max_Casas = n
      return true
    end
   
    def self.get_MAX()
    return @@Max_Casas
end
    
    def precioAlquilerCompleto
   @precioBaseAlquiler*(Parcela.factorialCalle+Parcela.factorialCasa * @numCasas+@numHoteles*Parcela.factorialHotel)
      
    end
    def self.factorialCalle
      @FACTORIALALQUILERCALLE
    end
     def self.factorialCasa
      @FACTORIALALQUILERCASA
    end
    def self.factorialHotel
      @FACTORIALALQUILERHOTEL
    end
    
    def construirHotel ()
      @numHoteles =+ 1
      
      return true
    end
    
    def construirCasa ()
      @numCasas =+ 1
      
      return true
    end
    
   def to_s

     salida = "Nombre de la parcela: #{@nombre}
     Precio de la parcela: #{@precioCompra}
     Alquiler de la parcela: #{}
     Edificar en la parcela: #{@precioEdificar}
     Casas de la parcela: #{@numCasas}
     Hoteles de la parcela: #{@numHoteles}
     MAX_CASAS: #{} "
   end
  end
end


