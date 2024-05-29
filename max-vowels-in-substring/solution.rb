def max_vowel_substring_of_length(s, k)
  vowels = "aeiou"
  max_vowels = 0
  vowels_count = 0
  s.chars.each_with_index do |c, i|
    # si estoy agregando una vocal
    if vowels.include?(c)
      vowels_count += 1
    end
    # si ya tengo k caracteres
    if i >= k
      # si el caracter que estoy sacando es una vocal
      if vowels.include?(s[i - k])
        vowels_count -= 1
      end
    end
    max_vowels = [max_vowels, vowels_count].max
  end
  max_vowels
end

pp max_vowel_substring_of_length("bacacbefaobeacfe", 5) # 4
