# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
require_relative 'modelo_laberinto/laberinto'
require_relative 'controlador_laberinto/controlador.rb'
require_relative 'vista_laberinto'
#require_relative 'vista2_laberinto'
module EjerciciosRuby
class Test_lab
  def self.main
modelo=Laberinto.new()
controlador=Controlador.new(modelo)
#vista2=Vista2_laberinto.new(controlador,modelo)
vista=Vista_laberinto.new(controlador)
#vista2.menu_usuario
vista.menu_usuario 
  end
  
end
EjerciciosRuby::Test_lab.main
end