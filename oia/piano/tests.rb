require "minitest/autorun"
require "./hand.rb"

class PlayerTests < Minitest::Test
  def test_first_case
    player = Player.new
    notes = %w(C4 D4 E4 C4 E4 F4 G4 G4 A4 G4 F4 E4 C4 D4 B3 C4#)
    assert_equal %w(C4 D4 B3), player.play(notes).map(&:to_s)
  end

  def test_minimal_path
    player = Player.new
    notes = %w(C0 A0)
    assert_equal %w(C0 D0), player.play(notes).map(&:to_s)
  end

  def test_same_tone_many_times
    player = Player.new
    notes = %w(C0 C0 C0 C0)
    assert_equal %w(C0), player.play(notes).map(&:to_s)
  end
end

class HandTests < Minitest::Test
  def test_one_note
    hand = Hand.new
    assert hand.reach(10)
    assert_equal 10, hand.thumb_on
  end
  def test_adds_reachable_notes
    hand = Hand.new
    assert hand.reach(10)
    assert hand.reach(11)
    assert hand.reach(12)
    assert hand.reach(13)
    assert hand.reach(14)
    assert !hand.reach(15)
    assert_equal 10, hand.thumb_on
  end
  def test_adds_reachable_note_left
    hand = Hand.new
    assert hand.reach(10)
    assert hand.reach(9)
    assert_equal 9, hand.thumb_on
  end

  def test_adds_reachable_notes_towards_left
    hand = Hand.new
    assert hand.reach(10)
    assert hand.reach(9)
    assert hand.reach(8)
    assert hand.reach(7)
    assert hand.reach(6)
    assert !hand.reach(5)
    assert_equal 6, hand.thumb_on
  end

  def test_doesnt_reach_unreachable_towards_right
    hand = Hand.new
    assert hand.reach(10)
    assert !hand.reach(15)
  end

  def test_doesnt_reach_unreachable_towards_left
    hand = Hand.new
    assert hand.reach(10)
    assert !hand.reach(5)
  end
end

class KeyboardConverterTests < Minitest::Test
  def test_converts_tones
    assert_equal 1, KeyboardConverter.from_name("C0")
    assert_equal 2, KeyboardConverter.from_name("D0")
    assert_equal 3, KeyboardConverter.from_name("E0")
    assert_equal 4, KeyboardConverter.from_name("F0")
    assert_equal 5, KeyboardConverter.from_name("G0")
    assert_equal 6, KeyboardConverter.from_name("A0")
    assert_equal 7, KeyboardConverter.from_name("B0")
    assert_equal 8, KeyboardConverter.from_name("C1")
  end

  def test_converts_alterations
    assert_equal 1, KeyboardConverter.from_name("C0#")
    assert_equal 2, KeyboardConverter.from_name("D0#")
    assert_equal 4, KeyboardConverter.from_name("F0#")
    assert_equal 5, KeyboardConverter.from_name("G0#")
    assert_equal 6, KeyboardConverter.from_name("A0#")
    assert_equal 8, KeyboardConverter.from_name("C1#")
  end

  def test_converts_note_to_tone
    assert_equal "C0", KeyboardConverter.from_note(1)
    assert_equal "D0", KeyboardConverter.from_note(2)
    assert_equal "E0", KeyboardConverter.from_note(3)
    assert_equal "F0", KeyboardConverter.from_note(4)
    assert_equal "G0", KeyboardConverter.from_note(5)
    assert_equal "A0", KeyboardConverter.from_note(6)
    assert_equal "B0", KeyboardConverter.from_note(7)
    assert_equal "C1", KeyboardConverter.from_note(8)
    assert_equal "D1", KeyboardConverter.from_note(9)
    assert_equal "E1", KeyboardConverter.from_note(10)
    assert_equal "F1", KeyboardConverter.from_note(11)
    assert_equal "G1", KeyboardConverter.from_note(12)
    assert_equal "A1", KeyboardConverter.from_note(13)
    assert_equal "B1", KeyboardConverter.from_note(14)
    assert_equal "C2", KeyboardConverter.from_note(15)
    assert_equal "D2", KeyboardConverter.from_note(16)
    assert_equal "E2", KeyboardConverter.from_note(17)
  end
end
