package amalagraba.model.day02;

import java.util.Map;
import java.util.function.Function;

public class CommandFactory {

    private static final Map<String, Function<Integer, Command>> COMMANDS = Map.of(
            "up", UpCommand::new,
            "forward", ForwardCommand::new,
            "down", DownCommand::new
    );

    public Command createCommand(String input) {
        String[] parts = input.split(" ");

        return COMMANDS.get(parts[0].trim().toLowerCase()).apply(Integer.parseInt(parts[1].trim()));
    }
}
