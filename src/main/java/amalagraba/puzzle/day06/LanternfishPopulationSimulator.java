package amalagraba.puzzle.day06;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LanternfishPopulationSimulator {

    public static final int INITIAL_SPAWN_TIMER = 8;
    public static final int SPAWN_TIMER_RESET_VALUE = 6;

    private final long[] populationBySpawnTimer = new long[INITIAL_SPAWN_TIMER + 1];


    public LanternfishPopulationSimulator(String initialState) {
        if (StringUtils.isNotBlank(initialState)) {
            Arrays.stream(initialState.split(","))
                    .map(Short::parseShort)
                    .forEach(timer -> populationBySpawnTimer[timer]++);
        }
    }

    public void simulateDays(int days) {
        IntStream.range(0, days).forEach(day -> simulateDay());
    }

    public long count() {
        return Arrays.stream(populationBySpawnTimer).sum();
    }

    private void simulateDay() {
        ArrayUtils.shift(populationBySpawnTimer, -1);
        populationBySpawnTimer[SPAWN_TIMER_RESET_VALUE] += populationBySpawnTimer[INITIAL_SPAWN_TIMER];
    }
}
