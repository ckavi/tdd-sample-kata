package com.lcddigits;
import com.google.common.collect.ImmutableMap;

import java.util.Map;
import static com.lcddigits.ColumnChar.*;

public final class LcdDigits{

    private Map<Integer,ColumnChar[][]> numberNotationRows = ImmutableMap.<Integer,ColumnChar[][]>builder()
            .put(0,new ColumnChar[][]{ {DOT,UNDERSCORE,DOT},{DASH,DOT,DASH},{DASH,UNDERSCORE,DASH}})
            .put(1,new ColumnChar[][]{ {DOT,DOT,DOT},{DOT,DOT,DASH},{DOT,DOT,DASH}})
            .put(2,new ColumnChar[][]{ {DOT,UNDERSCORE,DOT},{DOT,UNDERSCORE,DASH},{DASH,UNDERSCORE,DOT}})
            .put(3,new ColumnChar[][]{ {DOT,UNDERSCORE,DOT},{DOT,UNDERSCORE,DASH},{DOT,UNDERSCORE,DASH}})
            .put(4,new ColumnChar[][]{ {DOT,DOT,DOT},{DASH,UNDERSCORE,DASH},{DOT,DOT,DASH}})
            .put(5,new ColumnChar[][]{ {DOT,UNDERSCORE,DOT},{DASH,UNDERSCORE,DOT},{DOT,UNDERSCORE,DASH}})
            .put(6,new ColumnChar[][]{ {DOT,UNDERSCORE,DOT},{DASH,UNDERSCORE,DOT},{DASH,UNDERSCORE,DASH}})
            .put(7,new ColumnChar[][]{ {DOT,UNDERSCORE,DOT},{DOT,DOT,DASH},{DOT,DOT,DASH}})
            .put(8,new ColumnChar[][]{ {DOT,UNDERSCORE,DOT},{DASH,UNDERSCORE,DASH},{DASH,UNDERSCORE,DASH}})
            .put(9,new ColumnChar[][]{ {DOT,UNDERSCORE,DOT},{DASH,UNDERSCORE,DASH},{DOT,DOT,DASH}})
            .build();

    public String print(int number) {

        StringBuilder sb = new StringBuilder();
        int[] digits = extractDigits(number);

        for(int r =0; r<3;r++){
            for(int digit : digits){
                for(ColumnChar columnChar:numberNotationRows.get(digit)[r]){
                    sb.append(columnChar.character);
                }
            }
            sb.append("\n");
        }

        return sb.substring(0,sb.length()-1);
    }

    private int[] extractDigits(int number){

         String[] digitsStr = String.valueOf(number).split("");
         int[] digits =new int[digitsStr.length];

            for(int n=0;n<digitsStr.length;n++){
                digits[n]=Integer.valueOf(digitsStr[n]);
            }
        return digits;
    }
}
