package amalagraba.puzzle.day16.operators;

import amalagraba.puzzle.day16.OperatorPacket;
import amalagraba.puzzle.day16.Packet;

public class MaxPacket extends OperatorPacket {

    public MaxPacket(int version) {
        super(version);
    }

    @Override
    public long getValue() {
        return subPackets.stream().mapToLong(Packet::getValue).max().orElse(0);
    }
}
