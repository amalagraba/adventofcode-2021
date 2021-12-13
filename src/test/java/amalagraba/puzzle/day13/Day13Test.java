package amalagraba.puzzle.day13;

import org.junit.Test;

import static amalagraba.input.TestInput.stringInput;
import static org.junit.Assert.assertEquals;

public class Day13Test {

    private final Day13 puzzle = new Day13();

    @Test
    public void input_file_name_must_be_day13_txt() {
        assertEquals("day13.txt", puzzle.inputFileName());
    }

    @Test
    public void when_input_is_empty_solvePart1_result_is_0() {
        String input = "";

        String result = puzzle.solvePart1(input);

        assertEquals("0", result);
    }

    @Test
    public void when_the_first_fold_leaves_17_visible_points_solvePart1_result_is_17() {
        String input = stringInput("6,10", "0,14", "9,10", "0,3", "10,4", "4,11", "6,0", "6,12", "4,1", "0,13",
                "10,12", "3,4", "3,0", "8,4", "1,10", "2,14", "8,10", "9,0", "", "fold along y=7", "fold along x=5");

        String result = puzzle.solvePart1(input);

        assertEquals("17", result);
    }


    @Test
    public void when_input_is_empty_solvePart2_result_is_empty() {
        String input = "";

        String result = puzzle.solvePart2(input);

        assertEquals("\n \n", result);
    }

    @Test
    public void when_folding_results_in_a_square_visible_points_solvePart2_result_is_a_square() {
        String input = stringInput("6,10", "0,14", "9,10", "0,3", "10,4", "4,11", "6,0", "6,12", "4,1", "0,13",
                "10,12", "3,4", "3,0", "8,4", "1,10", "2,14", "8,10", "9,0", "", "fold along y=7", "fold along x=5");
        String expected = stringInput("",
                "#####",
                "#   #",
                "#   #",
                "#   #",
                "#####",
                "");

        String result = puzzle.solvePart2(input);

        assertEquals(expected, result);
    }
}