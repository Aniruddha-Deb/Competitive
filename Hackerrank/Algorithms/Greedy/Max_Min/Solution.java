import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long angryChildren(int k, long[] a ) {
        Arrays.sort( a );
        long minDiff = Long.MAX_VALUE;
        for( int i=0; i<a.length-k+1; i++ ) {
            long min = a[i];
            long max = a[i+k-1];
            if( max-min < minDiff ) minDiff = max-min;
            if( minDiff == 0 ) return minDiff;
        }
        return minDiff;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        long[] arr = new long[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextLong();
        }
        long result = angryChildren(k, arr);
        System.out.println(result);
        in.close();
    }
}
