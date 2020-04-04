package com.practice.problems;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'getWays' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. LONG_INTEGER_ARRAY c
     */
   
    public static long getWays(int n, List<Long> c, int index) {
        long ways = 0;
        
        if(n == 0) return 1;
        
        if(n < 0) return  0;
        
        for(int i = index; i < c.size(); i++) {
            long element = c.get(i);
            long intermediateWays = getWays((int)(n - element), c, i);
            ways += intermediateWays;
        }   

        return ways; 
    }
    
    public static long getWays(int n, List<Long> c) {
        //        return getWays((int) n, c, 0);
        return makeChange(c.toArray(new Long[0]), n);
    }
    
    public static long makeChange(Long[] coins, int money) {
        long[] DP = new long[money + 1]; // O(N) space.
        DP[0] = (long) 1;   // n == 0 case.
        for(long coin : coins) {
            for(int j = (int)coin; j < DP.length; j++) {
                System.out.println(j + " " + Arrays.toString(DP));
            // The only tricky step.
                long a = DP[j];
                long b = DP[j-(int)coin];
                DP[j] += DP[j - (int)coin];
            }
        }       
        
        return DP[money];
    }
}

public class CoinChangeProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("CoinChange.txt"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Long> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
//        Result.initWaysMap(c);
        long ways = Result.getWays(n, c);
        System.out.println("RESULT = " + ways);
        bufferedWriter.write(String.valueOf(ways));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
    
    public static long makeChange(Long[] coins, int money) {
        long[] DP = new long[money + 1]; // O(N) space.
        DP[0] = (long) 1;   // n == 0 case.
        for(long coin : coins) {
            for(int j = (int)coin; j < DP.length; j++) {
            // The only tricky step.
                long a = DP[j];
                long b = DP[j-(int)coin];
                DP[j] += DP[j - (int)coin];
                System.out.println(j + " " + Arrays.toString(DP));
            }
            System.out.println();
        }       
        System.out.println("RESULT " + DP[money]);
        return DP[money];
    }
}
