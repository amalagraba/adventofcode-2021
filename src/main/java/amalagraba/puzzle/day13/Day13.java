package amalagraba.puzzle.day13;

import amalagraba.PuzzleRunner;
import amalagraba.common.grid.Point;
import amalagraba.puzzle.AbstractPuzzle;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day13 extends AbstractPuzzle {

    public static void main(String[] args) {
        PuzzleRunner.run(new Day13());
    }

    /**
     * Definition: https://adventofcode.com/2021/day/13
     */
    @Override
    public String solvePart1(String rawInput) {
        return String.valueOf(getFoldedPaper(rawInput, 1).points().size());
    }

    /**
     * Definition: https://adventofcode.com/2021/day/13#part2
     */
    @Override
    public String solvePart2(String rawInput) {
        return "\n" + getFoldedPaper(rawInput, Integer.MAX_VALUE).print();
    }

    private PaperSheet getFoldedPaper(String rawInput, int limit) {
        String[] input = splitInputLines(rawInput);
        List<Fold> folds = Arrays.stream(input).filter(Fold::isFold).map(Fold::new).collect(Collectors.toList());
        PaperSheet paper = new PaperSheet(
                Arrays.stream(input).filter(Point::isPoint).map(Point::new).collect(Collectors.toSet()));

        folds.stream().limit(limit).forEach(paper::fold);

        return paper;
    }
}
