package amalagraba.common;

@FunctionalInterface
public interface PointFactory<T extends Point> {

    T create(int x, int y, char value);
}
