package uk.co.bumblebyte;

import java.io.IOException;

public class DayTwo {
    public static void main(String[] args) throws IOException {

        String[] input = Util.readInputFull("day_two.txt").trim().split(",");

        long sumInvalid = getSumInvalid(input);
        System.out.println("Day Two (Part One): " + sumInvalid);

        sumInvalid = getSumInvalidV2(input);
        System.out.println("Day Two (Part Two): " + sumInvalid);
    }

    public static long getSumInvalid(String[] input) {
        long sumInvalid = 0;

        for (String range : input) {
            String[] pair = range.split("-");
            long start = Long.parseLong(pair[0]);
            long end = Long.parseLong(pair[1]);

            for (long id = start; id <= end; id++) {
                if (!isValidId(id)) {
                    sumInvalid += id;
                }
            }
        }
        return sumInvalid;
    }

    public static long getSumInvalidV2(String[] input) {
        long sumInvalid = 0;

        for (String range : input) {
            String[] pair = range.split("-");
            long start = Long.parseLong(pair[0]);
            long end = Long.parseLong(pair[1]);

            for (long id = start; id <= end; id++) {
                if (!isValidIdV2(id)) {
                    sumInvalid += id;
                }
            }
        }
        return sumInvalid;
    }

    public static boolean isValidId(long id) {
        String idAsString = Long.toString(id);

        int midpoint = idAsString.length() / 2;
        return !idAsString.substring(0, midpoint).equals(idAsString.substring(midpoint));
    }

    public static boolean isValidIdV2(long id) {
        String idAsString = Long.toString(id);
        int nextOccurrence = idAsString.indexOf(idAsString.charAt(0), 1);

        while (nextOccurrence > 0) {
            String pattern = idAsString.substring(0, nextOccurrence);
            String result = pattern.repeat(idAsString.length() / pattern.length());

            if (idAsString.equals(result)) {
                return false;
            }

            nextOccurrence = idAsString.indexOf(idAsString.charAt(0), nextOccurrence + 1);
        }


        return true;
    }
}
