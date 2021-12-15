package amalagraba.puzzle.day15;

import org.junit.Test;

import static amalagraba.input.TestInput.stringInput;
import static org.junit.Assert.assertEquals;

public class Day15Test {

    private final Day15 puzzle = new Day15();

    @Test
    public void input_file_name_must_be_day15_txt() {
        assertEquals("day15.txt", puzzle.inputFileName());
    }

    @Test
    public void when_input_is_empty_solvePart1_result_is_0() {
        String input = "";

        String result = puzzle.solvePart1(input);

        assertEquals("0", result);
    }

    @Test
    public void when_lowest_risk_path_sums_40_solvePart1_result_is_40() {
        String input = """
                1163751742
                1381373672
                2136511328
                3694931569
                7463417111
                1319128137
                1359912421
                3125421639
                1293138521
                2311944581
                """;

        String result = puzzle.solvePart1(input);

        assertEquals("40", result);
    }

    @Test
    public void when_input_is_empty_solvePart2_result_is_0() {
        String input = "";

        String result = puzzle.solvePart2(input);

        assertEquals("0", result);
    }

    @Test
    public void when_enlarged_map_lowest_risk_path_sums_315_solvePart2_result_is_315() {
        String input = """
                1163751742
                1381373672
                2136511328
                3694931569
                7463417111
                1319128137
                1359912421
                3125421639
                1293138521
                2311944581
                """;

        String result = puzzle.solvePart2(input);

        assertEquals("315", result);
    }
}