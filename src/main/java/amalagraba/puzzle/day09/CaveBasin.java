package amalagraba.puzzle.day09;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CaveBasin {

    private final Set<CaveHeightPoint> points = new HashSet<>();


    public void addPoints(Collection<CaveHeightPoint> points) {
        this.points.addAll(points);
    }

    public int size() {
        return points.size();
    }

    public boolean contains(CaveHeightPoint point) {
        return points.contains(point);
    }
}
