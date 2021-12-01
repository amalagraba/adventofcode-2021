package amalagraba.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public abstract class AbstractPuzzle implements Puzzle {

    protected Integer[] parseInputToIntArray(String input) {
        return Arrays.stream(splitInputLines(input)).map(Integer::parseInt).toArray(Integer[]::new);
    }

    protected String[] splitInputLines(String input) {
        if (StringUtils.isBlank(input)) {
            return new String[0];
        }
        return input.trim().split("\\r?\\n");
    }
}
