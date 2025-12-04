package uk.co.bumblebyte;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class DayThreeTest {
    @Test
    void exampleOne() {
        List<List<Integer>> input = List.of(List.of(9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1, 1, 1, 1, 1), List.of(8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9), List.of(2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 7, 8), List.of(8, 1, 8, 1, 8, 1, 9, 1, 1, 1, 1, 2, 1, 1, 1));

        Assertions.assertEquals(357, DayThree.sumLargestJoltagePossible(input, 2));
    }

    @Test
    void exampleTwo() {
        List<List<Integer>> input = List.of(List.of(9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1, 1, 1, 1, 1), List.of(8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9), List.of(2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 7, 8), List.of(8, 1, 8, 1, 8, 1, 9, 1, 1, 1, 1, 2, 1, 1, 1));

        Assertions.assertEquals(3121910778619L, DayThree.sumLargestJoltagePossible(input, 12));
    }

    @Test
    void testLargestJoltagePossible() {
//        Assertions.assertEquals(1, DayThree.largestJoltagePossible(List.of(1), 1));
//        Assertions.assertEquals(12, DayThree.largestJoltagePossible(List.of(1, 2), 2));
//        Assertions.assertEquals(12, DayThree.largestJoltagePossible(List.of(1, 2), 2));
//        Assertions.assertEquals(78, DayThree.largestJoltagePossible(List.of(3, 4, 2, 7, 8), 2));
//
//        Assertions.assertEquals(987654321111d, DayThree.largestJoltagePossible(List.of(9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1, 1, 1, 1, 1), 12));
//        Assertions.assertEquals(811111111119d, DayThree.largestJoltagePossible(List.of(8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9), 12));
//        Assertions.assertEquals(434234234278d, DayThree.largestJoltagePossible(List.of(2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 7, 8), 12));
//        Assertions.assertEquals(888911112111d, DayThree.largestJoltagePossible(List.of(8, 1, 8, 1, 8, 1, 9, 1, 1, 1, 1, 2, 1, 1, 1), 12));

        Assertions.assertEquals(3123d, DayThree.largestJoltagePossible(List.of(1, 2, 3, 1, 1, 2, 3), 4));
    }

    @Test
    void testInputParsing() {
        Assertions.assertEquals(List.of(List.of(1, 2, 3, 4, 5, 6, 7, 8), List.of(1, 2, 3, 4, 5, 6, 7, 8)), DayThree.getInput(new String[]{"12345678", "12345678"}));
    }
}