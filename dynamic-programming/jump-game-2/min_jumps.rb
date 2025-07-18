require 'minitest/autorun'

class TestMinimumJumps < Minitest::Test

  def min_jumps(nums)
    min_jumps_greedy(nums)
  end

  def min_jumps_greedy(nums)
    jumps = 0
    current_end = 0
    farthest = 0

    nums.each_with_index do |num, i|
      farthest = [farthest, i + num].max
      if i == current_end
        jumps += 1
        current_end = farthest
        break if current_end >= nums.length - 1
      end
    end

    jumps
  end

  def min_jumps_dp(nums)
    _min_jumps(0, nums, {})
  end

  def _min_jumps(idx, nums, mem)
    return mem[idx] if mem.has_key?(idx)
    return 0 if idx == nums.length - 1
    return Float::INFINITY if idx >= nums.length

    min = Float::INFINITY
    (1..nums[idx]).each do |i|
      min = [min, _min_jumps(idx + i, nums, mem)].min
    end
    mem[idx] = min + 1
    return mem[idx]
  end

  def test_example_1
    nums = [2, 3, 1, 1, 4]
    expected_result = 2
    assert_equal expected_result, min_jumps(nums)
  end

  def test_example_2
    nums = [2, 3, 0, 1, 4]
    expected_result = 2
    assert_equal expected_result, min_jumps(nums)
  end
end
