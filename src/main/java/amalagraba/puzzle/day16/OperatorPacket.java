package amalagraba.puzzle.day16;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode(callSuper = true)
public abstract class OperatorPacket extends Packet {

    protected final List<Packet> subPackets = new ArrayList<>();

    public OperatorPacket(int version) {
        super(version);
    }

    @Override
    public long getVersionSum() {
        return getVersion() + subPackets.stream().mapToLong(Packet::getVersionSum).sum();
    }

    public void addSubPacket(Packet packet) {
        subPackets.add(packet);
    }
}
