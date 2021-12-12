package amalagraba.puzzle.day12;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

@Data
@ToString(of = "name")
@EqualsAndHashCode(of = "name")
public class Cave {

    public static final String START = "start";
    public static final String END = "end";

    private final Set<Cave> next = new HashSet<>();

    private final String name;

    public void connect(Cave cave) {
        this.next.add(cave);
        cave.next.add(this);
    }

    public boolean isLarge() {
        return StringUtils.isAllUpperCase(name);
    }

    public boolean isSmall() {
        return !isLarge();
    }

    public boolean isEnd() {
        return END.equals(name);
    }

    public boolean isStart() {
        return START.equals(name);
    }

    public void visit(Visitor visitor) {
        visitor.accept(this);
    }

    @FunctionalInterface
    public interface Visitor {
        void accept(Cave cave);
    }
}