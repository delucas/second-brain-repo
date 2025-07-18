def expand3(digitos)
  return [] if digitos.empty?

  resultado = []
  contador = 1

  (1...digitos.length).each do |i|
    if digitos[i] == digitos[i - 1]
      contador += 1
    else
      resultado << contador << digitos[i - 1]
      contador = 1
    end
  end
  resultado << contador << digitos.last
  resultado
end

def expand2(digitos)
  prev = nil
  cont = 0
  res = []
  digitos.each do |d|
    if d == prev
      cont+=1
    else
      res << [cont, prev] if prev != nil
      prev = d
      cont = 1
    end
  end
  res << cont << prev
  res
end

def expand(digitos)
  digitos.chunk_while { |i, j| i == j }
         .flat_map { |chunk| [chunk.size, chunk.first] }
end

pp expand(expand(expand(expand([1]))))