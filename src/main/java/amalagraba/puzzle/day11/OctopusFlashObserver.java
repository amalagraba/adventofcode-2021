package amalagraba.puzzle.day11;

import amalagraba.common.Grid;

import java.util.ArrayList;
import java.util.List;
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

        List<Octopus> flashed = flash();
        flashed.forEach(Octopus::reset);

        return flashed.size();
    }

    private List<Octopus> flash() {
        List<Octopus> allFlashed = new ArrayList<>();
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
