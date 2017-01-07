package com.lcddigits;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cihan on 06/01/2017.
 */
public class LcdDigitsTest {

    private LcdDigits lcdDigits = new LcdDigits();

    private String[] numberNotations = new String[]{
            "._.\n"+
            "|.|\n"+
            "|_|",

            "...\n"+
            "..|\n"+
            "..|",

            "._.\n"+
            "._|\n"+
            "|_.",

            "._.\n"+
            "._|\n"+
            "._|",

            "...\n"+
            "|_|\n"+
            "..|",

            "._.\n"+
            "|_.\n"+
            "._|",

            "._.\n"+
            "|_.\n"+
            "|_|",

            "._.\n"+
            "..|\n"+
            "..|",

            "._.\n"+
            "|_|\n"+
            "|_|",

            "._.\n"+
            "|_|\n"+
            "..|"
    };

    @Test
    public void Print_Should_PrintDigitsOf0To9Correctly(){ //checking if numbers are printed correctly as single digit
        for (int i =0; i<=9; i++){
            assertEquals(String.format("Print for number %d is wrong",i),numberNotations[i], lcdDigits.print(i));
        }
    }

    @Test
    public void Print_Should_Print23Correctly(){ //checking if multiple digits are printed correctly
        String number23 =
                "._.._.\n"+
                "._|._|\n"+
                "|_.._|";

       assertEquals("Print for number 23 is wrong", number23,lcdDigits.print(23));
    }

    @Test
    public void Print_Should_Print123Correctly(){ //checking if multiple digits are printed correctly
        String number123 =
                "...._.._.\n"+
                "..|._|._|\n"+
                "..||_.._|";

        assertEquals("Print for number 123 is wrong", number123,lcdDigits.print(123));
    }

}