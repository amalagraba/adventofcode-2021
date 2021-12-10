package amalagraba.puzzle.day10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

public class IncompleteLineScoreCalculator extends SyntaxScoreCalculator {

    private static final int SCORE_MULTIPLIER = 5;
    private static final Map<Character, Integer> SCORE_MAP = Map.of(
            ')', 1,
            ']', 2,
            '}', 3,
            '>', 4
    );

    @Override
    public long calculate(String[] lines) {
        List<Long> sortedScores = Arrays.stream(lines)
                .map(this::buildIncompleteStack)
                .filter(not(this::isInvalid))
                .map(this::calculateStackScore)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        return sortedScores.isEmpty() ? 0 : sortedScores.get(sortedScores.size() / 2);
    }

    private boolean isInvalid(Stack<Character> stack) {
        return isCloseSymbol(stack.peek());
    }

    private long calculateStackScore(Stack<Character> characters) {
        long score = 0;

        while (!characters.isEmpty()) {
            score = score * SCORE_MULTIPLIER + SCORE_MAP.get(getCloseSymbol(characters.pop()));
        }
        return score;
    }
}
