import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] numNums = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            int numLow  = 0;
            int numHigh = 0;
            int numEqual = 0;
            for( int i=0; i<=a_i; i++ ) {
                if( a[i] == a[a_i] ) {
                    numEqual++;
                }
                else if( a[i] == a[a_i]-1 ) {
                    numLow++;
                }
                else if( a[i] == a[a_i]+1 ) {
                    numHigh++;
                }                
            }
            int lowSum = numLow + numEqual;
            int highSum = numHigh + numEqual;

            if( lowSum > highSum ) {
                numNums[a_i] = lowSum;
            }
            else {
                numNums[a_i] = highSum;
            }
        }        
        
        int max = 0;
        for( int i=0; i<n; i++ ) {
            if( numNums[i] > max ) {
                max = numNums[i];
            }
        }
        
        System.out.println( max );
    }
}
