 require_relative 'trie'

def find_word(grid, words)
  directions = [
    [1, 0],
    [0, 1],
    [-1, 0],
    [0, -1],
    [1, 1],
    [-1, 1],
    [-1, -1],
    [1, -1]
  ]

  n = grid.size
  m = grid[0].size
  moves = []

  trie = Trie.new
  words.each do |w|
    trie.insert(w)
  end

  n.times do |i|
    m.times do |j|
      if trie.starts_with(grid[i][j])
        directions.each do |dx, dy|
          check_word(grid, i, j, dx, dy, trie, moves)
        end
      end
    end
  end

  return moves
end

def check_word(grid, i, j, dx, dy, trie, moves)
  n, m = grid.size, grid[0].size
  word = ""
  start_i = i
  start_j = j
  while i >= 0 && i < n && j >= 0 && j < m && trie.starts_with(word)
    word += grid[i][j]
    if trie.search(word)
      moves << [word, [start_i, start_j], [i, j]]
      trie.remove(word)
    end
    i += dx
    j += dy
  end
end

grid = [
  ['a', 'b', 'c', 'o'],
  ['e', 'z', 'g', 'l'],
  ['i', 'j', 'a', 'e'],
  ['e', 's', 'o', 'p'],
]

words = ["pose", "pelo", "paz", "sal"]

pp find_word(grid, words)
# [
#   ["sal",  [3, 1], [1, 3]],
#   ["pelo", [3, 3], [0, 3]],
#   ["pose", [3, 3], [3, 0]],
#   ["paz",  [3, 3], [1, 1]]
# ]