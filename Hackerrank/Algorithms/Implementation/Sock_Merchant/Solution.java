package com.hackerrank.problems;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int sockMerchant(int n, int[] ar) {
        int numPairs = 0;
        
        for( int i=0; i<ar.length; i++ ) {
            int numI = ar[i];
            for( int j=i+1; j<ar.length; j++ ) {
                if( numI == ar[j] && ar[j] != 0 && numI != 0 ) {
                    numPairs++;
                    ar[j] = 0;
                    ar[i] = 0;
                    break;
                }
            }
        }
        
        return numPairs;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = sockMerchant(n, ar);
        System.out.println(result);
    }
}
