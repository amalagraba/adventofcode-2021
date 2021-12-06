package amalagraba.puzzle.day05;

import com.google.common.collect.AbstractIterator;

import java.util.Iterator;

public class Line implements Iterable<Point> {

    private final Point from;
    private final Point to;

    public Line(String line) {
        String[] points = line.split(" -> ");
        this.from = new Point(points[0]);
        this.to = new Point(points[1]);
    }

    public boolean isHorizontalOrVertical() {
        return from.getX() == to.getX() || from.getY() == to.getY();
    }

    @Override
    public Iterator<Point> iterator() {
        return new AbstractIterator<>() {
            private final Point increment = new Point(
                    (long) Math.signum(to.getX() - from.getX()),
                    (long) Math.signum(to.getY() - from.getY()));

            private Point last;

            @Override
            protected Point computeNext() {
                if (last == null) {
                    last = from;
                } else if (last.equals(to)) {
                    endOfData();
                    last = null;
                } else {
                    last = last.plus(increment);
                }
                return last;
            }
        };
    }
}