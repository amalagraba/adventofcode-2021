package amalagraba.puzzle.day01;

public class WindowedDepthIncreaseEvaluator extends DepthIncreaseEvaluator {

    private static final int WINDOW_SIZE = 3;

    @Override
    public int evaluate(Integer[] values) {
        return super.evaluate(mapInputToMeasurementWindows(values));
    }

    private Integer[] mapInputToMeasurementWindows(Integer[] values) {
        Integer[] windows = new Integer[Math.max(0, values.length - size())];

        for (int i = size(); i < values.length; i++) {
            windows[i - size()] = values[i] + values[i - 1] + values[i - size()];
        }
        return windows;
    }

    private int size() {
        return WINDOW_SIZE - 1;
    }
}
