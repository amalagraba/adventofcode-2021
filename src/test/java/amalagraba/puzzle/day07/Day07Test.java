package amalagraba.puzzle.day07;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day07Test {

    private final Day07 puzzle = new Day07();

    @Test
    public void input_file_name_must_be_day07_txt() {
        assertEquals("day07.txt", puzzle.inputFileName());
    }

    @Test
    public void when_input_is_empty_solvePart1_result_is_0() {
        String input = "";

        String result = puzzle.solvePart1(input);

        assertEquals("0", result);
    }

    @Test
    public void when_input_is_16_1_2_0_4_2_7_1_2_14_solvePart1_result_is_37() {
        String input = "16,1,2,0,4,2,7,1,2,14";

        String result = puzzle.solvePart1(input);

        assertEquals("37", result);
    }

    @Test
    public void when_input_is_16_1_2_0_4_2_7_1_2_14_solvePart2_result_is_168() {
        String input = "16,1,2,0,4,2,7,1,2,14";

        String result = puzzle.solvePart2(input);

        assertEquals("168", result);
    }
}