package amalagraba.puzzle;

import amalagraba.PuzzleRunner;
import amalagraba.model.AbstractPuzzle;

import java.util.function.Function;

public class Day01 extends AbstractPuzzle {

    public static void main(String[] args) {
        PuzzleRunner.run(new Day01());
    }

    /**
     * Definition: https://adventofcode.com/2021/day/1
     */
    @Override
    public String solvePart1(String rawInput) {
        return solve(rawInput, this::parseInputToIntArray);
    }

    /**
     * Definition: https://adventofcode.com/2021/day/1#part2
     */
    @Override
    public String solvePart2(String rawInput) {
        return solve(rawInput, this::parseInputToMeasurementWindows);
    }

    private String solve(String rawInput, Function<String, Integer[]> inputMapper) {
        return String.valueOf(countIncreases(inputMapper.apply(rawInput)));
    }

    private Integer countIncreases(Integer[] input) {
        int count = 0;

        for (int i = 1; i < input.length; i++) {
            if (input[i - 1] < input[i]) {
                count++;
            }
        }
        return count;
    }

    private Integer[] parseInputToMeasurementWindows(String rawInput) {
        return mapInputToMeasurementWindows(parseInputToIntArray(rawInput));
    }

    private Integer[] mapInputToMeasurementWindows(Integer[] input) {
        Integer[] windows = new Integer[Math.max(0, input.length - 2)];

        for (int i = 2; i < input.length; i++) {
            windows[i - 2] = input[i] + input[i - 1] + input[i - 2];
        }
        return windows;
    }
}
