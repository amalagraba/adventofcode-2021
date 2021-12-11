package amalagraba.common;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class IntPoint extends Point {

    protected int value;

    public IntPoint(int x, int y, char value) {
        this(x, y, Character.getNumericValue(value));
    }

    public IntPoint(int x, int y, int value) {
        super(x, y);
        this.value = value;
    }

    public void increaseValue() {
        value++;
    }
}