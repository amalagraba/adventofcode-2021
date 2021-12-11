package amalagraba.puzzle.day11;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day11Test {

    private final Day11 puzzle = new Day11();

    @Test
    public void input_file_name_must_be_day08_txt() {
        assertEquals("day11.txt", puzzle.inputFileName());
    }

    @Test
    public void when_input_is_empty_solvePart1_result_is_0() {
        String input = "";

        String result = puzzle.solvePart1(input);

        assertEquals("0", result);
    }

    @Test
    public void when_input_has_1656_after_100_iterations_solvePart1_result_is_1656() {
        String input = """
                5483143223
                2745854711
                5264556173
                6141336146
                6357385478
                4167524645
                2176841721
                6882881134
                4846848554
                5283751526
                """;

        String result = puzzle.solvePart1(input);

        assertEquals("1656", result);
    }

    @Test
    public void when_input_is_empty_solvePart2_result_is_0() {
        String input = "";

        String result = puzzle.solvePart2(input);

        assertEquals("0", result);
    }

    @Test
    public void when_input_flashes_sync_after_195_iterations_solvePart2_result_is_195() {
        String input = """
                5483143223
                2745854711
                5264556173
                6141336146
                6357385478
                4167524645
                2176841721
                6882881134
                4846848554
                5283751526
                """;

        String result = puzzle.solvePart2(input);

        assertEquals("195", result);
    }
}