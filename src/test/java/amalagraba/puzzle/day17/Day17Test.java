package amalagraba.puzzle.day17;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day17Test {

    private final Day17 puzzle = new Day17();

    @Test
    public void input_file_name_must_be_day17_txt() {
        assertEquals("day17.txt", puzzle.inputFileName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_input_is_empty_solvePart1_throws_exception() {
        puzzle.solvePart1("");
    }

    @Test
    public void when_target_area_20_30_to__10__5_solvePart1_result_is_45() {
        String input = "target area: x=20..30, y=-10..-5";

        String result = puzzle.solvePart1(input);

        assertEquals("45", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_input_is_empty_solvePart2_throws_exception() {
        puzzle.solvePart2("");
    }

    @Test
    public void when_target_area_20_30_to__10__5_solvePart2_result_is_112() {
        String input = "target area: x=20..30, y=-10..-5";

        String result = puzzle.solvePart2(input);

        assertEquals("112", result);
    }
}