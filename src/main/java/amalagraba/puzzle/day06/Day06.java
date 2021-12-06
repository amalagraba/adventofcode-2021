package amalagraba.puzzle.day06;

import amalagraba.PuzzleRunner;
import amalagraba.puzzle.AbstractPuzzle;

public class Day06 extends AbstractPuzzle {

    public static void main(String[] args) {
        PuzzleRunner.run(new Day06());
    }

    /**
     * Definition: https://adventofcode.com/2021/day/5
     */
    @Override
    public String solvePart1(String rawInput) {
        return solve(rawInput, 80);
    }

    /**
     * Definition: https://adventofcode.com/2021/day/5#part2
     */
    @Override
    public String solvePart2(String rawInput) {
        return solve(rawInput, 256);
    }

    private String solve(String rawInput, int days) {
        LanternfishPopulationSimulator populationSimulator = new LanternfishPopulationSimulator(rawInput);
        populationSimulator.simulateDays(days);

        return String.valueOf(populationSimulator.count());
    }
}
