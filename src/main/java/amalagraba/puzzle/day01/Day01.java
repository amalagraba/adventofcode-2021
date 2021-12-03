package amalagraba.puzzle.day01;

import amalagraba.PuzzleRunner;
import amalagraba.puzzle.AbstractPuzzle;

public class Day01 extends AbstractPuzzle {

    public static void main(String[] args) {
        PuzzleRunner.run(new Day01());
    }

    /**
     * Definition: https://adventofcode.com/2021/day/1
     */
    @Override
    public String solvePart1(String rawInput) {
        return solve(rawInput, new DepthIncreaseEvaluator());
    }

    /**
     * Definition: https://adventofcode.com/2021/day/1#part2
     */
    @Override
    public String solvePart2(String rawInput) {
        return solve(rawInput, new WindowedDepthIncreaseEvaluator());
    }

    private String solve(String rawInput, DepthIncreaseEvaluator evaluator) {
        return String.valueOf(evaluator.evaluate(parseInputToIntArray(rawInput)));
    }
}
