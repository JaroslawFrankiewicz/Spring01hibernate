package pl.coderslab.calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MaxValueTest {
    private MaxValue maxValue;

    @Before
    public void setUp() throws Exception {
        maxValue = new MaxValue();
    }

    @Test
    public void shouldBeLargestValueOfTable() {
        //given
        int[] max = {1, 2, 3, 4};
        //when
        int result = MaxValue.largest(max);
        Assert.assertThat(result, is(4));



    }
//    @Test(expected = IllegalArgumentException.class)
//    public void shouldAddTwoNumber_whenBothPositive() {
//        //given
//        int index = 0;
//        int a = 1;
//        //when // then
//        maxValue.(a, index);
//    }
}