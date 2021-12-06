package amalagraba.puzzle.day05;

import org.apache.commons.lang3.mutable.MutableInt;

import java.util.HashMap;
import java.util.Map;

public class HydrothermalVentField {

    private final Map<Point, MutableInt> field = new HashMap<>();


    public void add(Line line) {
        for (Point point : line) {
            field.computeIfAbsent(point, k -> new MutableInt()).increment();
        }
    }

    public long countPointsWithMultipleVents() {
        return field.values().stream()
                .mapToInt(MutableInt::intValue)
                .filter(value -> value > 1)
                .count();
    }
}
