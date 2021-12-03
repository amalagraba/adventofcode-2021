package amalagraba.model.day03;

public class PowerConsumptionCalculator extends BitReadingCalculator {

    @Override
    public int doCalculate() {
        BitReader reader = new BitReader(data);

        String gamma = readMostCommonBits(reader);
        String epsilon = readLeastCommonBits(reader);

        return toDecimal(gamma) * toDecimal(epsilon);
    }
}
