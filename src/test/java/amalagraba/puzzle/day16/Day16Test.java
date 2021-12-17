package amalagraba.puzzle.day16;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day16Test {

    private final Day16 puzzle = new Day16();

    @Test
    public void input_file_name_must_be_day16_txt() {
        assertEquals("day16.txt", puzzle.inputFileName());
    }

    @Test
    public void when_input_is_empty_solvePart1_result_is_0() {
        String input = "";

        String result = puzzle.solvePart1(input);

        assertEquals("0", result);
    }

    @Test
    public void when_input_has_3_packets_with_versions_1_6_and_2_solvePart1_result_is_9() {
        String input = "38006F45291200";

        String result = puzzle.solvePart1(input);

        assertEquals("9", result);
    }

    @Test
    public void when_input_has_sum_of_1_and_2_solvePart2_result_is_3() {
        String input = "C200B40A82";

        String result = puzzle.solvePart2(input);

        assertEquals("3", result);
    }

    @Test
    public void when_input_has_product_of_6_and_9_solvePart2_result_is_54() {
        String input = "04005AC33890";

        String result = puzzle.solvePart2(input);

        assertEquals("54", result);
    }

    @Test
    public void when_input_has_min_of_7_8_and_9_solvePart2_result_is_7() {
        String input = "880086C3E88112";

        String result = puzzle.solvePart2(input);

        assertEquals("7", result);
    }

    @Test
    public void when_input_has_max_of_7_8_and_9_solvePart2_result_is_9() {
        String input = "CE00C43D881120";

        String result = puzzle.solvePart2(input);

        assertEquals("9", result);
    }

    @Test
    public void when_input_has_lt_of_5_and_15_solvePart2_result_is_1() {
        String input = "D8005AC2A8F0";

        String result = puzzle.solvePart2(input);

        assertEquals("1", result);
    }

    @Test
    public void when_input_has_gt_of_5_and_15_solvePart2_result_is_0() {
        String input = "F600BC2D8F";

        String result = puzzle.solvePart2(input);

        assertEquals("0", result);
    }

    @Test
    public void when_input_has_eq_of_5_and_15_solvePart2_result_is_9() {
        String input = "9C005AC2F8F0";

        String result = puzzle.solvePart2(input);

        assertEquals("0", result);
    }

    @Test
    public void when_input_is_empty_solvePart2_result_is_0() {
        String input = "";

        String result = puzzle.solvePart2(input);

        assertEquals("0", result);
    }
}