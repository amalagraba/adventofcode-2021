package amalagraba.model.day02;

import lombok.Data;

@Data
public class Location {

    private int horizontal;
    private int depth;

    public int getCoordinateProduct() {
        return horizontal * depth;
    }
}