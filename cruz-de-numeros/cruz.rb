def cruz(n)
  espacio = (" " * (n-1))
  (1...n).each { |i| puts "#{espacio}#{i}" }
  puts (1..n).to_a.concat((1...n).to_a.reverse).join
  (n - 1).downto(1) { |i| puts "#{espacio}#{i}" }
end

cruz(8)