package amalagraba.puzzle.day09;

import amalagraba.common.Grid;
import amalagraba.common.IntPoint;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

public class CaveTopographyMapper {

    public static final int BASIN_HEIGHT_THRESHOLD = 9;

    private final Grid<IntPoint> heights;

    public CaveTopographyMapper(String[] heights) {
        this.heights = new Grid<>(heights, IntPoint::new);
    }

    public List<IntPoint> findLowPoints() {
        return heights.stream().filter(this::isLowPoint).collect(Collectors.toList());
    }

    private boolean isLowPoint(IntPoint point) {
        return point.isLowerThanAll(heights.getHorizontalAndVerticalNeighbours(point));
    }

    public List<Set<IntPoint>> findBasins() {
        return findLowPoints().stream().map(this::expandToBasin).collect(Collectors.toList());
    }

    private Set<IntPoint> expandToBasin(IntPoint seed) {
        Set<IntPoint> basinPoints = Sets.newHashSet(seed);
        List<IntPoint> points = List.of(seed);

        do {
            points = points.stream()
                    .flatMap(this::getHigherNeighbours)
                    .filter(not(basinPoints::contains))
                    .filter(point -> point.getValue() < BASIN_HEIGHT_THRESHOLD)
                    .collect(Collectors.toList());
        } while (basinPoints.addAll(points));

        return basinPoints;
    }

    private Stream<IntPoint> getHigherNeighbours(IntPoint point) {
        return heights.getHorizontalAndVerticalNeighbours(point).stream()
                .filter(neighbour -> neighbour.isHigherThan(point));
    }
}
