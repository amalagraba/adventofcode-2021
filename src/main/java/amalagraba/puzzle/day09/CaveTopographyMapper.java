package amalagraba.puzzle.day09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

public class CaveTopographyMapper {

    private final char[][] heights;

    public CaveTopographyMapper(String[] heights) {
        this.heights = Arrays.stream(heights).map(String::toCharArray).toArray(char[][]::new);
    }

    public List<CaveHeightPoint> findLowPoints() {
        List<CaveHeightPoint> lowPoints = new ArrayList<>();

        for (int row = 0; row < heights.length; row++) {
            addRowLowPoints(lowPoints, row);
        }
        return lowPoints;
    }

    public List<CaveBasin> findBasins() {
        return findLowPoints().stream().map(this::expandToBasin).collect(Collectors.toList());
    }

    private CaveBasin expandToBasin(CaveHeightPoint seed) {
        CaveBasin basin = new CaveBasin();
        List<CaveHeightPoint> points = List.of(seed);

        while (!points.isEmpty()) {
            basin.addPoints(points);
            points = points.stream()
                    .flatMap(this::getHigherNeighbours)
                    .filter(not(basin::contains))
                    .filter(point -> point.height() < 9)
                    .collect(Collectors.toList());
        }
        return basin;
    }

    private Stream<CaveHeightPoint> getHigherNeighbours(CaveHeightPoint point) {
        return getNeighbours(point).stream().filter(neighbour -> neighbour.isHigherThan(point));
    }

    private void addRowLowPoints(List<CaveHeightPoint> lowPoints, int row) {
        for (int column = 0; column < heights[row].length; column++) {
            CaveHeightPoint point = createPoint(row, column);

            if (point.isLowerThanAll(getNeighbours(point))) {
                lowPoints.add(point);
            }
        }
    }

    private List<CaveHeightPoint> getNeighbours(CaveHeightPoint point) {
        Stream<Optional<CaveHeightPoint>> candidates = Stream.of(
                pointAt(point.x() + 1, point.y()),
                pointAt(point.x() - 1, point.y()),
                pointAt(point.x(), point.y() + 1),
                pointAt(point.x(), point.y() - 1));

        return candidates.filter(Optional::isPresent).map(Optional::get).collect(Collectors.toList());
    }

    private Optional<CaveHeightPoint> pointAt(int row, int column) {
        return isOutOfTheGrid(row, column) ? Optional.empty() : Optional.of(createPoint(row, column));
    }

    private boolean isOutOfTheGrid(int row, int column) {
        return row < 0 || row >= heights.length || column < 0 || column >= heights[row].length;
    }

    private CaveHeightPoint createPoint(int row, int column) {
        return new CaveHeightPoint(row, column, Character.getNumericValue(heights[row][column]));
    }
}
