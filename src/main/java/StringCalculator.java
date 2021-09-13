import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class StringCalculator {

    public static final String SEPARATORS_REGEX = "[\n,]";

    public int add(String numbers) {
        return Arrays.stream(numbers.split(SEPARATORS_REGEX)).
                filter(StringUtils::isNoneEmpty)
                .map(Integer::valueOf)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
