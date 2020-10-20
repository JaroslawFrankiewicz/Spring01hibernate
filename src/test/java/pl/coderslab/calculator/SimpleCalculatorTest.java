package pl.coderslab.calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleCalculatorTest {

    private SimpleCalculator simpleCalculator;

    @Before
    public void setUp() {
        simpleCalculator = new SimpleCalculator();
    }

    @Test
    public void shouldReturnSum_ofTwoNumbers() {
        //given
        int a = 1;
        int b = 1;
        //when
        int sum = simpleCalculator.add(a, b);
        Assert.assertThat(sum, is(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldAddTwoNumber_whenBothPositive() {
        //given
        int a = 2;
        int b = 1;
        //when // then
        simpleCalculator.addPositive(a, b);
    }
}