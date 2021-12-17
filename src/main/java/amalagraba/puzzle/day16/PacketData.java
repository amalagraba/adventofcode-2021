package amalagraba.puzzle.day16;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@AllArgsConstructor
public class PacketData {

    private String data;

    public String splitChunk(int size) {
        String chunk = data.substring(0, size);
        data = data.substring(size);

        return chunk;
    }

    public boolean hasData() {
        if (StringUtils.isEmpty(data)) {
            return false;
        }
        return data.contains("1");
    }
}
