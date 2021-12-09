package amalagraba.puzzle.day09;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day09Test {

    private final Day09 puzzle = new Day09();

    @Test
    public void input_file_name_must_be_day08_txt() {
        assertEquals("day09.txt", puzzle.inputFileName());
    }

    @Test
    public void when_input_is_empty_solvePart1_result_is_0() {
        String input = "";

        String result = puzzle.solvePart1(input);

        assertEquals("0", result);
    }

    @Test
    public void when_input_lowest_points_are_0_1_5_and_5_solvePart1_result_is_15() {
        String input = """
                2199943210
                3987894921
                9856789892
                8767896789
                9899965678
                """;

        String result = puzzle.solvePart1(input);

        assertEquals("15", result);
    }

    @Test
    public void when_input_is_empty_solvePart2_result_is_0() {
        String input = "";

        String result = puzzle.solvePart2(input);

        assertEquals("0", result);
    }

    @Test
    public void when_input_top_3_largest_basins_have_size_9_14_and_9_solvePart2_result_is_1134() {
        String input = """
                2199943210
                3987894921
                9856789892
                8767896789
                9899965678
                """;

        String result = puzzle.solvePart2(input);

        assertEquals("1134", result);
    }
}