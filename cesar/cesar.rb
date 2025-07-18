require 'minitest/autorun'

class TestCesar < Minitest::Test

  def cesar(message, shift)
    ranges = [('A'..'Z').to_a, ('a'..'z').to_a]

    cyphered = ""

    message.each_char do |char|
      range = ranges.find { |r| r.include?(char) }

      if range
        cyphered << range[(range.index(char) + shift)%range.size]
      else
        cyphered << char
      end
    end

    cyphered
  end

  def test_example_1
    message = "¡Hola, Mundo!"
    expected_result = "¡Krod, Pxqgr!"
    assert_equal expected_result, cesar(message, 3)
  end

  def test_example_2
    message = "zapato"
    expected_result = "abqbup"
    assert_equal expected_result, cesar(message, 1)
  end
end
