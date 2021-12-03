package amalagraba.puzzle;

import org.junit.Test;

import static amalagraba.input.TestInput.stringInput;
import static org.junit.Assert.assertEquals;

public class Day03Test {

    private final Day03 puzzle = new Day03();

    @Test
    public void input_file_name_must_be_day03_txt() {
        assertEquals("day03.txt", puzzle.inputFileName());
    }

    @Test
    public void when_input_is_empty_solvePart1_result_is_0() {
        String input = "";

        String result = puzzle.solvePart1(input);

        assertEquals("0", result);
    }

    @Test
    public void when_input_is_00100_10010_00010_result_is_0() {
        String input = stringInput("00100", "10010", "00010");

        String result = puzzle.solvePart1(input);

        assertEquals("58", result);
    }
}