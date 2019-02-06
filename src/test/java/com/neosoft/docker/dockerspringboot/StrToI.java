package com.neosoft.docker.dockerspringboot;

import org.junit.Test;

import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author mkarki
 */
public class StrToI {
    private static final String regex = "^(?![a-zA-z].*$).*";

    public int myAtoi(String str) {
        str = Pattern.matches(regex, str) ? str.replaceAll("[a-zA-z]", "") : "0";
        try{
            return Integer.parseInt(str.trim());
        }catch (NumberFormatException nfe) {
            return Integer.MIN_VALUE;
        }
    }

    public int myAtoiSupplement(String str) {

        //check for nulls
        if(str == null) {
            return 0;
        }
        //remove leading and trailing white spaces
        str = str.trim();

        //false assume the number starts with a sign
        char signChar = str.charAt(0);
        int sign = 1, start = 0;
        //if the number wont start with any of the sign, Character.isDigit will still make sure of we only deal with
        //numbers and original start number the correct index
        if(signChar == '-') {
            sign = -1;
            start++;
        } else if(signChar =='+') {
            start++;
        }

        // as in the case of maximum, integer won't be able to hold
        long retVal = 0;
        for(int i = start; i < str.length(); i++) {
            if(!Character.isDigit(str.charAt(i))) {
                return sign == 1 ? (int)(retVal) : (int)-retVal;
            }
            retVal = retVal * 10 + str.charAt(i) - '0';
            if (sign == 1 && retVal > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign == -1 && (-1) * retVal < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }

        return (int)retVal * sign;

    }


    @Test
    public void testStringStartingWithNumbers() {
        String testNumber = "  -42 with words";

        assertThat(myAtoi(testNumber), is(equalTo(-42)));
        assertThat(myAtoiSupplement(testNumber), is(equalTo(-42)));
    }

    @Test
    public void testStringContainingOnlyNumbers() {
        String testNumber = "  -42 with words";

        assertThat(myAtoi(testNumber), is(equalTo(-42)));
        assertThat(myAtoiSupplement(testNumber), is(equalTo(-42)));
    }

    @Test
    public void testStringStartsWithAlphabet() {
        String testNumber = "words and 987";

        assertThat(myAtoi(testNumber), is(equalTo(0)));
        assertThat(myAtoiSupplement(testNumber), is(equalTo(0)));
    }

    @Test
    public void testNumberIsOutOfRange() {
        String testNumber = "-91283472332";

        assertThat(myAtoi(testNumber), is(equalTo(Integer.MIN_VALUE)));
        assertThat(myAtoiSupplement(testNumber), is(equalTo(Integer.MIN_VALUE)));
    }

    @Test
    public void testNumber() {
        System.out.println(1 << 31 < Math.pow(2, 31));
    }
}
