import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        int len = sc.nextInt();
        int[] a = new int[len];
        int[] frequency = new int[100];
        for( int i=0; i<len; i++ ) {
            a[i] = sc.nextInt();
            frequency[a[i]-1]++;
        }

        int maxFreq = 0;
        int sumFreq = 0;
        for( int i=0; i<100; i++ ) {
            if( frequency[i] > maxFreq ) {
                maxFreq = frequency[i];
            }
            sumFreq += frequency[i];
        }
        
        System.out.println( sumFreq - maxFreq );
    }
}
