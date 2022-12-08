# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
# encoding:utf-8
module EjerciciosRuby
class Parcela
  
    attr_reader :nombre, :precioCompra, :precioEdificar, :precioAlquilerCompleto, :numCasas, :numHoteles  #atributos de instancia en java
    
    
    def initialize( nombre, precioCompra, precioEdificar, precioBaseAlquiler)   #una clase con los atributos previos y le añadimos un constructor que reciba  todo eso
        
       @nombre = nombre
       @precioCompra = precioCompra
       @precioEdificar = precioEdificar
       @precioBaseAlquiler = precioBaseAlquiler
       @@FACTORALQUILERCALLE = 1.0
       @@FACTORALQUILERCASA = 1.0;
       @@FACTORALQUILERHOTEL = 4.0;
       @num_casa = @num_hoteles = 0 
    end
    
    
    def precioAlquilerCompleto
      @precioBaseAlquiler*(@@FACTORALQUILERCALLE;+@numCasas +@numHoteles*@@FACTORALQUILERHOTEL;)
     
      
     
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
     salida= "Nombre de la parcela: #{@nombre}
     Precio de la parcela: #{@precioCompra}
     Alquiler de la parcela: #{self.precioAlquilerCompleto()}
     Edificar en la parcela: #{@precioEdificar}
     Casas de la parcela: #{@numCasas}
     Hoteles de la parcela: #{@numHoteles}"
   end
  end
end


