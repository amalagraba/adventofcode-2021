package amalagraba.puzzle.day11;

import amalagraba.common.Grid;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.function.Predicate.not;

public class OctopusFlashObserver {

    private final Grid<Octopus> octopusGrid;

    public OctopusFlashObserver(String[] lines) {
        this.octopusGrid = new Grid<>(lines, Octopus::new);
    }

    public int observeFlashesInCycles(int cycles) {
        return IntStream.range(0, cycles).map(cycle -> observe()).sum();
    }

    public int observeCyclesBeforeSynchronization() {
        int iteration = 0;

        if (!octopusGrid.isEmpty()) {
            do {
                iteration++;
            } while (observe() != 100);
        }
        return iteration;
    }

    private int observe() {
        octopusGrid.forEach(Octopus::increaseValue);

        Collection<Octopus> flashed = flash();
        flashed.forEach(Octopus::reset);

        return flashed.size();
    }

    private Collection<Octopus> flash() {
        Set<Octopus> allFlashed = new HashSet<>();
        List<Octopus> flashed;

        do {
            flashed = flash(allFlashed::contains);
        } while (allFlashed.addAll(flashed));

        return allFlashed;
    }

    private List<Octopus> flash(Predicate<Octopus> alreadyFlashed) {
        return octopusGrid.stream()
                .filter(not(alreadyFlashed))
                .filter(octopus -> octopus.flash(() -> octopusGrid.getAllNeighbours(octopus)))
                .collect(Collectors.toList());
    }
}
