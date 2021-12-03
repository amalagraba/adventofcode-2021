package amalagraba.puzzle.day02;

import java.util.function.BiConsumer;

public class SimpleLocationCommandExecutor extends LocationCommandExecutor {

    @Override
    protected BiConsumer<Location, Integer> mapAction(String action) {
        return switch (action) {
            case "up" -> Location::decreaseDepth;
            case "forward" -> Location::moveForward;
            case "down" -> Location::increaseDepth;
            default -> throw new IllegalArgumentException("Unknown action " + action);
        };
    }
}
