package uk.co.bumblebyte;

import java.io.IOException;

public class DayFour {
    public static void main(String[] args) throws IOException {
        String file = Util.readInputFull("day_four.txt");
        char[][] input = getInput(file, 139, 139);

        long accessibleRolls = findAccessibleRolls(input, false);
        System.out.println("Day Four (Part One): " + accessibleRolls);
        accessibleRolls = findAccessibleRolls(input, true);
        System.out.println("Day Four (Part Two): " + accessibleRolls);
    }

    public static char[][] getInput(String input, int height, int width) {
        char[][] output = new char[height][width];
        String[] rows = input.split("\n");

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                output[y][x] = rows[y].charAt(x);
            }
        }

        return output;
    }

    public static int findAccessibleRolls(char[][] grid, boolean remove) {
        int sum = 0;

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == '@') {
                    int adjacent = countAdjacent(grid, y, x);

                    if (adjacent < 4) {
                        sum++;
                        if (remove) {
                            grid[y][x] = '.';
                            // start the loop again
                            y = 0;
                            x = 0;
                        }
                    }
                }
            }
        }

        return sum;
    }

    public static int countAdjacent(char[][] grid, int y, int x) {
        int adjacent = 0;

        for (int yn = Math.max(y - 1, 0); yn < Math.min(y + 2, grid.length); yn++) {
            for (int xn = Math.max(x - 1, 0); xn < Math.min(x + 2, grid[0].length); xn++) {
                if (!(yn == y && xn == x) && grid[yn][xn] == '@') {
                    adjacent++;
                }
            }
        }

        return adjacent;
    }
}
