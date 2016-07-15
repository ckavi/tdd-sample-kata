package com.osherove.kata1;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by cihan on 14/07/16.
 */
public class StringCalculatorTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void givenEmptyStringToAddMethodThenReturn0(){
        assertTrue(StringCalculator.add("")==0);
    }

    @Test
    public void given1NumberInStringThenReturnItself(){
        assertTrue(StringCalculator.add("1")==1);
    }

    @Test
    public void given2NumbersInStringThenReturnSum(){
        assertTrue(StringCalculator.add("1,2")==3);
    }

    @Test
    public void givenInfiniteNumbersInStringThenReturnSum(){
        assertTrue(StringCalculator.add("2,2,2,2,2,2,2,2,2,2")==20);
    }

    @Test
    public void givenNewlineCharInStringThenAcceptAsDelimeterReturnSum(){
        assertTrue(StringCalculator.add("2\n2,2,2,2,2,2,2,2,2")==20);
    }

    @Test
    public void givenDifferentDelimiterInFirstLineThenChangeDelimiterReturnSum(){
        assertTrue(StringCalculator.add("//;\n1;2")==3);
    }

    @Test
    public void givenDifferentDelimiterLongerThen1CharInFirstLineThenChangeDelimiterReturnSum(){
        assertTrue(StringCalculator.add("//[*1*][%2%]\n1*1*2%2%3*1*4")==10);
    }

    @Test
    public void givenNumbersOver1000ThenIgnore(){
        assertTrue(StringCalculator.add("1001,2,3")==5);
    }

    @Test
    public void givenMultipleCustomDelimitersInTheFirstLineReturnSum(){
        assertTrue(StringCalculator.add("//[*][%]\n1*2%3")==6);
    }

    @Test
    public void givenNegativeNumbersInStringThenThrowException(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("negatives not allowed -2 -3");
        StringCalculator.add("-2,-3");
    }
}