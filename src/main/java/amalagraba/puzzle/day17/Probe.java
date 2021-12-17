package amalagraba.puzzle.day17;

import amalagraba.common.grid.Point;
import lombok.Getter;

public class Probe {

    private int xVelocity;
    private int yVelocity;
    @Getter
    private Point position;
    @Getter
    private int maxY;

    public Probe(int xVelocity, int yVelocity) {
        this.position = new Point(0, 0);
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
    }

    public void update() {
        updatePosition();
        updateMaxY();
        updateXVelocity();
        updateYVelocity();
    }

    private void updateXVelocity() {
        if (xVelocity != 0) {
            xVelocity += xVelocity < 0 ? 1 : -1;
        }
    }

    private void updateYVelocity() {
        yVelocity--;
    }

    private void updateMaxY() {
        maxY = Math.max(maxY, position.getY());
    }

    private void updatePosition() {
        position = new Point(position.getX() + xVelocity, position.getY() + yVelocity);
    }

    public boolean canReach(TargetArea area) {
        return area.getFrom().getY() < position.getY()
                || area.getTo().getY() < position.getY();
    }
}
