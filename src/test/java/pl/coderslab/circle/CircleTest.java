package pl.coderslab.circle;

import org.junit.Test;

import static org.junit.Assert.*;

public class CircleTest {

    @Test
    public void shouldReturnCircleArea_whenRadiusTwo() {

        //given
        int r = 2;

        //when
        double area = Circle.circleArea(r);

        //then
        assertEquals(12.56, area, 0.01);

    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowException_whenRadiusLesserThanZero() {

        //given
        int r = -2;

        //when
        Circle.circleArea(r);


    }
}