package amalagraba.puzzle.day12;

import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
public class SmallDuplicateAllowedCavePathFinder extends CavePathFinder {

    public SmallDuplicateAllowedCavePathFinder(List<List<Cave>> paths, List<Cave> visited) {
        super(paths, visited);
    }

    @Override
    protected boolean canVisitNext(List<Cave> branch, Cave next) {
        return next.isLarge() || canVisitSmallCave(branch, next);
    }

    @Override
    protected CavePathFinder branch(List<Cave> branch) {
        return new SmallDuplicateAllowedCavePathFinder(paths, branch);
    }

    private boolean canVisitSmallCave(List<Cave> branch, Cave next) {
        return !branch.contains(next) || !next.isStart() && !hasVisitedTwoSmallCaves(branch);
    }

    private boolean hasVisitedTwoSmallCaves(List<Cave> branch) {
        Set<Cave> caves = new HashSet<>(branch.size());

        for (Cave cave : branch) {
            if (cave.isSmall() && caves.contains(cave)) {
                return true;
            }
            caves.add(cave);
        }
        return false;
    }
}