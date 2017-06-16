import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] solve( int[][] points ){
        int[] result = { 0, 0 };
        
        for( int i=0; i<3; i++ ) {
            int a = points[0][i];
            int b = points[1][i];
            if( a > b ) {
                result[0] += 1;
            }
            else if( a < b ) {
                result[1] += 1;            
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] points = new int[2][3];
        for( int i=0; i<2; i++ ) {
            for( int j=0; j<3; j++ ) {
                points[i][j] = in.nextInt();
            }
        }

        int[] result = solve( points );
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");
        

    }
}
