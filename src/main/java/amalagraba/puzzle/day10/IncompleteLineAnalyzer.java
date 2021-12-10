package amalagraba.puzzle.day10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class IncompleteLineAnalyzer extends SyntaxAnalyzer {

    private static final int SCORE_MULTIPLIER = 5;
    private static final Map<Character, Integer> SCORE_MAP = Map.of(
            '(', 1,
            '[', 2,
            '{', 3,
            '<', 4
    );

    @Override
    public long calculateScore(String[] lines) {
        List<Long> sortedScores = Arrays.stream(lines)
                .map(this::analyze)
                .filter(SyntaxAnalysisResult::isIncompleteLine)
                .map(SyntaxAnalysisResult::unmatchedCharacters)
                .map(this::calculateScore)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        return sortedScores.isEmpty() ? 0 : sortedScores.get(sortedScores.size() / 2);
    }

    private long calculateScore(Stack<Character> unmatchedCharacters) {
        long score = 0;

        while (!unmatchedCharacters.isEmpty()) {
            score = score * SCORE_MULTIPLIER + SCORE_MAP.get(unmatchedCharacters.pop());
        }
        return score;
    }
}