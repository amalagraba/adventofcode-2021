package amalagraba.puzzle;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day02Test {

    private final Day02 puzzle = new Day02();

    @Test
    public void input_file_name_must_be_day02_txt() {
        assertEquals("day02.txt", puzzle.inputFileName());
    }
}