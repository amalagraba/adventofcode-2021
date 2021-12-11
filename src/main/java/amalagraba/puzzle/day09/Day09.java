package amalagraba.puzzle.day09;

import amalagraba.PuzzleRunner;
import amalagraba.puzzle.AbstractPuzzle;

import java.util.Collection;
import java.util.Comparator;
import java.util.function.Function;

public class Day09 extends AbstractPuzzle {

    public static void main(String[] args) {
        PuzzleRunner.run(new Day09());
    }

    /**
     * Definition: https://adventofcode.com/2021/day/9
     */
    @Override
    public String solvePart1(String rawInput) {
        return solve(rawInput, mapper -> mapper.findLowPoints().stream()
                .mapToInt(point -> point.getValue() + 1)
                .sum());
    }

    /**
     * Definition: https://adventofcode.com/2021/day/9#part2
     */
    @Override
    public String solvePart2(String rawInput) {
        return solve(rawInput, mapper -> mapper.findBasins().stream()
                .map(Collection::size)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .reduce(0, (accumulator, value) -> Math.max(1, accumulator) * value));
    }

    private String solve(String rawInput, Function<CaveTopographyMapper, Integer> valueCalculator) {
        return String.valueOf(valueCalculator.apply(new CaveTopographyMapper(splitInputLines(rawInput))));
    }
}
