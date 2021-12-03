package amalagraba.puzzle.day02;

import java.util.function.BiConsumer;

public class AimedLocationCommandExecutor extends LocationCommandExecutor {

    @Override
    protected BiConsumer<Location, Integer> mapAction(String action) {
        return switch (action) {
            case "up" -> Location::decreaseAim;
            case "forward" -> Location::moveUsingAim;
            case "down" -> Location::increaseAim;
            default -> throw new IllegalArgumentException("Unknown action " + action);
        };
    }
}
