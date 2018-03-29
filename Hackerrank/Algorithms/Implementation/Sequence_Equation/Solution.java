import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] permutationEquation(int[] p) {
        int[] y = new int[p.length];
        for( int x=1; x<=p.length; x++ ) {
            int i=1;
            for( ; i<=p.length; i++ ) {
                if( x == p[i-1] ) {
                    break;
                }
            }
            for( int j=1; j<=p.length; j++ ) {
                if( p[j-1] == i ) {
                    y[x-1] = j;
                }
            }
        }
        return y;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] p = new int[n];
        for(int p_i = 0; p_i < n; p_i++){
            p[p_i] = in.nextInt();
        }
        int[] result = permutationEquation(p);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}
