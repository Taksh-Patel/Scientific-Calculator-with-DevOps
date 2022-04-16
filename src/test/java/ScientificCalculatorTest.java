import devops_calculator.ScientificCalculator;
import org.junit.Test;
import static org.junit.Assert.*;

public class ScientificCalculatorTest {
    ScientificCalculator scientificCalculator = new ScientificCalculator();
    private static final double DEL = 1e-5;

    @Test
    public void squareRootTruePositive(){
        assertEquals("Square Root | True Positive", 3, scientificCalculator.squareRoot(9), DEL);
        assertEquals("Square Root | True Positive", 5, scientificCalculator.squareRoot(25), DEL);
        assertEquals("Square Root | True Positive", 100, scientificCalculator.squareRoot(10000), DEL);
    }

    @Test
    public void squareRootFalsePositive(){
        assertNotEquals("Square Root | False Positive", 2, scientificCalculator.squareRoot(7), DEL);
        assertNotEquals("Square Root | False Positive", 5, scientificCalculator.squareRoot(11), DEL);
        assertNotEquals("Square Root | False Positive", 7, scientificCalculator.squareRoot(27), DEL);

    }

    @Test
    public void factorialTruePositive(){
        assertEquals("Factorial | True Positive", 5040, scientificCalculator.factorial(7), DEL);
        assertEquals("Factorial | True Positive", 720, scientificCalculator.factorial(6), DEL);
        assertEquals("Factorial | True Positive", 6, scientificCalculator.factorial(3), DEL);
    }

    @Test
    public void factorialFalsePositive(){
        assertNotEquals("Factorial | False Positive", 3, scientificCalculator.factorial(3), DEL);
        assertNotEquals("Factorial | False Positive", 720, scientificCalculator.factorial(5), DEL);
        assertNotEquals("Factorial | False Positive", 4, scientificCalculator.factorial(2), DEL);
    }

    @Test
    public void naturalLogarithmTruePositive(){
        assertEquals("Natural Logarithm | True Positive", 4.60517, scientificCalculator.naturalLogarithm(100), DEL);
        assertEquals("Natural Logarithm | True Positive", 2.30258, scientificCalculator.naturalLogarithm(10), DEL);
        assertEquals("Natural Logarithm | True Positive", 0, scientificCalculator.naturalLogarithm(1), DEL);
    }

    @Test
    public void naturalLogarithmFalsePositive(){
        assertNotEquals("Natural Logarithm | False Positive", 5.3, scientificCalculator.naturalLogarithm(4), DEL);
        assertNotEquals("Natural Logarithm | False Positive", 1.8, scientificCalculator.naturalLogarithm(2), DEL);
        assertNotEquals("Natural Logarithm | False Positive", 7.3, scientificCalculator.naturalLogarithm(3), DEL);
        assertNotEquals("Natural Logarithm | False Positive", 0, scientificCalculator.naturalLogarithm(0), DEL);
        assertNotEquals("Natural Logarithm | False Positive", 1, scientificCalculator.naturalLogarithm(-1), DEL);
    }
    @Test
    public void powerTruePositive(){
        assertEquals("Power | True Positive", 125, scientificCalculator.power(5, 3), DEL);
        assertEquals("Power | True Positive", 9, scientificCalculator.power(3, 2), DEL);
        assertEquals("Power | True Positive", 16, scientificCalculator.power(2, 4), DEL);
    }

    @Test
    public void powerFalsePositive(){
        assertNotEquals("Power | False Positive", 40, scientificCalculator.power(7, 2), DEL);
        assertNotEquals("Power | False Positive", -1, scientificCalculator.power(1, 3), DEL);
        assertNotEquals("Power | False Positive", 4, scientificCalculator.power(4, 3), DEL);
    }

}
