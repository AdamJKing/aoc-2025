package uk.co.bumblebyte;

import java.io.IOException;

public class DayOne {

    public static void main(String[] args) throws IOException {

        String[] input = Util.readInputFull("day_one.txt").split("\n");

        int timesZero = getTimesZero(input);
        System.out.println("Day One (Part One): " + timesZero);

        int timesZeroV2 = getTimesZeroV2(input);
        System.out.println("Day One (Part Two): " + timesZeroV2);
    }

    public static int getTimesZero(String[] input) {
        int dial = 50;
        int timesZero = 0;
        for (String line : input) {
            dial = updateDial(line, dial);

            if (dial == 0) {
                timesZero++;
            }
        }
        return timesZero;
    }

    public static int applyChange(int dial, int change) {
        int realChange = change % 100;
        int updatedDial = dial + realChange;

        if (updatedDial < 0) {
            return updatedDial + 100;

        } else if (updatedDial > 99) {
            return updatedDial - 100;
        }

        return updatedDial;
    }

    public static int countZeroPasses(int dial, int change) {
        // eliminate situations where we did a full turn
        int passes = Math.abs(change / 100);
        int realChange = change - (100 * (change / 100));

        int updatedDial = dial + realChange;

        if ((dial != 0 && updatedDial < 0) || updatedDial > 99 || updatedDial == 0) {
            passes++;
        }

        return passes;
    }

    public static int getTimesZeroV2(String[] input) {
        int dial = 50;
        int timesZero = 0;
        for (String line : input) {
            int change = getChangeV2(line);
            timesZero += countZeroPasses(dial, change);
            dial = applyChange(dial, change);
        }
        return timesZero;
    }

    private static int getChangeV2(String line) {
        boolean isLeft = line.charAt(0) == 'L';
        int amount = Integer.parseInt(line.substring(1));

        return isLeft ? -amount : amount;
    }

    public static int updateDial(String line, int dial) {
        int change = getChange(line);
        return (dial + change) % 100;
    }

    public static int getChange(String line) {
        boolean isLeft = line.charAt(0) == 'L';
        int amount = Integer.parseInt(line.substring(1));

        return isLeft ? 100 - amount : amount;
    }
}
