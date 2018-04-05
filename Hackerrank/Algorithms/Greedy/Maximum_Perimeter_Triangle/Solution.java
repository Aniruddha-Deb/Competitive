import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static void maximumPerimeterTriangle( int[] l ) {
        Arrays.sort( l );
        int[] tri = new int[3];
        long maxSum = -1;
        for( int i=l.length-1; i>=2; i-- ) {
            int s1 = l[i];
            int s2 = l[i-1];
            int s3 = l[i-2];
            if( (s1+s2)>s3 && (s2+s3)>s1 && (s3+s1)>s2 ) {
                tri[0] = s3;
                tri[1] = s2;
                tri[2] = s1;
                maxSum = s1+s2+s3;
                break;
            }
        }
        
        if( maxSum == -1 ) {
            System.out.println( "-1" );
        }
        else {
            System.out.println( tri[0] + " " + tri[1] + " " + tri[2] );
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] l = new int[n];
        for(int l_i = 0; l_i < n; l_i++){
            l[l_i] = in.nextInt();
        }
        maximumPerimeterTriangle(l);

        in.close();
    }
}
