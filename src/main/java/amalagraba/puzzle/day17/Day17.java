package amalagraba.puzzle.day17;

import amalagraba.PuzzleRunner;
import amalagraba.puzzle.AbstractPuzzle;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public class Day17 extends AbstractPuzzle {

    public static void main(String[] args) {
        PuzzleRunner.run(new Day17());
    }

    /**
     * Definition: https://adventofcode.com/2021/day/17
     */
    @Override
    public String solvePart1(String rawInput) {
        return solve(rawInput, highestPoints -> highestPoints.stream().mapToInt(Integer::intValue).max().orElse(0));
    }

    /**
     * Definition: https://adventofcode.com/2021/day/17#part2
     */
    @Override
    public String solvePart2(String rawInput) {
        return solve(rawInput, Collection::size);
    }

    private String solve(String rawInput, Function<List<Integer>, Integer> reduceFunction) {
        TargetArea target = new TargetArea(rawInput);
        ProbeTrajectoryCalculator trajectoryCalculator = new ProbeTrajectoryCalculator(target);

        return String.valueOf(reduceFunction.apply(trajectoryCalculator.getHighestPoints()));
    }
}
