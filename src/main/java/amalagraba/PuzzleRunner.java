package amalagraba;

import amalagraba.input.InputReader;
import amalagraba.puzzle.Puzzle;

public class PuzzleRunner {

    private static final InputReader inputReader = new InputReader();

    public static void run(Puzzle puzzle) {
        System.out.println("Solving puzzle for " + puzzle.getClass().getSimpleName() + ":");

        String input = inputReader.read(puzzle.inputFileName());

        System.out.println("Solution for part 1: " + puzzle.solvePart1(input));
        System.out.println("Solution for part 2: " + puzzle.solvePart2(input));
    }
}
