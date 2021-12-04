package amalagraba.puzzle.day04;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

public class LastWinnerBingo extends Bingo {

    protected Optional<BingoBoard> drawNumber(Integer number) {
        List<BingoBoard> pendingBoards = boards.stream()
                .filter(not(BingoBoard::isCompleted))
                .collect(Collectors.toList());

        return drawNumber(number, pendingBoards);
    }

    private Optional<BingoBoard> drawNumber(Integer number, List<BingoBoard> boards) {
        List<BingoBoard> winners = boards.stream()
                .filter(board -> board.addNumber(number))
                .collect(Collectors.toList());

        return pickWinner(boards, winners);
    }

    private Optional<BingoBoard> pickWinner(List<BingoBoard> boards, List<BingoBoard> winners) {
        if (winners.size() == boards.size()) {
            return Optional.of(winners.get(winners.size() - 1));
        }
        return Optional.empty();
    }
}
