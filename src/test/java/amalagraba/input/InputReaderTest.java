package amalagraba.input;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class InputReaderTest {

    private final InputReader inputReader = new InputReader();

    @Test(expected = IllegalArgumentException.class)
    public void given_an_invalid_file_name_throws_exception() {
        inputReader.read("test");
    }

    @Test
    public void given_a_valid_filename_retrieves_its_content() {
        String expected = "some\r\nrandom\r\ntext";

        String text = inputReader.read("file.txt");

        assertEquals(expected, text);
    }
}
