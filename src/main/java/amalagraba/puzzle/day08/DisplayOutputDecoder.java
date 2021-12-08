package amalagraba.puzzle.day08;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

public class DisplayOutputDecoder {

    public int decode(String value) {
        String[] inputOutput = splitInputOutput(value);

        return decode(inputOutput[1], buildSignalMap(inputOutput[0]));
    }

    public int countUniqueLengthOutputValues(String value) {
        return (int) readSignals(splitInputOutput(value)[1]).stream()
                .filter(DisplaySignal::hasUniqueLength)
                .count();
    }

    private int decode(String output, Map<DisplaySignal, Integer> signalMap) {
        return Integer.parseInt(readSignals(output).stream()
                .map(signalMap::get)
                .map(String::valueOf)
                .collect(Collectors.joining()));
    }

    private Map<DisplaySignal, Integer> buildSignalMap(String input) {
        List<DisplaySignal> signals = readSignals(input);
        DisplaySignal seven = decodeSeven(signals);
        DisplaySignal three = decodeThree(signals, seven);
        DisplaySignal nine = decodeNine(signals, three);
        DisplaySignal zero = decodeZero(signals, nine, seven);
        DisplaySignal six = decodeSix(signals, zero, nine);
        DisplaySignal one = decodeOne(signals);
        DisplaySignal four = decodeFour(signals);
        DisplaySignal eight = decodeEight(signals);
        DisplaySignal five = decodeFive(signals, six);
        DisplaySignal two = decodeTwo(signals, nine);

        return Map.of(zero, 0, one, 1, two, 2, three, 3, four, 4, five, 5, six, 6, seven, 7, eight, 8, nine, 9);
    }

    private DisplaySignal decodeZero(List<DisplaySignal> signals, DisplaySignal nine, DisplaySignal seven) {
        return decodeBySize(signals, 6, signal -> signal.contains(seven) && !signal.equals(nine));
    }

    private DisplaySignal decodeOne(List<DisplaySignal> signals) {
        return decodeBySize(signals, 2);
    }

    private DisplaySignal decodeTwo(List<DisplaySignal> signals, DisplaySignal nine) {
        return decodeBySize(signals, 5, not(nine::contains));
    }

    private DisplaySignal decodeThree(List<DisplaySignal> signals, DisplaySignal seven) {
        return decodeBySize(signals, 5, signal -> signal.contains(seven));
    }

    private DisplaySignal decodeFour(List<DisplaySignal> signals) {
        return decodeBySize(signals, 4);
    }

    private DisplaySignal decodeFive(List<DisplaySignal> signals, DisplaySignal six) {
        return decodeBySize(signals, 5, six::contains);
    }

    private DisplaySignal decodeSix(List<DisplaySignal> signals, DisplaySignal zero, DisplaySignal nine) {
        return decodeBySize(signals, 6, signal -> !(signal.equals(zero) || signal.equals(nine)));
    }

    private DisplaySignal decodeSeven(List<DisplaySignal> signals) {
        return decodeBySize(signals, 3);
    }

    private DisplaySignal decodeEight(List<DisplaySignal> signals) {
        return decodeBySize(signals, 7);
    }

    private DisplaySignal decodeNine(List<DisplaySignal> signals, DisplaySignal three) {
        return decodeBySize(signals, 6, signal -> signal.contains(three));
    }

    private DisplaySignal decodeBySize(List<DisplaySignal> signals, int size) {
        return decodeBySize(signals, size, signal -> true);
    }

    private DisplaySignal decodeBySize(List<DisplaySignal> signals, int size, Predicate<DisplaySignal> selector) {
        return filterBySize(signals, size).stream().filter(selector).findFirst().orElse(null);
    }

    private List<DisplaySignal> filterBySize(List<DisplaySignal> signals, int size) {
        return signals.stream().filter(signal -> signal.size() == size).collect(Collectors.toList());
    }

    private List<DisplaySignal> readSignals(String value) {
        return Arrays.stream(value.trim().split(" "))
                .map(DisplaySignal::new)
                .collect(Collectors.toList());
    }

    private String[] splitInputOutput(String value) {
        return value.split("\\|");
    }
}
