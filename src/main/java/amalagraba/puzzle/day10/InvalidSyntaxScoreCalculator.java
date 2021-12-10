package amalagraba.puzzle.day10;

import java.util.Arrays;
import java.util.Map;

public class InvalidSyntaxScoreCalculator extends SyntaxScoreCalculator {

    private static final Map<Character, Integer> SCORE_MAP = Map.of(
            ')', 3,
            ']', 57,
            '}', 1197,
            '>', 25137
    );

    @Override
    public long calculate(String[] lines) {
        return Arrays.stream(lines).mapToLong(this::getLineScore).sum();
    }

    private long getLineScore(String line) {
        return SCORE_MAP.getOrDefault(buildIncompleteStack(line).peek(), 0);
    }
}
