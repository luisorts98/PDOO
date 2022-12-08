# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class Persona
   attr_reader :nombre
  def initialize(nombre)
      @nombre = nombre
    end
    def andar
      result = "Soy #{@nombre} y estoy andando"
    end
    def to_s
      result = "Soy una persona y mi nombre es #{@nombre}"

    
  end
   
  end
  class Deportista < Persona
    def competicion_deportiva(horas)
      @horas_entrenamiento = horas
    end

    def to_s
      result = super
      result += " y soy deportista"
    end

    attr_reader :horas_entrenamiento
  end
  class Corredor < Deportista
    def correr
      result = "estoy corriendo"
    end
    def to_s
      result = super
      result += " y soy corredor"
    end
  end

  class Nadador < Deportista
    def nadar
      result = "estoy nadando"
    end
    def to_s
      result = super
      result += " y soy nadador"
    end
  end


  p = Persona.new("Luis")
  d = Deportista.new("Pablo")
  c = Corredor.new("Juan")
  n = Nadador.new("Pedro")

  puts p.andar
  puts p.to_s + "\n\n"

  puts d.andar
  puts d.to_s
  d.competicion_deportiva(3)
  puts d.horas_entrenamiento
  puts "\n"

  puts c.andar
  puts c.correr
  puts c.to_s + "\n\n"

  puts n.andar
  puts n.nadar
  puts n.to_s + "\n\n"

  n.competicion_deportiva(4)
  puts n.horas_entrenamiento


  # p = Nadador.new("Pablo")
  # puts p.nombre
  #2. no necesito en Ruby constructor para las clases hijas y ambas heredan los metodos de la clase padre(Persona)
  # La clase Padre no puede acceder al andar/to_s de los hijos mientras que los hijos si pueden acceder a los del padre

  