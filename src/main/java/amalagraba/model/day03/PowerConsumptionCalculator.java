package amalagraba.model.day03;

import org.apache.commons.lang3.mutable.MutableInt;

import java.util.function.Function;

public class PowerConsumptionCalculator {

    private MutableInt[] zeroes;
    private MutableInt[] ones;

    public void addReading(String input) {
        initialize(input);
        internalAddReading(input);
    }

    public int calculatePowerConsumption() {
        if (isNotInitialized()) {
            return 0;
        }
        String gamma = getMostCommonBits(Function.identity());
        String epsilon = getMostCommonBits(this::binaryComplementary);

        return toDecimal(gamma) * toDecimal(epsilon);
    }

    private String getMostCommonBits(Function<Character, Character> mapper) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < zeroes.length; i++) {
            builder.append(mapper.apply(ones[i].compareTo(zeroes[i]) > 0 ? '1' : '0'));
        }
        return builder.toString();
    }

    private Character binaryComplementary(Character character) {
        return character == '1' ? '0' : '1';
    }

    private int toDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }

    private void internalAddReading(String input) {
        for (int i = 0; i < input.length(); i++) {
            (input.charAt(i) == '1' ? ones : zeroes)[i].increment();
        }
    }

    private void initialize(String input) {
        if (isNotInitialized()) {
            zeroes = createMutableIntArray(input.length());
            ones = createMutableIntArray(input.length());
        }
    }

    private MutableInt[] createMutableIntArray(int length) {
        MutableInt[] array = new MutableInt[length];

        for (int i = 0; i < length; i++) {
            array[i] = new MutableInt();
        }
        return array;
    }

    private boolean isNotInitialized() {
        return zeroes == null;
    }
}
