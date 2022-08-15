import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.lacombe.kata.StringCalculator;

public class StringCalculatorTest {

    @Test
    public void addShouldComputeEmptyArgsAsZero() {
        StringCalculator calculator = new StringCalculator();
        Integer sumResult = calculator.add("");
        Assertions.assertEquals(0, sumResult);
    }

    @Test
    public void sumShouldCompute1OperandAsIdentityFunction() {
        StringCalculator calculator = new StringCalculator();
        Integer sumResult = calculator.add("1");
        Assertions.assertEquals(1, sumResult);
    }

    @Test
    public void addShouldSumPairCsvOperands() {
        StringCalculator calculator = new StringCalculator();
        Integer sumResult = calculator.add("1,2");
        Assertions.assertEquals(3, sumResult);
    }

    @Test
    public void addShouldSumNCsvOperands() {
        StringCalculator calculator = new StringCalculator();
        Integer sumResult = calculator.add("1,2,3,4,5");
        Assertions.assertEquals(15, sumResult);
    }

    @Test
    public void addShouldHandleNewLineAsSeparator() {
        StringCalculator calculator = new StringCalculator();
        Integer sumResult = calculator.add("\n");
        Assertions.assertEquals(0, sumResult);
        Integer sumResult2 = calculator.add("1\n");
        Assertions.assertEquals(1, sumResult2);
        Integer sumResult3 = calculator.add("1\n2,3");
        Assertions.assertEquals(6, sumResult3);
    }

    @Test
    public void addShouldAcceptOptionalFirstLineToBeDelimiterConfiguration() {
        StringCalculator calculator = new StringCalculator();
        Integer zeroSumResult = calculator.add("//;\n");
        Assertions.assertEquals(0, zeroSumResult);
        Integer sumResult = calculator.add("//;\n1");
        Assertions.assertEquals(1, sumResult);
        Integer sumResult2 = calculator.add("//;\n1;2");
        Assertions.assertEquals(3, sumResult2);
    }

    @Test
    public void addShouldThrowExceptionOnNegatifIntegerInput() {
        StringCalculator calculator = new StringCalculator();
        Assertions.assertThrows(RuntimeException.class, () -> calculator.add("-1"));
        try {
            calculator.add("-1,-2");
            Assertions.fail();
        } catch (RuntimeException e) {
            Assertions.assertEquals("negatives not allowed: [-1, -2]", e.getMessage());
        }
    }

    @Test
    public void addShouldConsiderNumbersHigherThanUpperBoxingLimitAsZero() {
        StringCalculator calculator = new StringCalculator();
        Integer sumResult = calculator.add("1,1000");
        Assertions.assertEquals(1, sumResult);
        Integer identitySumResult = calculator.add("1000");
        Assertions.assertEquals(1000, identitySumResult);
    }

    @Test
    public void addShouldAcceptSeparatorWithMoreThanOneCharacter() {
        StringCalculator calculator = new StringCalculator();
        Integer sumResult = calculator.add("//[***]\n1***2***3");
        Assertions.assertEquals(6, sumResult);
    }

    @Test
    public void addShouldAcceptMultipleSeparatorDefinition() {
        StringCalculator calculator = new StringCalculator();
        Integer sumResult = calculator.add("//[***][**]\n1***2**3");
        Assertions.assertEquals(6, sumResult);
        Integer sumResult2 = calculator.add("//[***][**]\n1\n2***3");
        Assertions.assertEquals(6, sumResult);
    }
}
