package amalagraba.puzzle.day05;

import com.google.common.collect.AbstractIterator;

import java.util.Iterator;
import java.util.function.Function;

public class VentLine implements Iterable<Vent> {

    private final Vent from;
    private final Vent to;

    public VentLine(String line) {
        String[] points = line.split(" -> ");
        this.from = new Vent(points[0]);
        this.to = new Vent(points[1]);
    }

    public boolean isDiagonal() {
        return from.getX() != to.getX() && from.getY() != to.getY();
    }

    @Override
    public Iterator<Vent> iterator() {
        return new AbstractIterator<>() {
            private Vent last;

            @Override
            protected Vent computeNext() {
                if (last == null) {
                    last = from;
                } else if (last.equals(to)) {
                    endOfData();
                    last = null;
                } else {
                    last = new Vent(computeNextCoordinate(Vent::getX), computeNextCoordinate(Vent::getY));
                }
                return last;
            }

            private int computeNextCoordinate(Function<Vent, Integer> getter) {
                int current = getter.apply(last);
                int comparison = current - getter.apply(to);

                if (comparison > 0) {
                    return current - 1;
                }
                if (comparison < 0) {
                    return current + 1;
                }
                return current;
            }
        };
    }
}