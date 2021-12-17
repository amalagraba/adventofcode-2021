package amalagraba.puzzle.day16;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = true)
public class LiteralPacket extends Packet {

    private final long value;

    public LiteralPacket(int version, long value) {
        super(version);
        this.value = value;
    }
}
