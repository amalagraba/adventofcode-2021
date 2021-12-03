package amalagraba.puzzle.day02;

import amalagraba.PuzzleRunner;
import amalagraba.puzzle.AbstractPuzzle;

import java.util.Arrays;

public class Day02 extends AbstractPuzzle {

    public static void main(String[] args) {
        PuzzleRunner.run(new Day02());
    }

    /**
     * Definition: https://adventofcode.com/2021/day/2
     */
    @Override
    public String solvePart1(String rawInput) {
        return solve(rawInput, new SimpleLocationCommandExecutor());
    }

    /**
     * Definition: https://adventofcode.com/2021/day/2#part2
     */
    @Override
    public String solvePart2(String rawInput) {
        return solve(rawInput, new AimedLocationCommandExecutor());
    }

    private String solve(String rawInput, LocationCommandExecutor executor) {
        Location location = new Location();

        Arrays.stream(splitInputLines(rawInput)).forEach(command -> executor.execute(command, location));

        return String.valueOf(location.getCoordinateProduct());
    }
}
