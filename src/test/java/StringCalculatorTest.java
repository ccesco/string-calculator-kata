import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {


    StringCalculator stringCalculator;

    @BeforeEach
    void init() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void emptyStringShouldReturnZeroTest() {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void oneNumberShouldReturnItseftTest() {
        assertEquals(10, stringCalculator.add("10"));
    }

    @Test
    public void twoNumbersShouldBeAddedTest() {
        assertEquals(5, stringCalculator.add("1,4"));
    }

    @Test
    public void moreDigitsSupportedTest() {
        assertEquals(24, stringCalculator.add("10,14"));
    }

}
