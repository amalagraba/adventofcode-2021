package amalagraba.puzzle.day06;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day06Test {

    private final Day06 puzzle = new Day06();

    @Test
    public void input_file_name_must_be_day06_txt() {
        assertEquals("day06.txt", puzzle.inputFileName());
    }

    @Test
    public void when_input_is_empty_solvePart1_result_is_0() {
        String input = "";

        String result = puzzle.solvePart1(input);

        assertEquals("0", result);
    }

    @Test
    public void when_input_is_3_4_3_1_2_solvePart1_returns_5934() {
        String input = "3,4,3,1,2";

        String result = puzzle.solvePart1(input);

        assertEquals("5934", result);
    }

    @Test
    public void when_input_is_empty_solvePart2_result_is_0() {
        String input = "";

        String result = puzzle.solvePart2(input);

        assertEquals("0", result);
    }

    @Test
    public void when_input_is_3_4_3_1_2_solvePart2_returns_26984457539() {
        String input = "3,4,3,1,2";

        String result = puzzle.solvePart2(input);

        assertEquals("26984457539", result);
    }
}