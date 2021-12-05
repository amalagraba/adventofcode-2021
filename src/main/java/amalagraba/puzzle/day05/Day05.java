package amalagraba.puzzle.day05;

import amalagraba.PuzzleRunner;
import amalagraba.puzzle.AbstractPuzzle;

import java.util.Arrays;
import java.util.function.Predicate;

import static java.util.function.Predicate.not;

public class Day05 extends AbstractPuzzle {

    public static void main(String[] args) {
        PuzzleRunner.run(new Day05());
    }

    /**
     * Definition: https://adventofcode.com/2021/day/5
     */
    @Override
    public String solvePart1(String rawInput) {
        return solve(rawInput, not(VentLine::isDiagonal));
    }

    /**
     * Definition: https://adventofcode.com/2021/day/5#part2
     */
    @Override
    public String solvePart2(String rawInput) {
        return solve(rawInput, line -> true);
    }

    private String solve(String rawInput, Predicate<VentLine> filter) {
        HydrothermalVentField field = new HydrothermalVentField();

        Arrays.stream(splitInputLines(rawInput)).map(VentLine::new).filter(filter).forEach(field::add);

        return String.valueOf(field.countPointsWithMultipleVents());
    }
}
