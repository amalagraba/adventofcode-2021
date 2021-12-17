package amalagraba.puzzle.day17;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class ProbeTrajectoryCalculator {

    public static final int MAX_Y_VELOCITY = 300;

    private final TargetArea area;

    public List<Integer> getHighestPoints() {
        List<Integer> highestPoints = new ArrayList<>();

        for (int yVelocity = area.getMinY(); yVelocity < MAX_Y_VELOCITY; yVelocity++) {
            addHighestPoints(highestPoints, yVelocity);
        }
        return highestPoints;
    }

    private void addHighestPoints(List<Integer> highestPoints, int yVelocity) {
        // This assumes the target area is on the right hand
        for (int xVelocity = minXVelocity(area.getMinX()); ; xVelocity++) {
            Optional<Integer> highestPoint = getHighestPoint(new Probe(xVelocity, yVelocity), area);

            if (highestPoint.isPresent()) {
                highestPoints.add(highestPoint.get());
            } else if (xVelocity > area.getMaxX()) {
                break;
            }
        }
    }

    private Optional<Integer> getHighestPoint(Probe probe, TargetArea area) {
        while (probe.canReach(area)) {
            probe.update();

            if (area.contains(probe.getPosition())) {
                return Optional.of(probe.getMaxY());
            }
        }
        return Optional.empty();
    }

    private int minXVelocity(int minX) {
        return (int) Math.round((Math.sqrt(8 * minX) - 1) / 2);
    }
}
