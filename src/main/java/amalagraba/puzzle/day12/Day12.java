package amalagraba.puzzle.day12;

import amalagraba.PuzzleRunner;
import amalagraba.puzzle.AbstractPuzzle;

public class Day12 extends AbstractPuzzle {

    public static void main(String[] args) {
        PuzzleRunner.run(new Day12());
    }

    /**
     * Definition: https://adventofcode.com/2021/day/12
     */
    @Override
    public String solvePart1(String rawInput) {
        return solve(rawInput, new CavePathFinder());
    }

    /**
     * Definition: https://adventofcode.com/2021/day/12#part2
     */
    @Override
    public String solvePart2(String rawInput) {
        return solve(rawInput, new SmallDuplicateAllowedCavePathFinder());
    }

    private String solve(String rawInput, CavePathFinder pathFinder) {
        CaveMap caveMap = new CaveMap(splitInputLines(rawInput));

        caveMap.visit(pathFinder);

        return String.valueOf(pathFinder.getPaths().size());
    }
}
