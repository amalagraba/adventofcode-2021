package amalagraba.common;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Point {

    protected final int x;
    protected final int y;


    public Point plus(Point point) {
        return new Point(x + point.getX(), y + point.getY());
    }
}