package amalagraba.puzzle.day14;

import org.apache.commons.lang3.mutable.MutableLong;

import java.util.HashMap;
import java.util.Map;
import java.util.OptionalLong;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.LongStream;

public class PolymerCombinator {

    private final Map<String, String> rules;
    private Map<String, MutableLong> pairs;

    public PolymerCombinator(String initialState, Map<String, String> rules) {
        this.pairs = new HashMap<>();
        this.rules = rules;

        for (int i = 0; i + 1 < initialState.length(); i++) {
            addToMap(pairs, String.valueOf(initialState.charAt(i)) + initialState.charAt(i + 1));
        }
    }

    public void insertPairs(int iterations) {
        for (int i = 0; i < iterations; i++) {
            insertPairs();
        }
    }

    public void insertPairs() {
        Set<String> pairSet = pairs.keySet();
        Map<String, MutableLong> newPairs = new HashMap<>();

        pairSet.forEach(pair -> insertPair(newPairs, pair, pairs.get(pair)));

        this.pairs = newPairs;
    }

    public long getPolymerScore() {
        Map<String, MutableLong> characterMap = getCharacterMap();

        long max = getValue(characterMap, LongStream::max);
        long min = getValue(characterMap, LongStream::min);

        return max - min + 1;
    }

    private Map<String, MutableLong> getCharacterMap() {
        Map<String, MutableLong> characterMap = new HashMap<>();

        pairs.forEach((pair, times) -> {
            addToMap(characterMap, pair.substring(0, 1), times);
            addToMap(characterMap, pair.substring(1), times);
        });
        return characterMap;
    }

    private long getValue(Map<String, MutableLong> characterMap, Function<LongStream, OptionalLong> reduce) {
        return reduce.apply(characterMap.values().stream().mapToLong(value -> value.longValue() / 2)).orElse(0);
    }

    private void insertPair(Map<String, MutableLong> newPairs, String pair, Number times) {
        String newLetter = rules.get(pair);

        addToMap(newPairs, pair.charAt(0) + newLetter, times);
        addToMap(newPairs, newLetter + pair.charAt(1), times);
    }

    private void addToMap(Map<String, MutableLong> map, String value) {
        addToMap(map, value, 1);
    }

    private void addToMap(Map<String, MutableLong> map, String value, Number times) {
        map.computeIfAbsent(value, k -> new MutableLong()).add(times);
    }
}
