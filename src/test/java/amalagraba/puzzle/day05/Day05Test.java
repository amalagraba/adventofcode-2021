package amalagraba.puzzle.day05;

import org.junit.Test;

import static amalagraba.input.TestInput.stringInput;
import static org.junit.Assert.assertEquals;

public class Day05Test {

    private final Day05 puzzle = new Day05();

    @Test
    public void input_file_name_must_be_day05_txt() {
        assertEquals("day05.txt", puzzle.inputFileName());
    }

    @Test
    public void when_input_is_empty_solvePart1_result_is_0() {
        String input = "";

        String result = puzzle.solvePart1(input);

        assertEquals("0", result);
    }

    @Test
    public void when_input_is_1_4_to_1_10_and_1_5_to_1_7_solvePart1_result_is_3() {
        String input = stringInput("1,4 -> 1,10", "1,5 -> 1,7");

        String result = puzzle.solvePart1(input);

        assertEquals("3", result);
    }

    @Test
    public void part1_must_not_take_diagonals_into_account() {
        String input = stringInput("1,10 -> 1,4", "1,5 -> 1,7", "0,3 -> 4,7");

        String result = puzzle.solvePart1(input);

        assertEquals("3", result);
    }

    @Test
    public void part2_must_take_diagonals_into_account() {
        String input = stringInput("1,4 -> 1,10", "1,5 -> 1,7", "0,3 -> 4,7");

        String result = puzzle.solvePart2(input);

        assertEquals("4", result);
    }
}