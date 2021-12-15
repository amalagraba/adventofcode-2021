package amalagraba.puzzle.day15;

import amalagraba.PuzzleRunner;
import amalagraba.common.grid.Grid;
import amalagraba.common.grid.IntPoint;
import amalagraba.puzzle.AbstractPuzzle;

import java.util.function.Function;

public class Day15 extends AbstractPuzzle {

    public static void main(String[] args) {
        PuzzleRunner.run(new Day15());
    }

    /**
     * Definition: https://adventofcode.com/2021/day/15
     */
    @Override
    public String solvePart1(String rawInput) {
        return solve(rawInput, Function.identity());
    }

    /**
     * Definition: https://adventofcode.com/2021/day/15#part2
     */
    @Override
    public String solvePart2(String rawInput) {
        return solve(rawInput, new GridEnlarger(5));
    }

    private String solve(String rawInput, Function<Grid<IntPoint>, Grid<IntPoint>> mapper) {
        Grid<IntPoint> grid = mapper.apply(new Grid<>(splitInputLines(rawInput), IntPoint::new));

        return String.valueOf(new DijkstraRiskCalculator(grid).calculateLowestRisk());
    }
}
