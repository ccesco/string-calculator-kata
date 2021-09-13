import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class StringCalculator {

    public static final String DEFAULT_SEPARATORS = "[\n,]";
    public static final String BEGINNING_STRING = "//";
    public static final String SEPARATOR_DELIMITER_NUMBER = "\n";

    public int add(String numbers) {
        String[] delimiterNumber = numbers.split(SEPARATOR_DELIMITER_NUMBER);
        String delimiter = getDelimiter(delimiterNumber[0]);
        if (delimiter.equals(DEFAULT_SEPARATORS)) {
            return addWithSeparator(
                    numbers,
                    delimiter
            );
        }
        return addWithSeparator(
                delimiterNumber[1],
                delimiter
        );
    }

    private String getDelimiter(String possibleDelimiter) {
        if (possibleDelimiter.contains(BEGINNING_STRING)) {
            return possibleDelimiter.replace(BEGINNING_STRING, "");
        }
        return DEFAULT_SEPARATORS;
    }

    private int addWithSeparator(String numbers, String separator) {
        return Arrays.stream(numbers.split(separator)).
                filter(StringUtils::isNoneEmpty)
                .map(Integer::valueOf)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
