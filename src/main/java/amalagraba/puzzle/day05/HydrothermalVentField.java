package amalagraba.puzzle.day05;

import amalagraba.common.Line;
import amalagraba.common.grid.Point;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

@RequiredArgsConstructor
public class HydrothermalVentField {

    private final Predicate<Line> filter;
    private final List<Line> lines = new ArrayList<>();


    public void addLine(String rawLine) {
        addLine(parseLine(rawLine));
    }

    public long countPointsWithMultipleVents() {
        Bag<Point> bag = getAllPoints();

        return bag.uniqueSet().stream()
                .filter(point -> bag.getCount(point) > 1)
                .count();
    }

    private Bag<Point> getAllPoints() {
        return lines.stream()
                .flatMap(Collection::stream)
                .collect(HashBag::new, Bag::add, Bag::addAll);
    }

    private void addLine(Line line) {
        if (filter.test(line)) {
            lines.add(line);
        }
    }

    private Line parseLine(String rawLine) {
        String[] points = rawLine.split(" -> ");

        return new Line(new Point(points[0]), new Point(points[1]));
    }
}
