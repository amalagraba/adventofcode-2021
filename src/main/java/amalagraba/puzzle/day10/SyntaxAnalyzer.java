package amalagraba.puzzle.day10;

import java.util.Map;
import java.util.Stack;

public abstract class SyntaxAnalyzer {

    protected static final Map<Character, Character> OPEN_CLOSE_MAP = Map.of(
            ')', '(',
            '>', '<',
            ']', '[',
            '}', '{'
    );

    public abstract long calculateScore(String[] lines);

    protected SyntaxAnalysisResult analyze(String line) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < line.length(); i++) {
            Character symbol = line.charAt(i);

            if (!isCloseSymbol(symbol)) {
                stack.add(symbol);
            } else if (isIllegalCloseCharacter(stack, symbol)) {
                return new SyntaxAnalysisResult(symbol, stack);
            }
        }
        return new SyntaxAnalysisResult(null, stack);
    }

    protected boolean isCloseSymbol(Character symbol) {
        return OPEN_CLOSE_MAP.containsKey(symbol);
    }

    protected boolean isIllegalCloseCharacter(Stack<Character> stack, Character symbol) {
        return stack.isEmpty() || !stack.pop().equals(OPEN_CLOSE_MAP.get(symbol));
    }

    protected record SyntaxAnalysisResult(Character invalidSymbol, Stack<Character> unmatchedCharacters) {

        public boolean isInvalidLine() {
            return invalidSymbol != null;
        }

        public boolean isIncompleteLine() {
            return !isInvalidLine();
        }
    }
}
