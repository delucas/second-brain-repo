require 'minitest/autorun'

class TestJumpGame < Minitest::Test

  def can_jump(nums)
    can_jump_greedy(nums)
  end

  def can_jump_greedy(nums)
    goal = nums.size - 1
    (nums.size - 2).downto(0) do |i|
      if i + nums[i] >= goal
        goal = i
      end
    end
    goal == 0
  end

  def can_jump_dp(nums)
    _can_jump(0, nums, {})
  end

  def _can_jump(idx, nums, mem)
    return mem[idx] if mem.has_key?(idx)
    return false if idx > nums.size
    return true if idx == nums.size - 1

    can = false
    (1..nums[idx]).each do |i|
      can ||= _can_jump(idx + i, nums, mem)
    end
    mem[idx] = can

    return mem[idx]
  end

  def test_example_1
    nums = [2, 3, 1, 1, 4]
    expected_result = true
    assert_equal expected_result, can_jump(nums)
  end

  def test_example_2
    nums = [3, 2, 1, 0, 4]
    expected_result = false
    assert_equal expected_result, can_jump(nums)
  end
end
