package amalagraba.puzzle;

import amalagraba.PuzzleRunner;
import amalagraba.model.AbstractPuzzle;
import amalagraba.model.day02.Command;
import amalagraba.model.day02.CommandFactory;
import amalagraba.model.day02.Location;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.awt.Point;
import java.util.Arrays;
import java.util.List;

public class Day02 extends AbstractPuzzle {

    private final CommandFactory commandFactory = new CommandFactory();

    public static void main(String[] args) {
        PuzzleRunner.run(new Day02());
    }

    /**
     * Definition: https://adventofcode.com/2021/day/2
     */
    @Override
    public String solvePart1(String rawInput) {
        Location location = new Location();

        executeCommands(parseCommands(rawInput), location);

        return String.valueOf(location.getCoordinateProduct());
    }

    /**
     * Definition: https://adventofcode.com/2021/day/2#part2
     */
    @Override
    public String solvePart2(String rawInput) {
        return "0";
    }

    private void executeCommands(Command[] commands, Location location) {
        for (Command command : commands) {
            command.execute(location);
        }
    }

    private Command[] parseCommands(String rawInput) {
        return Arrays.stream(splitInputLines(rawInput))
                .map(commandFactory::createCommand)
                .toArray(Command[]::new);
    }
}
