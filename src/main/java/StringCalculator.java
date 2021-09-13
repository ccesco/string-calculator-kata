import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class StringCalculator {

    public static final String SEPARATOR = ",";

    public int add(String numbers) {
        return Arrays.stream(numbers.split(SEPARATOR)).
                filter(StringUtils::isNoneEmpty)
                .map(Integer::valueOf)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
