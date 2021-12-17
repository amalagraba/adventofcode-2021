package amalagraba.puzzle.day16.operators;

import amalagraba.puzzle.day16.OperatorPacket;
import amalagraba.puzzle.day16.Packet;

public class LessThanPacket extends OperatorPacket {

    public LessThanPacket(int version) {
        super(version);
    }

    @Override
    public long getValue() {
        return subPackets.get(0).getValue() < subPackets.get(1).getValue() ? 1 : 0;
    }
}
