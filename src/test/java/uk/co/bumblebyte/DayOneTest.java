package uk.co.bumblebyte;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DayOneTest {
    @Test
    void testDialUpdate() {
        Assertions.assertEquals(99, DayOne.updateDial("L1", 0));
    }

    @Test
    void testPassingZeroCounterLeftwise() {
        int result = DayOne.countZeroPasses(10, -20);
        Assertions.assertEquals(1, result);

    }

    @Test
    void testPassingZeroCounterRightwise() {
        int result = DayOne.countZeroPasses(90, 20);

        Assertions.assertEquals(1, result);
    }

    @Test
    void testCountingZeroPassesOfLargeChanges() {
        Assertions.assertEquals(2, DayOne.countZeroPasses(50, 200));
        Assertions.assertEquals(2, DayOne.countZeroPasses(50, -200));
    }

    @Test
    void testApplyingLargeChanges() {
        Assertions.assertEquals(50, DayOne.applyChange(50, 300));
        Assertions.assertEquals(50, DayOne.applyChange(50, -300));
    }

    @Test
    void testPassingZeroCounterExactMatch() {
        int result = DayOne.countZeroPasses(10, -10);

        Assertions.assertEquals(1, result);
    }

    @Test
    void testApplyChange() {
        Assertions.assertEquals(90, DayOne.applyChange(10, -20));
        Assertions.assertEquals(10, DayOne.applyChange(90, 20));
        Assertions.assertEquals(82, DayOne.applyChange(50, -68));
    }

    @Test
    void testGetChange() {
        Assertions.assertEquals(95, DayOne.getChange("L5"));
        Assertions.assertEquals(5, DayOne.getChange("R5"));
    }

    @Test
    void exampleOne() {
        String[] input = {
                "L68", "L30", "R48", "L5", "R60", "L55", "L1", "L99", "R14", "L82"
        };


        Assertions.assertEquals(3, DayOne.getTimesZero(input));
    }

    @Test
    void exampleTwo() {
        String[] input = {
                "L68", "L30", "R48", "L5", "R60", "L55", "L1", "L99", "R14", "L82"
        };

        Assertions.assertEquals(6, DayOne.getTimesZeroV2(input));
    }
}