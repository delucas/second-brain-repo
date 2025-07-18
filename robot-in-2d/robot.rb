require 'minitest/autorun'

class RobotMovementTest < Minitest::Test
  def returns_to_origin2?(movements)
    movements.count { |move| move == "U" } == movements.count { |move| move == "D" } &&
      movements.count { |move| move == "L" } == movements.count { |move| move == "R" }
  end

  def returns_to_origin?(movements)
    pos = [0, 0]
    movs = {
      "U": [ 0, 1],
      "D": [ 0,-1],
      "R": [ 1, 0],
      "L": [-1, 0],
    }
    movements.each do |mov|
      pos[0] += movs[mov.to_sym][0]
      pos[1] += movs[mov.to_sym][1]
    end

    pos == [0, 0]
  end

  def test_returns_to_origin_case_1
    movements = ["U", "D", "L", "R"]
    assert_equal true, returns_to_origin?(movements)
  end

  def test_does_not_return_to_origin_case_2
    movements = ["U", "U", "D", "L"]
    assert_equal false, returns_to_origin?(movements)
  end

  def test_does_not_return_to_origin_case_3
    movements = ["R", "R", "R", "R"]
    assert_equal false, returns_to_origin?(movements)
  end

  def test_returns_to_origin_case_4
    movements = ["L", "R", "L", "R"]
    assert_equal true, returns_to_origin?(movements)
  end
end
