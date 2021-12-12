package amalagraba.puzzle.day12;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static amalagraba.puzzle.day12.Cave.END;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class CavePathFinder implements Cave.Visitor {

    @Getter
    protected final List<List<Cave>> paths;
    protected final List<Cave> visited;


    public CavePathFinder() {
        this.paths = new ArrayList<>();
        this.visited = new ArrayList<>();
    }

    @Override
    public void accept(Cave cave) {
        visited.add(cave);

        if (isDone()) {
            paths.add(visited);
            return;
        }
        visitNext(cave);
    }

    protected boolean canVisitNext(List<Cave> branch, Cave next) {
        return next.isLarge() || !branch.contains(next);
    }

    protected CavePathFinder branch(List<Cave> branch) {
        return new CavePathFinder(paths, branch);
    }

    private void visitNext(Cave cave) {
        List<Cave> branch = new ArrayList<>(visited);

        cave.getNext().stream()
                .filter(next -> canVisitNext(branch, next))
                .forEach(next -> visitNext(branch, next));
    }

    private void visitNext(List<Cave> branch, Cave next) {
        next.visit(branch(new ArrayList<>(branch)));
    }

    private boolean isDone() {
        return END.equals(visited.get(visited.size() - 1).getName());
    }
}