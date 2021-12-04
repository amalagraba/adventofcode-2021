package amalagraba.puzzle.day04;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day04Test {

    private final Day04 puzzle = new Day04();

    @Test
    public void input_file_name_must_be_day04_txt() {
        assertEquals("day04.txt", puzzle.inputFileName());
    }

    @Test
    public void when_input_is_empty_solvePart1_result_is_0() {
        String input = "";

        String result = puzzle.solvePart1(input);

        assertEquals("0", result);
    }

    @Test
    public void when_there_is_no_winner_solvePart1_result_is_0() {
        String input = """
                12,20,4,5,54
                                
                12 20  4  5  2
                11 19  3 16  1
                10  7 17  6 13
                 9 14 15 21 22
                 8 18 24 23 25
                """;

        String result = puzzle.solvePart1(input);

        assertEquals("0", result);
    }

    @Test
    public void when_input_has_winning_row_board_with_2_solvePart1_result_is_2_multiplied_by_sum_of_unselected_numbers() {
        String input = """
                12,20,4,5,2
                                
                12 20  4  5  2
                11 19  3 16  1
                10  7 17  6 13
                 9 14 15 21 22
                 8 18 24 23 25
                """;

        String result = puzzle.solvePart1(input);

        assertEquals("564", result);
    }

    @Test
    public void when_input_has_winning_column_board_with_2_solvePart1_result_is_2_multiplied_by_sum_of_unselected_numbers() {
        String input = """
                12,20,4,5,2
                                
                12 11 10  9  8
                20 19  3 16  1
                 4  7 17  6 13
                 5 14 15 21 22
                 2 18 24 23 25
                 
                50 11 10  9  8
                20 19  3 16  1
                 4  7 17  6 13
                 5 14 15 21 22
                 2 18 24 23 25
                """;

        String result = puzzle.solvePart1(input);

        assertEquals("564", result);
    }

    @Test
    public void when_input_is_empty_solvePart2_result_is_0() {
        String input = "";

        String result = puzzle.solvePart2(input);

        assertEquals("0", result);
    }

    @Test
    public void when_input_has_winning_row_board_with_2_solvePart2_result_is_2_multiplied_by_sum_of_unselected_numbers() {
        String input = """
                12,20,4,5,2
                                
                12 20  4  5  2
                11 19  3 16  1
                10  7 17  6 13
                 9 14 15 21 22
                 8 18 24 23 25
                """;

        String result = puzzle.solvePart2(input);

        assertEquals("564", result);
    }

    @Test
    public void when_input_has_more_than_one_board_solvePart2_result_is_last_winner_score() {
        String input = """
                12,20,4,5,2,50
                                
                12 11 10  9  8
                20 19  3 16  1
                 4  7 17  6 13
                 5 14 15 21 22
                 2 18 24 23 25
                 
                50 11 10  9  8
                20 19  3 16  1
                 4  7 17  6 13
                 5 14 15 21 22
                 2 18 24 23 25
                """;

        String result = puzzle.solvePart2(input);

        assertEquals("14100", result);
    }
}