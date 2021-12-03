package amalagraba.puzzle;

public interface Puzzle {

    String solvePart1(String rawInput);

    String solvePart2(String rawInput);

    default String inputFileName() {
        return getClass().getSimpleName().toLowerCase() + ".txt";
    }
}
