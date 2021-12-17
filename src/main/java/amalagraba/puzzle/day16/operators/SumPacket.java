package amalagraba.puzzle.day16.operators;

import amalagraba.puzzle.day16.OperatorPacket;
import amalagraba.puzzle.day16.Packet;

public class SumPacket extends OperatorPacket {

    public SumPacket(int version) {
        super(version);
    }

    @Override
    public long getValue() {
        return subPackets.stream().mapToLong(Packet::getValue).sum();
    }
}
