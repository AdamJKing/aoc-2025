package uk.co.bumblebyte;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DayTwoTest {
    @Test
    void testIdValidation() {
        Assertions.assertTrue(DayTwo.isValidId(1234));
        Assertions.assertFalse(DayTwo.isValidId(1212));
        Assertions.assertFalse(DayTwo.isValidId(1188511885));
        Assertions.assertFalse(DayTwo.isValidId(55));
    }

    @Test
    void testIdValidationV2() {
        Assertions.assertTrue(DayTwo.isValidIdV2(1234));
        Assertions.assertFalse(DayTwo.isValidIdV2(1212));
        Assertions.assertFalse(DayTwo.isValidIdV2(1188511885));
        Assertions.assertFalse(DayTwo.isValidIdV2(55));
        Assertions.assertFalse(DayTwo.isValidIdV2(1111111));
        Assertions.assertFalse(DayTwo.isValidIdV2(123123123));
        Assertions.assertTrue(DayTwo.isValidIdV2(1188511880));
        Assertions.assertTrue(DayTwo.isValidIdV2(998));
    }

    @Test
    void testGetSumInvalid() {
        Assertions.assertEquals(123123, DayTwo.getSumInvalid(new String[]{"123123-123124"}));
        Assertions.assertEquals(33, DayTwo.getSumInvalid(new String[]{"11-22"}));
    }

    @Test
    void exampleOne() {
        String[] input = {"11-22", "95-115", "998-1012", "1188511880-1188511890", "222220-222224",
                "1698522-1698528", "446443-446449", "38593856-38593862", "565653-565659",
                "824824821-824824827", "2121212118-2121212124"};

        Assertions.assertEquals(1227775554, DayTwo.getSumInvalid(input));
    }

    @Test
    void exampleTwo() {
        String[] input = {"11-22", "95-115", "998-1012", "1188511880-1188511890", "222220-222224",
                "1698522-1698528", "446443-446449", "38593856-38593862", "565653-565659",
                "824824821-824824827", "2121212118-2121212124"};

        Assertions.assertEquals(4174379265L, DayTwo.getSumInvalidV2(input));
    }
}