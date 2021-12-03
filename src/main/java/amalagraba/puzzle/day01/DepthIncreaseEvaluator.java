package amalagraba.puzzle.day01;

public class DepthIncreaseEvaluator {

    public int evaluate(Integer[] values) {
        int count = 0;

        for (int i = 1; i < values.length; i++) {
            if (isIncrease(values, i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isIncrease(Integer[] values, int index) {
        return values[index - 1] < values[index];
    }
}
