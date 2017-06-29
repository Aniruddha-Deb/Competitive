import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long max = 0;
        long min = Long.MAX_VALUE;
        long sum = 0;
        for( int arr_i=0; arr_i < 5; arr_i++ ){
            long in = sc.nextLong();
            if( in < min ) {
                min = in;
            }
            if( in > max ) {
                max = in;
            }
            sum += in;
        }
        
        System.out.println( (sum-max) + " " + (sum-min) );
    }
}
