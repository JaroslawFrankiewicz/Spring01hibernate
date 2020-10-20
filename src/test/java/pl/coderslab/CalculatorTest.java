package pl.coderslab;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.coderslab.calculator.Calculator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    private Calculator calculator;
    @Before
    public void setUp() {
        calculator = new Calculator();
    }
    @Test
    public void shouldReturnSum_ofTwoNumbers() {
        //given
        int a = 1;
        int b = 1;
        //when
        int sum = calculator.add(a, b);
        Assert.assertThat(sum, is(2));
    }

    @Test
    public void shouldReturnSubstract_ofTwoNumbers() {
        //given
        int a = 2;
        int b = 1;
        //when
        int sum = calculator.substract(a, b);
        //then
        Assert.assertThat(sum, is(1));
    }
    @Test
    public void shouldReturnMultiply_ofTwoNumbers() {
        //given
        int a = 2;
        int b = 1;
        //when
        int sum = calculator.multiply(a, b);
        //then
        Assert.assertThat(sum, is(2));
    }

    @Test
    public void shouldReturnDivide_ofTwoNumbers() {
        //given
        int a = 2;
        int b = 1;
        //when
        double sum = calculator.divide(a, b);
        Assert.assertThat(sum, is(2.0));
    }

    @Test
    public void shouldReturnGreater_ofTwoNumbers() {
        //given
        int a = 2;
        int b = 1;
        //when
        boolean sum = calculator.greater(a, b);
        //then
        Assert.assertTrue(sum);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_whenTryDivideByZero() {
        //given
        int a = 2;
        int b = 0;
        //when // then
        calculator.divide(a, b);

    }
    @Test
    public void evaluatesExpression() {
        //given


        int sum = calculator.eval("1+2+3");
        assertEquals(6, sum);
    }

}
