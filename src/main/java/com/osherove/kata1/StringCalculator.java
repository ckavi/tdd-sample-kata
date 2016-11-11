package com.osherove.kata1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final Pattern SINGLE_DELIMETER_PATTERN = Pattern.compile("//(.*)\n(.*)");
    private static final Pattern MULTIPLE_DELIMETER_PATTERN = Pattern.compile("\\[([^\\]]+)\\]");
    private static final String[] EMPTY_STRING_ARRAY = new String[]{"0"};
    private static final String DEFAULT_DELIMITERS = "[,\n]";


    public static int add(String s) {

        String negative="";
        String[] nums = EMPTY_STRING_ARRAY;
        int result=0;
        Matcher m = SINGLE_DELIMETER_PATTERN.matcher(s);

        if(m.find()){
                String delimeter="";
                Matcher multipleMatcher = MULTIPLE_DELIMETER_PATTERN.matcher(m.group(1));

                while (multipleMatcher.find()){

                        if(!delimeter.isEmpty())
                            delimeter+="|";

                        delimeter+= Pattern.quote(multipleMatcher.group(1));
                }

                if(delimeter.isEmpty())
                    delimeter = m.group(1);

                nums = m.group(2).split(delimeter);
        }
        else if(!s.isEmpty()){
            nums = s.split(DEFAULT_DELIMITERS);
        }

        for (String num : nums){
            int number = Integer.parseInt(num);

            if(number<0){
                negative+=" "+num;
            }
            else if(negative.isEmpty() && number<=1000){
                result+= number;
            }
        }

        if(!negative.isEmpty()){
            throw new IllegalArgumentException("negatives not allowed"+negative);
        }
        else
            return result;
    }
}
