package com.practice.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * A palindrome is a word, number, phrase, or other sequence of characters which
 * reads the same backward as forward, such as madam, racecar, or the number
 * 10801. What is the sum of all numeric palindromes that are less than 10,000?
 */

public class PalindromeSum
{
    private static final int[] digitsMap = { 10, 100, 1000, 10000, 100000, 1000000, 10000000 };

    /**
     * Sum all integer palindromes in given range.
     * 
     * @param range
     * @return sum on palindromes in range
     */
    public static long sumPalindromes(int range)
    {
        long sum = 0;
        int numberOfDigits = getDigits(range);
       
        for (int i = 1; i <= numberOfDigits; i++)
        {
            sum += getPalindromesOfDigits(i).stream().reduce(0, Integer::sum);
            System.out.println(i + " digits palindrome sum = " + sum);
        }

        return sum;
    }

    private static List<Integer> getPalindromesOfDigits(int numOfDgits)
    {
        List<Integer> retList = new ArrayList<>();
        if (numOfDgits == 0)
            return retList;

        if (numOfDgits == 1)
        {
            return Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        } 
        else if (numOfDgits == 2)
        {
            return IntStream.range(10, 100).filter((n) -> n % 11 == 0).boxed()
                    .collect(Collectors.toCollection(ArrayList::new));
        }
        else
        {
            int base = digitsMap[numOfDgits - 2];
            IntStream.range(1, 10).forEach((n) -> {
                List<Integer> list = getPalindromesOfDigits(numOfDgits - 2);
                for(int p : list) {
                    retList.add((n * base) + (p * (base/10)) + n);
                }
            });
        }
        return retList;
    }

    private static int getDigits(int num)
    {
        int numOfDigits = 1;
        for (int i = 0; i < digitsMap.length; i++)
        {
            if (num <= digitsMap[i])
            {
                numOfDigits = i + 1;
                break;
            }
        }
        return numOfDigits;
    }

    public static void main(String arg[])
    {
       System.out.println(sumPalindromes(1000));
    }
}
