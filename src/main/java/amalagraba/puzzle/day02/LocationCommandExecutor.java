package amalagraba.puzzle.day02;

import lombok.RequiredArgsConstructor;

import java.util.function.BiConsumer;

@RequiredArgsConstructor
public abstract class LocationCommandExecutor {

    public void execute(String command, Location location) {
        parseCommand(command).executeOn(location);
    }

    protected abstract BiConsumer<Location, Integer> mapAction(String action);

    protected Command parseCommand(String input) {
        String[] parts = input.split(" ");
        String action = parts[0].trim().toLowerCase();
        Integer amount = Integer.parseInt(parts[1].trim());
        BiConsumer<Location, Integer> function = mapAction(action);

        return location -> function.accept(location, amount);
    }

    @FunctionalInterface
    private interface Command {
        void executeOn(Location location);
    }
}
