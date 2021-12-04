package amalagraba.puzzle.day04;

import amalagraba.PuzzleRunner;
import amalagraba.puzzle.AbstractPuzzle;

import java.util.Optional;

public class Day04 extends AbstractPuzzle {

    public static void main(String[] args) {
        PuzzleRunner.run(new Day04());
    }

    /**
     * Definition: https://adventofcode.com/2021/day/4
     */
    @Override
    public String solvePart1(String rawInput) {
        return solve(rawInput, new Bingo());
    }

    /**
     * Definition: https://adventofcode.com/2021/day/4#part2
     */
    @Override
    public String solvePart2(String rawInput) {
        return solve(rawInput, new LastWinnerBingo());
    }

    private String solve(String rawInput, Bingo bingo) {
        Optional<BingoBoard> winner = bingo.play(splitInputLines(rawInput));

        return winner.map(BingoBoard::getFinalScore).map(String::valueOf).orElse("0");
    }
}
