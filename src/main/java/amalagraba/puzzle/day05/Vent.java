package amalagraba.puzzle.day05;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vent {

    private final int x;
    private final int y;

    public Vent(String point) {
        String[] coordinates = point.split(",");
        this.x = Integer.parseInt(coordinates[0]);
        this.y = Integer.parseInt(coordinates[1]);
    }
}