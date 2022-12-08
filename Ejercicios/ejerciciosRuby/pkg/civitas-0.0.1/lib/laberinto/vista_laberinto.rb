#To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
# encoding:utf-8
require_relative 'controlador_laberinto/controlador'
class Vista_laberinto
  def initialize(controlador)
    @controlador=controlador
    def informe_dentro(habitacion, vidas) #muestra el estado en el que se encuentra el usuario, aqui habitación donde está y las vidas que tiene
       habitacion=@controlador.habitacion_usuario()
      puts "El jugador tiene #{vidas} vidas"
      puts "El usuario se encuentra en la #{habitacion}"
    end
    
    def informe_final(vidas) #aqui informa de las vida que tiene al final, si ha ganado dice las vidas que le queda y si no dice que esta muelto
  
      if(vidas>0)
      puts "El jugador ha ganado con #{vidas} vidas"
      else
        puts "El jugador esta en el otro barrio"
    end
  end
  
   def menu_usuario()
     estado=@controlador.estado #consultamos primero el estado del controlador y segun el estado hacemos
     values=[*1..10].map!(&:to_s) #map devuelve una matriz y map! muta la matriz original
     #mpa toma un objeto enumerable y un bloque y ejecuta el bloque para cada elemento, generando
     #cada valor devuelto desde el bloque y el objeto original cambia si se usa map!
     #&modifica el valor del array de 1 a 10 con las caracteristicas del metodo to_s
     case estado
     when Estado_juego::EN_ENTRADA_LABERINTO #pide al usuario el numero de vidas para empezar el juego, pedirlo hasta
       #que sea correcto gets.chomp guarda el string la entrada del usuario. cuando el numero sea correcto
       #llamar a entrar de controlador
       puts "Con cuantas vidas quieres empezar (entre 1 y 10) para entrar en el laberinto"
       st=gets.chomp
      while (!values.include? st) #devuelve true si el valor de st esta dentro de values 
        #en este caso el while dice que mientras st no este dentro de values sigues poniendo numeros
        puts "Tienes que introducir un numero de vidas entre 1 y 10 antes de entrar"
        st=gets.chomp
      end
      @controlador.entrar(st.to_i)
      puts "El jugador ha entrado en el laberinto"
      
     when Estado_juego::DENTRO_VIVO #infomra al usuario de su situación(informe_dentro)
       puts informe_dentro(@controlador.habitacion_usuario,@controlador.vidas)
       puts "Pulsa una tecla para continuar" #pulsar tecla para continuar
       st= gets.chomp
       movimiento=@controlador.intentar_avanzar()#llamar al metodo intentar_avanzar 
       puts "El jugador se ha movido " + Lista_direcciones[movimiento] #lo usamos para mostrar
       #por pantalla la dirección en la cual se ha movido el usuario LISTA DE DIRECCIONES ES UN ENUMERADO
     
     
   when Estado_juego::EN_SALIDA_LABERINTO #llamamos al metodo informe_final
     puts informe_final(@controlador.vidas())
     exit 0
    
     when Estado_juego::DENTRO_MUERTO
       puts informe_final(@controlador.vidas())
       exit 0
       
     end
     menu_usuario #LLAMAMOS A MENU_USUARIO PARA OTRA ITERACIÓN DEL JUEGO
   end
  
  end
end
