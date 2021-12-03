package amalagraba.puzzle.day03;

public class PowerConsumptionCalculator extends BitReadingCalculator {

    @Override
    public int calculate(BitReader reader) {
        return readGammaRate(reader) * readEpsilonRate(reader);
    }

    private Integer readGammaRate(BitReader reader) {
        return readBits(reader, BitReader::findMostCommonBit);
    }

    private Integer readEpsilonRate(BitReader reader) {
        return readBits(reader, BitReader::findLeastCommonBit);
    }
}
