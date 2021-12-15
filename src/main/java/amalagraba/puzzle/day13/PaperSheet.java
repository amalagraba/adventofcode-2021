package amalagraba.puzzle.day13;

import amalagraba.common.grid.Point;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public record PaperSheet(Set<Point> points) {

    public void fold(Fold fold) {
        int value = fold.getValue();

        if (fold.isVertical()) {
            fold(value, Point::getX, point -> new Point(value - (point.getX() - value), point.getY()));
            return;
        }
        fold(value, Point::getY, point -> new Point(point.getX(), value - (point.getY() - value)));
    }

    public String print() {
        StringBuilder builder = new StringBuilder();
        int maxX = points.stream().mapToInt(Point::getX).max().orElse(0);
        int maxY = points.stream().mapToInt(Point::getY).max().orElse(0);

        IntStream.range(0, maxY + 1).forEach(y -> {
            IntStream.range(0, maxX + 1).forEach(x -> {
                builder.append(points.contains(new Point(x, y)) ? "#" : " ");
            });
            builder.append("\n");
        });
        return builder.toString();
    }

    private void fold(int value, Function<Point, Integer> getter, Function<Point, Point> mapper) {
        Set<Point> affectedPoints = points.stream()
                .filter(point -> getter.apply(point) >= value)
                .collect(Collectors.toSet());

        affectedPoints.forEach(point -> {
            points.remove(point);
            points.add(mapper.apply(point));
        });
    }
}
