package amalagraba.puzzle.day01;

import org.junit.Test;

import static amalagraba.input.TestInput.integerInput;
import static org.junit.Assert.assertEquals;

public class Day01Test {

    private final Day01 puzzle = new Day01();

    @Test
    public void input_file_name_must_be_day01_txt() {
        assertEquals("day01.txt", puzzle.inputFileName());
    }

    @Test
    public void given_an_empty_input_solvePart1_returns_0() {
        String input = "";

        String result = puzzle.solvePart1(input);

        assertEquals("0", result);
    }
    
    @Test
    public void given_no_increases_solvePart1_must_return_0() {
        String input = integerInput(105, 95, 80, 76);

        String result = puzzle.solvePart1(input);

        assertEquals("0", result);
    }

    @Test
    public void given_3_increases_solvePart1_must_return_3() {
        String input = integerInput(105, 107, 250, 300);

        String result = puzzle.solvePart1(input);

        assertEquals("3", result);
    }

    @Test
    public void given_2_increases_1_decrease_and_3_increases_solvePart1_must_return_5() {
        String input = integerInput(105, 107, 250, 180, 300, 320, 700);

        String result = puzzle.solvePart1(input);

        assertEquals("5", result);
    }

    @Test
    public void given_no_input_solvePart2_result_is_0() {
        String input = "";

        String result = puzzle.solvePart2(input);

        assertEquals("0", result);
    }

    @Test
    public void given_less_than_3_numbers_solvePart2_result_is_0() {
        String input = integerInput(150, 120);

        String result = puzzle.solvePart2(input);

        assertEquals("0", result);
    }

    @Test
    public void given_1_increasing_windows_solvePart2_result_is_1() {
        String input = integerInput(150, 120, 140, 167);

        String result = puzzle.solvePart2(input);

        assertEquals("1", result);
    }


    @Test
    public void given_1_increasing_window_2_decreasing_and_3_increasing_solvePart2_result_is_4() {
        String input = integerInput(150, 120, 140, 180, 80, 10, 200, 300, 400);

        String result = puzzle.solvePart2(input);

        assertEquals("4", result);
    }
}