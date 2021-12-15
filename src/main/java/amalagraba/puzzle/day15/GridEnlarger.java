package amalagraba.puzzle.day15;

import amalagraba.common.grid.Grid;
import amalagraba.common.grid.IntPoint;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.function.Function;

@AllArgsConstructor
public class GridEnlarger implements Function<Grid<IntPoint>, Grid<IntPoint>> {

    private final int times;

    @Override
    public Grid<IntPoint> apply(Grid<IntPoint> grid) {
        Grid<IntPoint> enlarged = new Grid<>(grid.rows() * times, grid.columns() * times);

        for (IntPoint point : grid) {
            map(grid, point).forEach(enlarged::set);
        }
        return enlarged;
    }

    private List<IntPoint> map(Grid<IntPoint> grid, IntPoint point) {
        List<IntPoint> points = Lists.newArrayList();

        for (int y = 0; y < times; y++) {
            for (int x = 0; x < times; x++) {
                points.add(mapPoint(point, grid, x, y));
            }
        }
        return points;
    }

    private IntPoint mapPoint(IntPoint point, Grid<IntPoint> grid, int x, int y) {
        return new IntPoint(
                point.getX() + x * grid.columns(),
                point.getY() + y * grid.rows(),
                mapValue(point.getValue(), x + y));
    }

    private int mapValue(int originalValue, int distance) {
        int result = originalValue + distance;

        return result >= 10 ? result - 9 : result;
    }
}
