package uk.co.bumblebyte;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DayThree {
    public static void main(String[] args) throws IOException {
        String[] file = Util.readInputFull("day_three.txt").split("\n");
        List<List<Integer>> input = getInput(file);

        long largestJoltagePossible = sumLargestJoltagePossible(input, 2);
        System.out.println("Day Three (Part One): " + largestJoltagePossible);
        largestJoltagePossible = sumLargestJoltagePossible(input, 12);
        System.out.println("Day Three (Part Two): " + largestJoltagePossible);
    }

    public static List<List<Integer>> getInput(String[] file) {
        List<List<Integer>> input = new ArrayList<>();

        for (String s : file) {
            char[] line = s.toCharArray();
            ArrayList<Integer> nums = new ArrayList<>();
            for (char c : line) {
                nums.add(c - '0');
            }
            input.add(nums);
        }
        return input;
    }

    public static long sumLargestJoltagePossible(List<List<Integer>> input, int n) {
        long sum = 0;

        for (List<Integer> line : input) {
            sum += largestJoltagePossible(line, n);
        }

        return sum;
    }

    public static long largestJoltagePossible(List<Integer> input, int n) {
        return largestJoltagePossibleImpl(input, 0, n, new long[input.size()][n]);
    }

    public static long largestJoltagePossibleImpl(List<Integer> input, int start, int n, long[][] memo) {
        long max = 0;

        if (memo[start][n - 1] > 0) {
            return memo[start][n - 1];
        }

        for (int i = start; i <= input.size() - n; i++) {
            long current = (long) (input.get(i) * Math.pow(10, n - 1));
            long largestOfRemaining = n > 1 ? largestJoltagePossibleImpl(input, i + 1, n - 1, memo) : 0;
            max = Math.max(max, current + largestOfRemaining);
        }

        memo[start][n - 1] = max;
        return max;
    }
}
