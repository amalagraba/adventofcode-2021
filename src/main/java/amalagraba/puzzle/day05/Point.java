package amalagraba.puzzle.day05;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Point {

    private final long x;
    private final long y;

    public Point(String point) {
        String[] coordinates = point.split(",");
        this.x = Integer.parseInt(coordinates[0]);
        this.y = Integer.parseInt(coordinates[1]);
    }

    public Point plus(Point point) {
        return new Point(x + point.getX(), y + point.getY());
    }
}