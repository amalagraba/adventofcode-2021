package amalagraba.puzzle.day03;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public record BitReader(List<char[]> data) {

    public static final char ZERO = '0';
    public static final char ONE = '1';

    public char findMostCommonBit(int position) {
        Map<Character, Long> countByBit = data.stream()
                .map(array -> array[position])
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        if (countByBit.getOrDefault(ZERO, 0L) > countByBit.getOrDefault(ONE, 0L)) {
            return ZERO;
        }
        return ONE;
    }

    public char findLeastCommonBit(int position) {
        return binaryComplementary(findMostCommonBit(position));
    }

    public BitReader filterByMostCommonBit(int position) {
        return filter(position, findMostCommonBit(position));
    }

    public BitReader filterByLeastCommonBit(int position) {
        return filter(position, findLeastCommonBit(position));
    }

    public char readHead(int position) {
        return data.isEmpty() ? ZERO : data.get(0)[position];
    }

    public int getDataLength() {
        return data.get(0).length;
    }

    public int size() {
        return data.size();
    }

    private BitReader filter(int position, char value) {
        return new BitReader(data.stream().filter(array -> array[position] == value).collect(Collectors.toList()));
    }

    private Character binaryComplementary(Character character) {
        return character == ONE ? ZERO : ONE;
    }
}
