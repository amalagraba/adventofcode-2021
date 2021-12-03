package amalagraba.puzzle.day03;

import java.util.function.BiFunction;

public class LifeSupportRatingCalculator extends BitReadingCalculator {

    @Override
    protected int calculate(BitReader reader) {
        return readOxygenGeneratorRating(reader) * readCO2ScrubberRating(reader);
    }

    private Integer readOxygenGeneratorRating(BitReader reader) {
        return readRating(reader, BitReader::filterByMostCommonBit);
    }

    private Integer readCO2ScrubberRating(BitReader reader) {
        return readRating(reader, BitReader::filterByLeastCommonBit);
    }

    private Integer readRating(BitReader reader, BiFunction<BitReader, Integer, BitReader> reducer) {
        BitReader filteredReader = reader;
        int position = 0;

        while (filteredReader.size() > 1) {
            filteredReader = reducer.apply(filteredReader, position++);
        }
        return readBits(filteredReader, BitReader::readHead);
    }
}
