package amalagraba.puzzle.day12;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day12Test {

    private final Day12 puzzle = new Day12();

    @Test
    public void input_file_name_must_be_day12_txt() {
        assertEquals("day12.txt", puzzle.inputFileName());
    }

    @Test
    public void when_input_is_empty_solvePart1_result_is_0() {
        String input = "";

        String result = puzzle.solvePart1(input);

        assertEquals("0", result);
    }

    @Test
    public void when_input_has_10_unique_paths_solvePart1_result_is_10() {
        String input = """
                start-A
                start-b
                A-c
                A-b
                b-d
                A-end
                b-end
                """;

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
    public void when_input_has_36_paths_allowing_duplicates_solvePart2_result_is_36() {
        String input = """
                start-A
                start-b
                A-c
                A-b
                b-d
                A-end
                b-end
                """;

        String result = puzzle.solvePart2(input);

        assertEquals("36", result);
    }
}