package amalagraba.puzzle.day16.operators;

import amalagraba.puzzle.day16.OperatorPacket;
import amalagraba.puzzle.day16.Packet;

public class MinPacket extends OperatorPacket {

    public MinPacket(int version) {
        super(version);
    }

    @Override
    public long getValue() {
        return subPackets.stream().mapToLong(Packet::getValue).min().orElse(0);
    }
}
