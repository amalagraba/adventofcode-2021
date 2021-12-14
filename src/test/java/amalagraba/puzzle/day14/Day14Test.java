package amalagraba.puzzle.day14;

import org.junit.Test;

import static amalagraba.input.TestInput.stringInput;
import static org.junit.Assert.assertEquals;

public class Day14Test {

    private final Day14 puzzle = new Day14();

    @Test
    public void input_file_name_must_be_day14_txt() {
        assertEquals("day14.txt", puzzle.inputFileName());
    }

    @Test
    public void when_input_is_empty_solvePart1_result_is_0() {
        String input = "";

        String result = puzzle.solvePart1(input);

        assertEquals("0", result);
    }

    @Test
    public void when_10_iterations_produce_a_score_of_1588_solvePart1_result_is_1588() {
        String input = stringInput("NNCB", "", "CH -> B", "HH -> N", "CB -> H", "NH -> C", "HB -> C", "HC -> B", "HN -> C",
                "NN -> C", "BH -> H", "NC -> B", "NB -> B", "BN -> B", "BB -> N", "BC -> B", "CC -> N", "CN -> C");

        String result = puzzle.solvePart1(input);

        assertEquals("1588", result);
    }

    @Test
    public void when_input_is_empty_solvePart2_result_is_0() {
        String input = "";

        String result = puzzle.solvePart2(input);

        assertEquals("0", result);
    }

    @Test
    public void when_40_iterations_produce_a_score_of_2188189693529_solvePart2_result_is_2188189693529() {
        String input = stringInput("NNCB", "", "CH -> B", "HH -> N", "CB -> H", "NH -> C", "HB -> C", "HC -> B", "HN -> C",
                "NN -> C", "BH -> H", "NC -> B", "NB -> B", "BN -> B", "BB -> N", "BC -> B", "CC -> N", "CN -> C");

        String result = puzzle.solvePart2(input);

        assertEquals("2188189693529", result);
    }
}