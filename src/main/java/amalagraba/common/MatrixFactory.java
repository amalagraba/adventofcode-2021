package amalagraba.common;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class MatrixFactory {

    public <T extends Point> Point[][] create(String[] lines, PointFactory<T> pointFactory) {
        if (ArrayUtils.isEmpty(lines) || StringUtils.isEmpty(lines[0])) {
            return new Point[0][0];
        }
        Point[][] grid = new Point[lines.length][lines[0].length()];

        for (int x = 0; x < lines.length; x++) {
            grid[x] = createRow(lines[x], pointFactory, x);
        }
        return grid;
    }

    private <T extends Point> Point[] createRow(String line, PointFactory<T> factory, int x) {
        Point[] row = new Point[line.length()];

        for (int y = 0; y < line.length(); y++) {
            row[y] = factory.create(x, y, line.charAt(y));
        }
        return row;
    }
}
