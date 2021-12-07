package amalagraba.puzzle.day07;

import amalagraba.PuzzleRunner;
import amalagraba.puzzle.AbstractPuzzle;

public class Day07 extends AbstractPuzzle {

    public static void main(String[] args) {
        PuzzleRunner.run(new Day07());
    }

    /**
     * Definition: https://adventofcode.com/2021/day/7
     */
    @Override
    public String solvePart1(String rawInput) {
        return solve(rawInput, steps -> steps);
    }

    /**
     * Definition: https://adventofcode.com/2021/day/7#part2
     */
    @Override
    public String solvePart2(String rawInput) {
        return solve(rawInput, steps -> steps * (steps + 1) / 2);
    }

    private String solve(String rawInput, FuelUsageCalculator fuelUsageCalculator) {
        Integer[] initialPositions = splitCommaSeparatedIntegers(rawInput);

        return String.valueOf(new MinimumFuelUsagePredictor(initialPositions, fuelUsageCalculator).predict());
    }
}
