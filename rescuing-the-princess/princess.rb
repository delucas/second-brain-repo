require 'minitest/autorun'

class RescuePrincessTest < Minitest::Test

  def minimum_initial_health(dungeon)
    recu(dungeon, 0, 0, {})
  end

  def recu(dungeon, i, j, mem)
    return Float::INFINITY if i >= dungeon.size || j >= dungeon[0].size
    key = [i, j]

    mem[key] ||= begin
      if i == dungeon.size-1 && j == dungeon[0].size-1
        1 - dungeon[i][j]
      else
        h_down = recu(dungeon, i + 1, j, mem)
        h_right = recu(dungeon, i, j + 1, mem)

        h = [h_down, h_right].min - dungeon[i][j]
        h > 0 ? h : 1
      end
    end
  end

  def test_minimum_initial_health
    dungeon = [
      [-2, -3,  3],
      [-5, -10, 1],
      [10, 30, -5]
    ]
    
    assert_equal 7, minimum_initial_health(dungeon)
  end
end
