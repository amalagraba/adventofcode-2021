package amalagraba.puzzle.day16;

import amalagraba.PuzzleRunner;
import amalagraba.puzzle.AbstractPuzzle;

import java.util.function.Function;

public class Day16 extends AbstractPuzzle {

    public static void main(String[] args) {
        PuzzleRunner.run(new Day16());
    }

    /**
     * Definition: https://adventofcode.com/2021/day/16
     */
    @Override
    public String solvePart1(String rawInput) {
        return solve(rawInput, Packet::getVersionSum);
    }

    /**
     * Definition: https://adventofcode.com/2021/day/16#part2
     */
    @Override
    public String solvePart2(String rawInput) {
        return solve(rawInput, Packet::getValue);
    }

    private String solve(String rawInput, Function<Packet, Long> mapper) {
        return String.valueOf(new PacketDecoder().decode(rawInput).map(mapper).orElse(0L));
    }
}
