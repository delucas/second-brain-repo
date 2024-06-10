class Cube
  attr_reader :q, :r, :s

  def initialize(q,r,s)
    @q, @r, @s = q, r, s
  end

  def +(other)
    Cube.new(@q + other.q, @r + other.r, @s + other.s)
  end

  def -(other)
    Cube.new(@q - other.q, @r - other.r, @s - other.s)
  end

  def ==(other)
    @q == other.q && @r == other.r && @s == other.s
  end

  def to_s
    "(#{@q}, #{@r}, #{@s})"
  end

  def hash
    [@q, @r, @s].hash
  end
end

MOVES = [
  Cube.new(+1, -1, +0), # NE
  Cube.new(+1, +0, -1), # SE
  Cube.new(+0, +1, -1), # S
]

def _ways_to_walk(n, start, finish, mem)
  if start == finish
    mem[start.hash] = 1
  end

  if (start.q).abs > n || (start.r).abs > n || (start.s).abs > n
    mem[start.hash] = 0
  end

  if mem[start.hash]
    return mem[start.hash]
  end

  mem[start.hash] = MOVES.map do |move|
    _ways_to_walk(n, start + move, finish, mem)
  end.sum
end

def ways_to_walk(n)
  # n representa la distancia hacia el centro, por ello restamos uno
  n = n - 1
  mem = {}
  _ways_to_walk(n, Cube.new(-n,0,n), Cube.new(n,0,-n), mem)
end


require 'minitest/autorun'

class TestSolution < Minitest::Test
  def test_cases
    assert_equal 1, ways_to_walk(1)
    assert_equal 11, ways_to_walk(2)
    assert_equal 291, ways_to_walk(3)
    assert_equal 259123, ways_to_walk(5)
  end
end
