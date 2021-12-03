package amalagraba.puzzle;

import amalagraba.PuzzleRunner;
import amalagraba.model.AbstractPuzzle;
import amalagraba.model.day03.BitReadingCalculator;
import amalagraba.model.day03.LifeSupportRatingCalculator;
import amalagraba.model.day03.PowerConsumptionCalculator;

import java.util.Arrays;

public class Day03 extends AbstractPuzzle {

    public static void main(String[] args) {
        PuzzleRunner.run(new Day03());
    }

    /**
     * Definition: https://adventofcode.com/2021/day/3
     */
    @Override
    public String solvePart1(String rawInput) {
        return solve(rawInput, new PowerConsumptionCalculator());
    }

    /**
     * Definition: https://adventofcode.com/2021/day/3#part2
     */
    @Override
    public String solvePart2(String rawInput) {
        return solve(rawInput, new LifeSupportRatingCalculator());
    }

    private String solve(String rawInput, BitReadingCalculator calculator) {
        Arrays.stream(splitInputLines(rawInput)).forEach(calculator::addReading);

        return String.valueOf(calculator.calculate());
    }
}
