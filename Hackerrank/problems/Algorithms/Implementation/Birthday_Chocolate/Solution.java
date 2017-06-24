import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int solve(int n, int[] s, int d, int m) {
        
        int numTypes = 0;
        int squareSum = 0;
        for( int i=0; i<n; i++ ) {
            squareSum = s[i];
            int numPieces = 1;
            if( squareSum == d && numPieces == m ) {
                numTypes++;
                continue;
            }
            for( int j=i+1; j<n; j++ ) {
                squareSum += s[j];
                numPieces++;
                if( squareSum == d && numPieces == m ) {
                    numTypes++;
                    break;
                }
            }
        }
        
        return numTypes;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int d = in.nextInt();
        int m = in.nextInt();
        int result = solve(n, s, d, m);
        System.out.println(result);
    }
}
