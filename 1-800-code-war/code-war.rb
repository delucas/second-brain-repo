require "set"

WORDS = [
  'CODE', 'LOVE', 'HATE', 'BOOK', 'TALK', 'WALK', 'IDEA', 'FEAR', 'TREE', 'BIRD', 'HOPE', 'RAIN', 'FIRE', 'WIND', 'STAR', 'MOON', 'LIFE', 'TIME', 'SONG', 'WORK', 'PLAY', 'MIND', 'HAND', 'FOOT', 'HEAD', 'EYES', 'EARS', 'NOSE', 'BABY', 'HOME', 'AWAY', 'TEAM', 'WAVE', 'SHIP', 'BOAT', 'BELL', 'COIN', 'GOLD', 'IRON', 'RUST', 'DUST', 'DIRT', 'SAND', 'ROCK', 'CLAY', 'WIND', 'COLD', 'WARM', 'COOL', 'HEAT', 'FIRE', 'WOOD', 'BARK', 'LEAF', 'ROOT', 'LINE', 'RULE', 'LOVE', 'HATE', 'KIND', 'MEAN', 'NICE', 'RUDE', 'BOLD', 'WISE', 'FOOL', 'DARE', 'RISK', 'SAFE', 'FREE', 'OPEN', 'SHUT', 'LOCK', 'HARD', 'SOFT', 'LOUD', 'FAST', 'SLOW', 'HIGH', 'DEEP', 'WIDE', 'TALL', 'LONG', 'NEAR', 'THIN', 'RICH', 'POOR', 'DARK', 'BLUE',
  'WAR', 'YAP', 'ZAP', 'DOG', 'CAT', 'CAR', 'BUS', 'SUN', 'SEA', 'SKY', 'HAT', 'PEN', 'EGG', 'FAN', 'BED', 'CUP', 'BOX', 'KEY', 'ARM', 'LEG', 'LIP', 'ARM', 'FAN', 'BAG', 'COW', 'FOX', 'ICE', 'JAM', 'TOY', 'NUT', 'OAK', 'TOY', 'RAT', 'MAP', 'BUS', 'FOX', 'JUG', 'ANT', 'BOY', 'COW', 'DIP', 'ELF', 'GEM', 'HAY', 'INK', 'JET', 'KIT', 'LID', 'MOB', 'MUD', 'NAP', 'ORB', 'POT'
]

CHARS_BY_NUMBER = {
  2 => "ABC",
  3 => "DEF",
  4 => "GHI",
  5 => "JKL",
  6 => "MNO",
  7 => "PQRS",
  8 => "TUV",
  9 => "WXYZ"
}

# reverse the CHARS_BY_NUMBER map in order to get NUMBER_BY_CHARS map
NUMBER_BY_CHARS = {}
CHARS_BY_NUMBER.each do |key, value|
  value.each_char do |c|
    NUMBER_BY_CHARS[c] = key
  end
end

def string_to_number(s)
  s.chars.map { |c| NUMBER_BY_CHARS[c] }
end

# get the number for each possible word in DICT
DICT_NUMBERS = WORDS.map { |word| string_to_number(word) }

def check1800(s)
  # remove dashes
  s = s.gsub("-", "")
  # remove all but last 7 characters
  s = s[-7..-1]
  # convert s to number
  number = string_to_number(s)

  results = []

  # for each possible starting word, check if it matches the first half of the number
  DICT_NUMBERS.each_with_index do |dict_number, i|
    if dict_number == number[0, dict_number.length]
      # if the first half matches, search for the second half of the number
      DICT_NUMBERS.each_with_index do |dict_number2, j|
        if dict_number2 == number[dict_number.length, dict_number2.length] && WORDS[i].length != WORDS[j].length
          results << "1-800-#{WORDS[i]}-#{WORDS[j]}"
        end
      end
    end
  end

  results.to_set

end

pp check1800("1-800-CODE-WAR")