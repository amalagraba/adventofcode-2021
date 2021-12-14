package amalagraba.puzzle.day14;

import amalagraba.PuzzleRunner;
import amalagraba.puzzle.AbstractPuzzle;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Day14 extends AbstractPuzzle {

    public static void main(String[] args) {
        PuzzleRunner.run(new Day14());
    }

    /**
     * Definition: https://adventofcode.com/2021/day/14
     */
    @Override
    public String solvePart1(String rawInput) {
        return solve(rawInput, 10);
    }

    /**
     * Definition: https://adventofcode.com/2021/day/14#part2
     */
    @Override
    public String solvePart2(String rawInput) {
        return solve(rawInput, 40);
    }

    private String solve(String rawInput, int iterations) {
        String[] input = splitInputLines(rawInput);

        if (input.length > 2) {
            Map<String, String> rules = Arrays.stream(input).skip(2)
                    .map(value -> value.split(" -> "))
                    .collect(Collectors.toMap(value -> value[0], value -> value[1]));

            return solve(input[0], rules, iterations);
        }
        return "0";
    }

    private String solve(String initialState, Map<String, String> rules, int iterations) {
        PolymerCombinator combinator = new PolymerCombinator(initialState, rules);
        combinator.insertPairs(iterations);

        return String.valueOf(combinator.getPolymerScore());
    }
}
