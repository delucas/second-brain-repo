# implementa un Trie en ruby

class TrieNode
  attr_accessor :children, :is_end_of_word

  def initialize
    @children = {}
    @is_end_of_word = false
  end
end

class Trie
  def initialize
    @root = TrieNode.new
  end

  def insert(word)
    node = @root
    word.each_char do |char|
      node.children[char] ||= TrieNode.new
      node = node.children[char]
    end
    node.is_end_of_word = true
  end

  def search(word)
    node = @root
    word.each_char do |char|
      return false unless node.children[char]
      node = node.children[char]
    end
    node.is_end_of_word
  end

  def starts_with(prefix)
    node = @root
    prefix.each_char do |char|
      return false unless node.children[char]
      node = node.children[char]
    end
    true
  end

  def remove(word)
    if search(word)
      node = @root
      word.each_char do |char|
        return false unless node.children[char]
        node = node.children[char]
      end
      node.is_end_of_word = false
      return true
    end
    false
  end

  def print_trie(node = @root, word = "")
    if node.is_end_of_word
      puts word
    end
    node.children.each do |char, child|
      print_trie(child, word + char)
    end
  end
end
