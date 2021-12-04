package amalagraba.puzzle.day04;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Bingo {

    private static final int BOARD_SIZE = 5;

    protected final List<BingoBoard> boards = new ArrayList<>();

    public Optional<BingoBoard> play(String[] input) {
        if (input.length == 0) {
            return Optional.empty();
        }
        createBoards(input);

        return play(parseNumbers(input[0], ","));
    }

    protected Optional<BingoBoard> play(Integer[] numbers) {
        for (Integer number : numbers) {
            Optional<BingoBoard> winner = drawNumber(number);

            if (winner.isPresent()) {
                return winner;
            }
        }
        return Optional.empty();
    }

    protected Optional<BingoBoard> drawNumber(Integer number) {
        for (BingoBoard board : boards) {
            if (board.addNumber(number)) {
                return Optional.of(board);
            }
        }
        return Optional.empty();
    }

    private void createBoards(String[] input) {
        int from = 2;

        while (from + BOARD_SIZE - 1 < input.length) {
            createBoard(Arrays.copyOfRange(input, from, from += BOARD_SIZE));
            from++;
        }
    }

    private void createBoard(String[] input) {
        BingoBoard bingoBoard = new BingoBoard();

        Arrays.stream(input)
                .map(StringUtils::normalizeSpace)
                .forEach(row -> bingoBoard.addRow(parseNumbers(row, " ")));

        boards.add(bingoBoard);
    }

    private Integer[] parseNumbers(String input, String separator) {
        return Arrays.stream(input.split(separator))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }
}
