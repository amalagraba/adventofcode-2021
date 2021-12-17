package amalagraba.puzzle.day16.operators;

import amalagraba.puzzle.day16.OperatorPacket;
import amalagraba.puzzle.day16.Packet;

public class ProductPacket extends OperatorPacket {

    public ProductPacket(int version) {
        super(version);
    }

    @Override
    public long getValue() {
        return subPackets.stream().mapToLong(Packet::getValue)
                .reduce((value, otherValue) -> value * otherValue)
                .orElse(0);
    }
}
