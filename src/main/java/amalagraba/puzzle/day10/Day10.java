package amalagraba.puzzle.day10;

import amalagraba.PuzzleRunner;
import amalagraba.puzzle.AbstractPuzzle;

public class Day10 extends AbstractPuzzle {

    public static void main(String[] args) {
        PuzzleRunner.run(new Day10());
    }

    /**
     * Definition: https://adventofcode.com/2021/day/10
     */
    @Override
    public String solvePart1(String rawInput) {
        return solve(rawInput, new InvalidSyntaxScoreCalculator());
    }

    /**
     * Definition: https://adventofcode.com/2021/day/10#part2
     */
    @Override
    public String solvePart2(String rawInput) {
        return solve(rawInput, new IncompleteLineScoreCalculator());
    }

    private String solve(String rawInput, SyntaxScoreCalculator calculator) {
        return String.valueOf(calculator.calculate(splitInputLines(rawInput)));
    }
}
