package uk.co.bumblebyte;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DayFiveTest {
    @Test
    void testInputParsing() {
        String raw = """
                3-5
                10-14
                16-20
                12-18
                
                1
                5
                8
                11
                17
                32""";

        String[] input = raw.split("\n\n");

        long[][] expectedRanges = {{3, 5}, {10, 14}, {16, 20}, {12, 18}};
        long[] expectedIngredientIds = {1, 5, 8, 11, 17, 32};

        Assertions.assertArrayEquals(expectedRanges, DayFive.getFreshRanges(input[0]));
        Assertions.assertArrayEquals(expectedIngredientIds, DayFive.getIngredients(input[1]));
    }

    @Test
    void exampleOne() {
        long[][] freshRanges = {{3, 5}, {10, 14}, {16, 20}, {12, 18}};
        long[] ingredientIds = {1, 5, 8, 11, 17, 32};

        Assertions.assertEquals(3, DayFive.countFreshIngredients(freshRanges, ingredientIds));
    }

    @Test
    void exampleTwo() {
        long[][] freshRanges = {{3, 5}, {10, 14}, {16, 20}, {12, 18}};

        Assertions.assertEquals(14, DayFive.countFreshIngredients(freshRanges));
    }
}