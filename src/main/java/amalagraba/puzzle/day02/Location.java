package amalagraba.puzzle.day02;

public class Location {

    private int horizontal;
    private int depth;
    private int aim;

    public int getCoordinateProduct() {
        return horizontal * depth;
    }

    public void moveForward(int amount) {
        this.horizontal += amount;
    }

    public void increaseDepth(int amount) {
        this.depth += amount;
    }

    public void decreaseDepth(int amount) {
        this.depth -= amount;
    }

    public void increaseAim(int amount) {
        this.aim += amount;
    }

    public void decreaseAim(int amount) {
        this.aim -= amount;
    }

    public void moveUsingAim(int amount) {
        moveForward(amount);
        increaseDepthUsingAim(amount);
    }

    private void increaseDepthUsingAim(int amount) {
        this.depth += (aim * amount);
    }
}