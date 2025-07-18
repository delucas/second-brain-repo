# http://www.oia.unsam.edu.ar/_media/prob/c3a05n2p2.pdf

class Player
  def play notes
    hands = [Hand.new]
    notes.each do |note|
      num = KeyboardConverter.from_name(note)
      unless hands.last.reach(num)
        hands << Hand.new(hands.last)
        hands.last.reach(num)
      end
    end
    hands.map(&:adapt)
    hands
  end
end

class Hand
  MAX_REACH = 5
  attr_reader :thumb_on

  def initialize(previous = nil)
    @previous = previous
  end

  def adapt
    return unless @previous
    if @previous.thumb_on < @thumb_on
      # comes from the left
      @thumb_on = @farthest_note - 4
    end
  end

  def to_s
    KeyboardConverter.from_note(@thumb_on)
  end

  def reach(note)
    # Si es la primera nota, inicializamos el pulgar y el rango de notas alcanzables
    if !@thumb_on
      @thumb_on = @farthest_note = note
      return true
    end
  
    # Actualizamos el rango alcanzable usando min y max
    new_thumb_on = [@thumb_on, note].min
    new_farthest_note = [@farthest_note, note].max
  
    # Si el nuevo rango está dentro del alcance permitido, actualizamos la posición
    if new_farthest_note - new_thumb_on < MAX_REACH
      @thumb_on = new_thumb_on
      @farthest_note = new_farthest_note
      return true
    end
  
    # No se puede alcanzar la nueva nota
    false
  end
end

class KeyboardConverter

  def self.from_note(note)
    tones = %w(c d e f g a b)
    tone = tones[note % 7 - 1]
    octave = (note - 1) / 7
    "#{tone.upcase}#{octave}"
  end

  def self.from_name(name)
    tone = name[0]
    octave = name[1].to_i

    tones = {
      :"a" => 6,
      :"b" => 7,
      :"c" => 1,
      :"d" => 2,
      :"e" => 3,
      :"f" => 4,
      :"g" => 5
    }
    octave * 7 + tones[tone.downcase.to_sym]
  end

end