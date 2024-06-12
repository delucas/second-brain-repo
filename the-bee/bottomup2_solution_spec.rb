def print_grid(grid)
  grid.each do |row|
    puts row.map { |cell| cell.to_s.rjust(5) }.join
  end
end

def the_bee(n)
  m = 2 * n - 1
  dp = Array.new(m) { Array.new(m, 0) }

  n.times do |i|
    dp[i][0] = 1
    dp[0][i] = 1
  end

  (1...m).each do |i|
    (1...m).each do |j|
      if (i - j).abs < n
        dp[i][j] = dp[i-1][j] + dp[i][j-1] + dp[i-1][j-1]
      end
    end
  end

  dp[m-1][m-1]
end


require 'minitest/autorun'

class TestSolution < Minitest::Test
  def test_cases
    assert_equal 1, the_bee(1)
    assert_equal 11, the_bee(2)
    assert_equal 291, the_bee(3)
    assert_equal 8547, the_bee(4)
    assert_equal 259123, the_bee(5)
  end
end
