package amalagraba.input;

import org.apache.commons.lang3.StringUtils;

public class TestInput {

    public static String integerInput(Integer... input) {
        return StringUtils.joinWith("\n", (Object[]) input);
    }

    public static String stringInput(String... input) {
        return StringUtils.joinWith("\n", (Object[]) input);
    }
}
