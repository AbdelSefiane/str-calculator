import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.lacombe.kata.StringCalculator;

public class StringCalculatorTest {

    @Test
    public void sumShouldComputeEmptyArgsAsZero() {
        StringCalculator calculator = new StringCalculator();
        Integer sumResult = calculator.sum("");
        Assertions.assertEquals(0, sumResult);
    }

    @Test
    public void sumShouldCompute1OperandAsIdentityFunction() {
        StringCalculator calculator = new StringCalculator();
        Integer sumResult = calculator.sum("1");
        Assertions.assertEquals(1, sumResult);
    }

    @Test
    public void addShouldSumPairCsvOperands() {
        StringCalculator calculator = new StringCalculator();
        Integer sumResult = calculator.sum("1,2");
        Assertions.assertEquals(3, sumResult);
    }

    @Test
    public void addShouldSumNCsvOperands() {
        StringCalculator calculator = new StringCalculator();
        Integer sumResult = calculator.sum("1,2,3,4,5");
        Assertions.assertEquals(15, sumResult);
    }
}
