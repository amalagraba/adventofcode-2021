package amalagraba.puzzle.day13;

import lombok.Data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class Fold {

    private static final Pattern FOLD_REGEX = Pattern.compile("^fold along ([xy])=(\\d+)$");

    private final String axis;
    private final int value;

    public Fold(String text) {
        Matcher matcher = FOLD_REGEX.matcher(text);

        if (!matcher.find()) {
            throw new IllegalArgumentException("Invalid fold value");
        }
        axis = matcher.group(1);
        value = Integer.parseInt(matcher.group(2));
    }

    public static boolean isFold(String text) {
        return FOLD_REGEX.matcher(text).matches();
    }

    public boolean isVertical() {
        return "x".equals(axis);
    }
}