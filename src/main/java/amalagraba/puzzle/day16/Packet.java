package amalagraba.puzzle.day16;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public abstract class Packet {

    private final int version;

    public long getVersionSum() {
        return version;
    }

    public abstract long getValue();
}
