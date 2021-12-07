package amalagraba.puzzle.day07;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.IntStream;

public record MinimumFuelUsagePredictor(Integer[] positions, FuelUsageCalculator fuelUsageCalculator) {

    public int predict() {
        int max = findPosition(IntStream::max);
        int min = findPosition(IntStream::min);

        return IntStream.range(min, max + 1).map(this::calculateFuelToPosition).min().orElse(0);
    }

    private int calculateFuelToPosition(int position) {
        return Arrays.stream(positions)
                .map(value -> Math.abs(value - position))
                .mapToInt(fuelUsageCalculator::calculate)
                .sum();
    }

    private int findPosition(Function<IntStream, OptionalInt> filter) {
        return filter.apply(Arrays.stream(positions).mapToInt(Integer::intValue)).orElse(0);
    }
}
