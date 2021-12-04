package amalagraba.puzzle.day04;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

public class BingoBoard {

    private final List<BoardNumber> numbers = new ArrayList<>();

    private int lastNumber;
    private int rows;

    public void addRow(Integer[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            this.numbers.add(new BoardNumber(numbers[i], i, rows));
        }
        rows++;
    }

    public int getFinalScore() {
        return sumNonMatches() * lastNumber;
    }

    public boolean addNumber(int number) {
        setLastNumber(number);
        matchBoardNumber(number);

        return isCompleted();
    }

    public boolean isCompleted() {
        return isCompleted(BoardNumber::getX) || isCompleted(BoardNumber::getY);
    }

    private void matchBoardNumber(int number) {
        numbers.stream()
                .filter(boardNumber -> boardNumber.getValue() == number)
                .findFirst()
                .ifPresent(BoardNumber::match);
    }

    private void setLastNumber(int number) {
        lastNumber = number;
    }

    private boolean isCompleted(Function<BoardNumber, Integer> grouper) {
        return numbers.stream()
                .filter(BoardNumber::isMatch)
                .collect(Collectors.groupingBy(grouper))
                .values()
                .stream()
                .anyMatch(matches -> matches.size() == rows);
    }

    private int sumNonMatches() {
        return numbers.stream().filter(not(BoardNumber::isMatch)).mapToInt(BoardNumber::getValue).sum();
    }

    @Data
    private static class BoardNumber {
        private final int value;
        private final int x;
        private final int y;
        private boolean match;

        public void match() {
            this.match = true;
        }
    }
}
