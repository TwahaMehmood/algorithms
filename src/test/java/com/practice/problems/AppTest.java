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
    //@Test
    public void testPalindromeSums()
    {
        assertEquals(540, PalindromeSum.sumPalindromes(100));
        assertEquals(45, PalindromeSum.sumPalindromes(10));
    }
    
    /**
     * Rigourous Test :-)
     */
    @DisplayName("Test MessageService.get()")
    @Test
    public void testMakeChange()
    {
       assertEquals(4, CoinChangeProblem.makeChange(new Long[] {3L ,2L , 1L}, 4));
        //assertEquals(2, CoinChangeProblem.makeChange(new Long[] {3L , 12L }, 15));
    }
    
}
