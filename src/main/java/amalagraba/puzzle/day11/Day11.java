package amalagraba.puzzle.day11;

import amalagraba.PuzzleRunner;
import amalagraba.puzzle.AbstractPuzzle;

import java.util.function.Function;

public class Day11 extends AbstractPuzzle {

    public static void main(String[] args) {
        PuzzleRunner.run(new Day11());
    }

    /**
     * Definition: https://adventofcode.com/2021/day/11
     */
    @Override
    public String solvePart1(String rawInput) {
        return solve(rawInput, observer -> observer.observeFlashesInCycles(100));
    }

    /**
     * Definition: https://adventofcode.com/2021/day/11#part2
     */
    @Override
    public String solvePart2(String rawInput) {
        return solve(rawInput, OctopusFlashObserver::observeCyclesBeforeSynchronization);
    }

    private String solve(String rawInput, Function<OctopusFlashObserver, Integer> observation) {
        return String.valueOf(observation.apply(new OctopusFlashObserver(splitInputLines(rawInput))));
    }
}
