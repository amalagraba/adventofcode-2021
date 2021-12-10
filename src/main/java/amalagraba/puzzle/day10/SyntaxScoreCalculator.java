package amalagraba.puzzle.day10;

import java.util.Map;
import java.util.Stack;

public abstract class SyntaxScoreCalculator {

    protected static final Map<Character, Character> OPEN_CLOSE_MAP = Map.of(
            ')', '(',
            '>', '<',
            ']', '[',
            '}', '{'
    );

    public abstract long calculate(String[] lines);

    protected Stack<Character> buildIncompleteStack(String line) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < line.length(); i++) {
            Character symbol = line.charAt(i);

            if (isCloseSymbol(symbol)) {
                if (isIllegalCloseCharacter(stack, symbol)) {
                    stack.add(symbol);
                    break;
                }
                stack.pop();
            } else {
                stack.add(symbol);
            }
        }
        return stack;
    }

    private boolean isIllegalCloseCharacter(Stack<Character> stack, Character symbol) {
        return stack.isEmpty() || !stack.peek().equals(OPEN_CLOSE_MAP.get(symbol));
    }

    protected boolean isCloseSymbol(Character symbol) {
        return OPEN_CLOSE_MAP.containsKey(symbol);
    }
}
