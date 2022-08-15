import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.lacombe.kata.StringCalculator;

public class StringCalculatorTest {


    @Test
    public void sumShouldComputeEmptyArgsAsZero(){
        StringCalculator calculator = new StringCalculator();
        Integer sumResult = calculator.sum("");
        Assertions.assertEquals(0,sumResult);
    }

}
