# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
# encoding:utf-8
require_relative "../modelo_laberinto/tipo_separacion"
require_relative 'Estado_juego'
require_relative '../modelo_laberinto/direccion'


class Controlador
  attr_reader :estado, :vidas, :habitacion, :habitacion_usuario, :laberinto #consultores basicos
  
  def initialize(modelo) #inicializamos todos los atributos
    @habitacion_usuario=nil #nil porque esta fuera
    @laberinto=modelo
    @estado=Estado_juego::EN_ENTRADA_LABERINTO
    @vidas=0
    
    
  end
  
 def entrar(vidas) #cambiamos el valor de los atributos porque acaba de entrar el usuario
    @estado=Estado_juego::DENTRO_VIVO #estado donde acaba de entrar
    @habitacion_usuario=@laberinto.puerta_entrada.habitacion_al_otro_lado(nil) #pedimos a la puerta de entrada ante @laberinto
    #del laberinto(modelo) la habitacion_al_otro_lado, donde esta el usuario y como esta fuera es nil
    pared=Elemento_separador.nueva_pared(@habitacion_usuario, nil) #para no dar marcha atrás
    #creamos una pared de elemento_Separador
    @habitacion_usuario.set_lado(Direccion::SUR, pared) #usamos el metodo set_lado para decir a la habitacion
    #donde ha entrado el usuario que cambie la puerta de entrada(que esta al sur) por dicha pared
    @vidas=vidas #para actualizar vidas
  end
  
  def intentar_avanzar()
    direccion=rand(0..3) #mover aleatoreamente norte sur este y oeste
    if(@habitacion_usuario.pasar(direccion)) #si se puede pasar a otra habitación hacer
      @habitacion_usuario= @habitacion_usuario.get_lado(direccion).habitacion_al_otro_lado(@habitacion_usuario)#pasa a otra habitacion
      if(@habitacion_usuario == nil) #si la habitacion es nil es que ha salido del laberinto
        @estado=Estado_juego::EN_SALIDA_LABERINTO #le damos el valor de la constante salir del laberinto
      
      else
        pared=Elemento_separador.nueva_pared(@habitacion_usuario, nil) #si no es el final, creamos una parted en la puerta de atras
        @habitacion_usuario.set_lado((direccion+1)%4,pared)
      end
    else
      @vidas=@vidas-1 #si el intento es fallido quitar una vida
      if(@vidas==0) #si llega a 0 ha muerto 
        @estado=Estado_juego::DENTRO_MUERTO
      end
    end
    direccion #3n cualquier caso devolvemos la direccion
  end
 
 # def intentar_avanzar()
  #  direccion=rand(0..3) mover aleatoreamente norte sur este y oeste
 #   if(@habitacion_usuario.pasar(direccion,@total_vidas)) si se puede pasar a otra habitación hacer
 #     @habitacion_usuario= @habitacion_usuario.get_lado(direccion).habitacion_al_otro_lado(@habitacion_usuario)#pasa a otra habitacion
 #     if(@habitacion_usuario == nil) si la habitacion es nil es que ha salido del laberinto
 #       @estado=Estado_juego::EN_SALIDA_LABERINTO #le damos el valor de la constante salir del laberinto
      
 #     else
 #       pared=Elemento_separador.nueva_pared(@habitacion_usuario, nil) #si no es el final, creamos una parted en la puerta de atras
 #       @habitacion_usuario.set_lado((direccion+1)%4,pared)
 #     end
 #   else
 #     @vidas=@vidas-1 si el intento es fallido quitar una vida
  #    if(@vidas==0) si llega a 0 ha muerto 
  #      @estado=Estado_juego::DENTRO_MUERTO
  #    end
 #   end
 #   direccion 3n cualquier caso devolvemos la direccion
 # end
 #def entrar(vidas) cambiamos el valor de los atributos porque acaba de entrar el usuario
  #  @estado=Estado_juego::DENTRO_VIVO estado donde acaba de entrar
  #  @habitacion_usuario=@laberinto.puerta_entrada.habitacion_al_otro_lado(nil) #pedimos a la puerta de entrada ante @laberinto
    #del laberinto(modelo) la habitacion_al_otro_lado, donde esta el usuario y como esta fuera es nil
   # pared=Elemento_separador.nueva_pared(@habitacion_usuario, nil) #para no dar marcha atrás
    #creamos una pared de elemento_Separador
   # @habitacion_usuario.set_lado(Direccion::SUR, pared) #usamos el metodo set_lado para decir a la habitacion
    #donde ha entrado el usuario que cambie la puerta de entrada(que esta al sur) por dicha pared
   # @vidas=vidas para actualizar vidas
   # @total_vidas = vidas
  #end
  
end
