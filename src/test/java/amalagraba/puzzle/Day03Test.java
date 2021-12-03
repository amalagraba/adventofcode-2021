package amalagraba.puzzle;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day03Test {

    private final Day03 puzzle = new Day03();

    @Test
    public void input_file_name_must_be_day03_txt() {
        assertEquals("day03.txt", puzzle.inputFileName());
    }

}