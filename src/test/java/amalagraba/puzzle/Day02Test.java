package amalagraba.puzzle;

import org.junit.Test;

import static amalagraba.input.TestInput.stringInput;
import static org.junit.Assert.assertEquals;

public class Day02Test {

    private final Day02 puzzle = new Day02();

    @Test
    public void input_file_name_must_be_day02_txt() {
        assertEquals("day02.txt", puzzle.inputFileName());
    }

    @Test
    public void when_input_is_empty_solvePart1_result_is_0() {
        String input = "";

        String result = puzzle.solvePart1(input);

        assertEquals("0", result);
    }

    @Test
    public void when_input_is_forward_3_solvePart1_result_is_0() {
        String input = stringInput("forward 3");

        String result = puzzle.solvePart1(input);

        assertEquals("0", result);
    }

    @Test
    public void when_input_is_forward_3_and_down_2_solvePart1_result_is_6() {
        String input = stringInput("forward 3", "down 2");

        String result = puzzle.solvePart1(input);

        assertEquals("6", result);
    }

    @Test
    public void when_input_is_forward_5_down_4_and_up_2_solvePart1_result_is_10() {
        String input = stringInput("forward 5", "down 4", "up 2");

        String result = puzzle.solvePart1(input);

        assertEquals("10", result);
    }

    @Test
    public void when_input_is_empty_solvePart2_result_is_0() {
        String input = "";

        String result = puzzle.solvePart2(input);

        assertEquals("0", result);
    }

    @Test
    public void when_input_is_forward_3_solvePart2_result_is_0() {
        String input = stringInput("forward 3");

        String result = puzzle.solvePart2(input);

        assertEquals("0", result);
    }

    @Test
    public void when_input_is_down_2_and_forward_3_olvePart2_result_is_18() {
        String input = stringInput("down 2", "forward 3");

        String result = puzzle.solvePart2(input);

        assertEquals("18", result);
    }

    @Test
    public void when_input_is_down_4_up_2_and_forward_5_solvePart2_result_is_60() {
        String input = stringInput("down 4", "up 2", "forward 5");

        String result = puzzle.solvePart2(input);

        assertEquals("50", result);
    }
}