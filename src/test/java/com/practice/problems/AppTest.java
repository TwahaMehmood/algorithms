package com.practice.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{


    /**
     * Rigourous Test :-)
     */
    @DisplayName("Test MessageService.get()")
    @Test
    public void testPalindromeSums()
    {
        assertEquals(540, PalindromeSum.sumPalindromes(100));
        assertEquals(45, PalindromeSum.sumPalindromes(10));
    }
}
