package uk.co.bumblebyte;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DayFive {
    public static void main(String[] args) throws IOException {
        String file = Util.readInputFull("day_five.txt");
        String[] input = file.split("\n\n");

        long[][] freshRanges = getFreshRanges(input[0]);
        long[] ingredientIds = getIngredients(input[1]);

        long numFreshIngredients = countFreshIngredients(freshRanges, ingredientIds);
        System.out.println("Day Five (Part One): " + numFreshIngredients);
        long numFreshIngredientsInRanges = countFreshIngredients(freshRanges);
        System.out.println("Day Five (Part Two): " + numFreshIngredientsInRanges);
    }

    public static long[][] getFreshRanges(String input) {
        String[] lines = input.split("\n");
        long[][] ranges = new long[lines.length][2];

        for (int i = 0; i < lines.length; i++) {
            String[] pair = lines[i].split("-");
            ranges[i] = new long[]{Long.parseLong(pair[0]), Long.parseLong(pair[1])};
        }

        return ranges;
    }

    public static long[] getIngredients(String input) {
        String[] lines = input.split("\n");
        long[] ids = new long[lines.length];

        for (int i = 0; i < lines.length; i++) {
            ids[i] = Long.parseLong(lines[i]);
        }

        return ids;
    }

    public static long countFreshIngredients(long[][] freshRanges, long[] availableIngredients) {
        long count = 0;

        for (long id : availableIngredients) {
            for (long[] range : freshRanges) {
                if (range[0] <= id && id <= range[1]) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }

    public static boolean hasOverlaps(List<long[]> ranges) {
        for (long[] range : ranges) {
            for (long[] other : ranges) {
                boolean leftOverlap = (other[0] <= range[0] && range[0] <= other[1]);
                boolean rightOverlap = (other[0] <= range[1] && range[1] <= other[1]);

                if (!Arrays.equals(range, other)) {
                    if (leftOverlap || rightOverlap) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static long countFreshIngredients(long[][] freshRanges) {
        LinkedList<long[]> source = new LinkedList<>(Arrays.asList(freshRanges));

        while (hasOverlaps(source)) {
            LinkedList<long[]> combinedRanges = new LinkedList<>();

            for (long[] current : source) {
                // look for an existing range that could hold the current range
                boolean merged = false;

                for (long[] range : combinedRanges) {
                    boolean leftOverlap = (range[0] <= current[0] && current[0] <= range[1]);
                    boolean rightOverlap = (range[0] <= current[1] && current[1] <= range[1]);

                    if (leftOverlap || rightOverlap) {
                        range[0] = Math.min(range[0], current[0]);
                        range[1] = Math.max(range[1], current[1]);

                        merged = true;
                        break;
                    }
                }

                if (!merged) {
                    combinedRanges.push(current);
                }
            }

            source = combinedRanges;
        }

        long count = 0;

        for (long[] range : source) {
            count += range[1] - range[0] + 1;
        }

        return count;
    }
}
