package com.neosoft.docker.dockerspringboot;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author mkarki
 */
public class AmexTest {
    /**
     * Given a string, find a longest repeating non-overlapping substring
     * <p>
     * maaaaane -> aa
     * abacba -> ba
     * <p>
     * ab, ba, ac, cb, ba
     * aba, bac, acb,cba
     * abac, bacb, acba
     * abacb, bacba
     * <p>
     * <p>
     * algorithm:
     * -> get the combination of 2 to n sized sequential sub-string
     * -> add them to list
     * -> count the occurrences of each unique sub-string
     * -> find the longest repeating one
     */
    public static String longestRepeatingSubString(String input) {
        if (input == null) {
            throw new IllegalArgumentException("The input param cannot be null");
        }
        List<List<String>> subStringCombinations = new ArrayList<>();
        //get the list of all the sequential sub-string of size s where 2 <= s <= n
        IntStream.range(2, input.length() + 1).forEach(i -> subStringCombinations.add(getPerm(i, input)));
        //create a structure to hold the count of all occurring string
        Map<String, Long> countCache = subStringCombinations
                .stream()
                .flatMap(e -> e.stream())
                .collect(groupingBy(Function.identity(), Collectors.counting()));
        //find the max count
        long max = Collections.max(countCache.entrySet(), Map.Entry.comparingByValue()).getValue();
        //filter the max count, if the count is same return the one with the maximum length
        return countCache.entrySet()
                .stream()
                .filter(e -> e.getValue() == max)
                .max(Comparator.comparingInt(o -> o.getKey().length()))
                .get()
                .getKey();
    }

    private static List<String> getPerm(int len, String input) {
        List<String> retList = new ArrayList<>();
        IntStream.range(0, input.length())
                .forEach(i -> {
                    if ((len + i) <= input.length()) {
                        retList.add(input.substring(i, i + len));
                    }
                });
        return retList;
    }

    @Test
    public void testLongestRepeatingSubstring() {
        assertTrue(longestRepeatingSubString("abcaba").equals("ab"));
        assertEquals(longestRepeatingSubString("mammammam"), "mam");
        assertEquals(longestRepeatingSubString("babaa"),"ba");
        assertEquals(longestRepeatingSubString("manish"), "manish");
    }

    @Test
    public void random() {
        Long userId = get();
        System.out.println(userId);
    }

    private Long get() {
        Long leftLimit = 1L;
        Long rightLimit = 2000L;
        int offset = "manish".chars()
                .sum();
        return (leftLimit + (long)(Math.random() *(offset + rightLimit - leftLimit)));
    }

}
