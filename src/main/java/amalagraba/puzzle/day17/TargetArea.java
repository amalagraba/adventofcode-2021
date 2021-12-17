package amalagraba.puzzle.day17;

import amalagraba.common.grid.Point;
import lombok.Getter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TargetArea {

    private static final Pattern PATTERN = Pattern.compile("^target area: x=(-?\\d+)\\.\\.(-?\\d+), y=(-?\\d+)\\.\\.(-?\\d+)$");

    @Getter
    private final Point from;
    @Getter
    private final Point to;

    public TargetArea(String value) {
        Matcher matcher = PATTERN.matcher(value);

        if (!matcher.find()) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.from = new Point(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(3)));
        this.to = new Point(Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(4)));
    }

    public boolean contains(Point point) {
        return isBetween(point.getX(), from.getX(), to.getX())
                && isBetween(point.getY(), from.getY(), to.getY());
    }

    private boolean isBetween(int value, int bottom, int top) {
        return value >= bottom && value <= top;
    }

    public int getMaxX() {
        return Math.max(from.getX(), to.getX());
    }

    public int getMinX() {
        return Math.min(from.getX(), to.getX());
    }

    public int getMinY() {
        return Math.min(from.getY(), to.getY());
    }
}
