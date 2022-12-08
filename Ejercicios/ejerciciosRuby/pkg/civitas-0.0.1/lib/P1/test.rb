# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
require_relative 'parcela'
module EjerciciosRuby
  
    puts "----Inicio-----\n"
    parcela = Parcela.new("Parcela 1",10000,5000,1000)
    puts parcela.to_s
    parcela.construirCasa
    parcela.construirHotel
    puts "\n----- Con CASA Y HOTEL\n"
     puts parcela.to_s
   puts parcela.precioAlquilerCompleto
  puts Parcela.get_MAX()
    Parcela.set_MAX_CASAS(3)
    puts Parcela.get_MAX()
end
