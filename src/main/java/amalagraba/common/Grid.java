package amalagraba.common;

import com.google.common.collect.AbstractIterator;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Grid<T extends Point> extends AbstractCollection<T> implements Collection<T> {

    private static final MatrixFactory MATRIX_FACTORY = new MatrixFactory();

    private final Point[][] grid;

    public Grid(String[] lines, PointFactory<T> pointFactory) {
        this.grid = MATRIX_FACTORY.create(lines, pointFactory);
    }

    public List<T> getAllNeighbours(T point) {
        return Stream.of(getDiagonalNeighbours(point), getHorizontalAndVerticalNeighbours(point))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public List<T> getDiagonalNeighbours(T point) {
        return getNeighbours(
                pointAt(point.getX() + 1, point.getY() - 1),
                pointAt(point.getX() + 1, point.getY() + 1),
                pointAt(point.getX() - 1, point.getY() - 1),
                pointAt(point.getX() - 1, point.getY() + 1));
    }

    public List<T> getHorizontalAndVerticalNeighbours(T point) {
        return getNeighbours(
                pointAt(point.getX() + 1, point.getY()),
                pointAt(point.getX() - 1, point.getY()),
                pointAt(point.getX(), point.getY() + 1),
                pointAt(point.getX(), point.getY() - 1));
    }

    public int size() {
        if (grid.length == 0) {
            return 0;
        }
        return grid.length * grid[0].length;
    }

    @SafeVarargs
    private List<T> getNeighbours(Optional<T>... candidates) {
        return Arrays.stream(candidates).filter(Optional::isPresent).map(Optional::get).collect(Collectors.toList());
    }

    private Optional<T> pointAt(int x, int y) {
        return isOutOfTheGrid(x, y) ? Optional.empty() : Optional.of(cast(grid[x][y]));
    }

    private boolean isOutOfTheGrid(int x, int y) {
        return x < 0 || x >= grid.length || y < 0 || y >= grid[x].length;
    }

    @Override
    public Iterator<T> iterator() {
        return new AbstractIterator<>() {
            int x, y;

            @Override
            protected T computeNext() {
                if (y > 0 && y >= grid[x].length) {
                    y = 0;
                    x++;
                }
                if (x >= grid.length) {
                    endOfData();
                    return null;
                }
                return cast(grid[x][y++]);
            }
        };
    }

    @SuppressWarnings("unchecked")
    private T cast(Point point) {
        return (T) point;
    }
}
