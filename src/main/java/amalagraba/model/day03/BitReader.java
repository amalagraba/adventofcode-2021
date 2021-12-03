package amalagraba.model.day03;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BitReader {

    private final List<char[]> data;

    public BitReader(List<char[]> data) {
        this.data = data;
    }

    public char findMostCommonBit(int position) {
        return data.stream().map(array -> array[position])
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse('0');
    }

    public char findLeastCommonBit(int position) {
        return binaryComplementary(findMostCommonBit(position));
    }

    public int getDataLength() {
        if (data.isEmpty()) {
            return 0;
        }
        return data.get(0).length;
    }

    private Character binaryComplementary(Character character) {
        return character == '1' ? '0' : '1';
    }
}
