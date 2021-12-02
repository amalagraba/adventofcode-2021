package amalagraba.model.day02;

@FunctionalInterface
public interface Command {

    void executeOn(Location location);
}