package amalagraba.model.day03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public abstract class BitReadingCalculator {

    protected final List<char[]> data = new ArrayList<>();

    public void addReading(String input) {
        data.add(input.toCharArray());
    }

    public int calculate() {
        if (data.isEmpty()) {
            return 0;
        }
        return doCalculate();
    }

    protected abstract int doCalculate();

    protected int toDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }

    protected String readMostCommonBits(BitReader reader) {
        return readBits(reader, BitReader::findMostCommonBit);
    }

    protected String readLeastCommonBits(BitReader reader) {
        return readBits(reader, BitReader::findLeastCommonBit);
    }

    protected String readBits(BitReader reader, BiFunction<BitReader, Integer, Character> readingFunction) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < reader.getDataLength(); i++) {
            builder.append(readingFunction.apply(reader, i));
        }
        return builder.toString();
    }
}
