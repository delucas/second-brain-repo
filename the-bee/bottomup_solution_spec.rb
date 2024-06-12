def print_grid(grid)
  grid.each do |row|
    puts row.map { |cell| cell.to_s.rjust(5) }.join
  end
end

def llenar(r, q, dim)
  r + q > dim && r + q < (3*dim+1)
end

def ways_to_walk(n)
  # https://www.redblobgames.com/grids/hexagons/#map-storage
  n = n - 1
  dim = n * 2 + 1
  grid = Array.new(dim) { Array.new(dim, 0) }
  
  (0..n).each do |q|
    grid[n-q][q] = 1
  end
  (n..(dim-1)).each do |r|
    grid[r][0] = 1
  end

  (1..(dim-1)).each do |q|
    (0..(dim-1)).each do |r|
      if llenar(r, q, n)
        i = r
        j = q

        if i > 0
          grid[i][j] += grid[i-1][j]
        end
        if j > 0
          grid[i][j] += grid[i][j-1]
        end
        if i < dim - 1 && j > 0
          grid[i][j] += grid[i+1][j-1]
        end
      end
    end
  end
 
  grid[n][dim-1]
end

require 'minitest/autorun'

class TestSolution < Minitest::Test
  def test_cases
    assert_equal 1, ways_to_walk(1)
    assert_equal 11, ways_to_walk(2)
    assert_equal 291, ways_to_walk(3)
    assert_equal 8547, ways_to_walk(4)
    assert_equal 259123, ways_to_walk(5)
  end
end
