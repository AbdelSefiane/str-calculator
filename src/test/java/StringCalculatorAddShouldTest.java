import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.lacombe.kata.StringCalculator;

public class StringCalculatorAddShouldTest {

    final StringCalculator calculator = new StringCalculator();

    @Test
    public void emptyArgsAsInput() {
        Integer sumResult = calculator.add("");
        Assertions.assertEquals(0, sumResult);
    }

    @Test
    public void uniqueOperand() {
        Integer sumResult = calculator.add("1");
        Assertions.assertEquals(1, sumResult);
    }

    @Test
    public void nCsvOperands() {
        Integer sumResult = calculator.add("1,2,3,4,5");
        Assertions.assertEquals(15, sumResult);
    }

    @Test
    public void newLineAsSeparator() {
        Integer sumResult = calculator.add("\n");
        Assertions.assertEquals(0, sumResult);
        Integer sumResult2 = calculator.add("1\n2,3");
        Assertions.assertEquals(6, sumResult2);
    }

    @Test
    public void optionalFirstLineToBeDelimiterConfiguration() {
        Integer zeroSumResult = calculator.add("//;\n");
        Assertions.assertEquals(0, zeroSumResult);
        Integer sumResult = calculator.add("//;\n1;2");
        Assertions.assertEquals(3, sumResult);
    }

    @Test
    public void exceptionOnNegatifIntegerInput() {
        try {
            calculator.add("-1,-2");
            Assertions.fail();
        } catch (RuntimeException e) {
            Assertions.assertEquals("negatives not allowed: [-1, -2]", e.getMessage());
        }
    }

    @Test
    public void numbersHigherThanUpperBoxingLimitAsZero() {
        Integer sumResult = calculator.add("1,1000");
        Assertions.assertEquals(1, sumResult);
        Integer identitySumResult = calculator.add("1000");
        Assertions.assertEquals(1000, identitySumResult);
    }

    @Test
    public void separatorWithMoreThanOneCharacter() {
        Integer sumResult = calculator.add("//[***]\n1***2***3");
        Assertions.assertEquals(6, sumResult);
        Integer sumResult2 = calculator.add("//[]\n123");
        Assertions.assertEquals(6, sumResult2);
    }

    @Test
    public void multipleSeparatorDefinition() {
        Integer sumResult = calculator.add("//[***][**]\n1***2**3");
        Assertions.assertEquals(6, sumResult);
        Integer sumResult2 = calculator.add("//[***][**]\n1\n2***3");
        Assertions.assertEquals(6, sumResult2);
    }
}
