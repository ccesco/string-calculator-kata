import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    private int addWithSeparator(String numbers, String separator) throws NegativeNumberException{
        List<Integer> numbersInteger = getNumbers(numbers, separator);
        List<Integer> negativeNumbers = numbersInteger
                .stream()
                .filter((number -> number < 0))
                .collect(Collectors.toList());

        if (negativeNumbers.size() > 0) {
            throw new NegativeNumberException("negatives not allowed " + negativeNumbers);
        }

        return numbersInteger
                .stream()
                .reduce(Integer::sum)
                .orElse(0);
    }

    private List<Integer> getNumbers(String numbers, String separator) {
        return Arrays.stream(numbers.split(separator))
                .filter(StringUtils::isNoneEmpty)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
