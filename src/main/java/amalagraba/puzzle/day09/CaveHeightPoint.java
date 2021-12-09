package amalagraba.puzzle.day09;

import java.util.List;

public record CaveHeightPoint(int x, int y, int height) {

    public boolean isHigherThan(CaveHeightPoint point) {
        return height > point.height();
    }

    public boolean isLowerThanAll(List<CaveHeightPoint> points) {
        return points.stream().allMatch(point -> point.isHigherThan(this));
    }
}
