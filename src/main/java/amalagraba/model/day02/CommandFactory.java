package amalagraba.model.day02;

import java.util.Map;
import java.util.function.BiConsumer;

public class CommandFactory {

    private static final Map<String, BiConsumer<Location, Integer>> COMMANDS = Map.of(
            "up", Location::decreaseDepth,
            "forward", Location::moveForward,
            "down", Location::increaseDepth
    );

    private static final Map<String, BiConsumer<Location, Integer>> AIMED_COMMANDS = Map.of(
            "up", Location::decreaseAim,
            "forward", Location::moveUsingAim,
            "down", Location::increaseAim
    );

    public Command createCommand(String input) {
        return createCommandFromMap(input, COMMANDS);
    }

    public Command createAimedCommand(String input) {
        return createCommandFromMap(input, AIMED_COMMANDS);
    }

    private Command createCommandFromMap(String input, Map<String, BiConsumer<Location, Integer>> functionMap) {
        String[] parts = input.split(" ");
        String action = parts[0].trim().toLowerCase();
        Integer amount = Integer.parseInt(parts[1].trim());
        BiConsumer<Location, Integer> function = functionMap.get(action);

        return location -> function.accept(location, amount);
    }
}
