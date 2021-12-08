package amalagraba.puzzle.day08;

import amalagraba.PuzzleRunner;
import amalagraba.puzzle.AbstractPuzzle;

import java.util.Arrays;
import java.util.function.BiFunction;

public class Day08 extends AbstractPuzzle {

    public static void main(String[] args) {
        PuzzleRunner.run(new Day08());
    }

    /**
     * Definition: https://adventofcode.com/2021/day/8
     */
    @Override
    public String solvePart1(String rawInput) {
        return solve(rawInput, DisplayOutputDecoder::countUniqueLengthOutputValues);
    }

    /**
     * Definition: https://adventofcode.com/2021/day/8#part2
     */
    @Override
    public String solvePart2(String rawInput) {
        return solve(rawInput, DisplayOutputDecoder::decode);
    }

    private String solve(String rawInput, BiFunction<DisplayOutputDecoder, String, Integer> decodeFunction) {
        DisplayOutputDecoder decoder = new DisplayOutputDecoder();

        int result = Arrays.stream(splitInputLines(rawInput))
                .mapToInt(value -> decodeFunction.apply(decoder, value))
                .sum();

        return String.valueOf(result);
    }
}
