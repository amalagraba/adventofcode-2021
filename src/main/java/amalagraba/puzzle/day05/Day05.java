package amalagraba.puzzle.day05;

import amalagraba.PuzzleRunner;
import amalagraba.common.Line;
import amalagraba.puzzle.AbstractPuzzle;

import java.util.Arrays;
import java.util.function.Predicate;

public class Day05 extends AbstractPuzzle {

    public static void main(String[] args) {
        PuzzleRunner.run(new Day05());
    }

    /**
     * Definition: https://adventofcode.com/2021/day/5
     */
    @Override
    public String solvePart1(String rawInput) {
        return solve(rawInput, Line::isHorizontalOrVertical);
    }

    /**
     * Definition: https://adventofcode.com/2021/day/5#part2
     */
    @Override
    public String solvePart2(String rawInput) {
        return solve(rawInput, line -> true);
    }

    private String solve(String rawInput, Predicate<Line> filter) {
        HydrothermalVentField field = new HydrothermalVentField(filter);

        Arrays.stream(splitInputLines(rawInput)).forEach(field::addLine);

        return String.valueOf(field.countPointsWithMultipleVents());
    }
}
