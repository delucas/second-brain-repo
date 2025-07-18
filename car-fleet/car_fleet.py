import unittest

def car_fleet(target, position, speed):
    cars = sorted(zip(position, speed), reverse=True)
    
    fleets = []

    for pos, spd in cars:
        time = (target - pos) / spd
        if time > (fleets[-1] if fleets else 0):
            fleets.append(time)

    return len(fleets)

def car_fleet2(target, position, speed):
    cars = sorted(zip(position, speed), reverse=True)
    
    fleets = 0
    time_to_reach_target = 0

    for pos, spd in cars:
        time = (target - pos) / spd
        if time > time_to_reach_target:
            fleets += 1
            time_to_reach_target = time

    return fleets

class TestCarFleet(unittest.TestCase):
    def test_example_1(self):
        self.assertEqual(car_fleet(12, [10, 8, 0, 5, 3], [2, 4, 1, 1, 3]), 3)

    def test_example_2(self):
        self.assertEqual(car_fleet(10, [3], [3]), 1)

    def test_example_3(self):
        self.assertEqual(car_fleet(100, [0, 2, 4], [4, 2, 1]), 1)

if __name__ == "__main__":
    unittest.main()