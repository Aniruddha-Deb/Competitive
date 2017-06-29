import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int migratoryBirds(int n, int[] ar) {
        int[] numBirds = new int[5];
        for( int i=0; i<n; i++ ) {
            numBirds[ar[i]-1]++;
        }
        
        int highest = numBirds[0];
        int highestIndex = 1;
        for( int i=1; i<5; i++ ) {
            if( numBirds[i] > highest ) {
                highest = numBirds[i];
                highestIndex = i+1;
            }
        }
        return highestIndex;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }
}
