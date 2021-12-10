package amalagraba.puzzle.day10;

import java.util.Arrays;
import java.util.Map;

public class InvalidSyntaxAnalyzer extends SyntaxAnalyzer {

    private static final Map<Character, Integer> SCORE_MAP = Map.of(
            ')', 3,
            ']', 57,
            '}', 1197,
            '>', 25137
    );

    @Override
    public long calculateScore(String[] lines) {
        return Arrays.stream(lines)
                .map(this::analyze)
                .filter(SyntaxAnalysisResult::isInvalidLine)
                .map(SyntaxAnalysisResult::invalidSymbol)
                .mapToLong(this::calculateScore)
                .sum();
    }

    private int calculateScore(Character character) {
        return SCORE_MAP.getOrDefault(character, 0);
    }
}
