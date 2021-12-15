package amalagraba.puzzle.day12;

import amalagraba.common.Visitor;

import java.util.HashMap;
import java.util.Map;

import static amalagraba.puzzle.day12.Cave.START;

public class CaveMap {

    private final Map<String, Cave> caveMap = new HashMap<>();

    public CaveMap(String[] paths) {
        for (String path : paths) {
            String[] caves = path.split("-");
            Cave cave1 = caveMap.computeIfAbsent(caves[0], Cave::new);
            Cave cave2 = caveMap.computeIfAbsent(caves[1], Cave::new);

            cave1.connect(cave2);
        }
    }

    public void visit(Visitor<Cave> visitor) {
        if (caveMap.containsKey(START)) {
            caveMap.get(START).visit(visitor);
        }
    }
}
