package amalagraba.puzzle.day11;

import amalagraba.common.grid.IntPoint;

import java.util.List;
import java.util.function.Supplier;

public class Octopus extends IntPoint {

    private static final int FLASH_THRESHOLD = 9;

    public Octopus(int x, int y, char value) {
        super(x, y, value);
    }

    public boolean isFlashy() {
        return value > FLASH_THRESHOLD;
    }

    public boolean flash(Supplier<List<Octopus>> neighbours) {
        if (isFlashy()) {
            neighbours.get().forEach(Octopus::increaseValue);
            return true;
        }
        return false;
    }

    public void reset() {
        value = 0;
    }
}
