package amalagraba.puzzle.day05;

import java.util.Arrays;

public class HydrothermalVentField {

    private static final int FIELD_SIZE = 1000;

    private final int[][] grid = new int[FIELD_SIZE][FIELD_SIZE];


    public void add(VentLine line) {
        for (Vent vent : line) {
            grid[vent.getX()][vent.getY()]++;
        }
    }

    public long countPointsWithMultipleVents() {
        return Arrays.stream(grid)
                .flatMapToInt(Arrays::stream)
                .filter(value -> value > 1)
                .count();
    }
}
