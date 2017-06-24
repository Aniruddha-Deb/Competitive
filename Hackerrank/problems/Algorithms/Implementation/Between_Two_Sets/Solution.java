import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int getTotalX( int[] a, int[] b ){
        ArrayList<Integer> exes = new ArrayList<Integer>();
        for( int i=1; i<=100; i++ ) {
            boolean fact = true;
            for( int y : b ) {
                if( y % i != 0 ) {
                    fact = false;
                }
            }
            
            if( fact ) {
                exes.add( i );
            }            
        }
        
        for( int c=0; c<exes.size(); c++ ) {
            Integer i = exes.get(c);
            boolean remove = false;
            for( int z : a ) {
                double zz = z+0.0d;
                if( i.intValue() % zz != 0.0d ) {
                    remove = true;
                }
            }
            if( remove ) {
                exes.remove( i );
                c--;
            }
        }
        
        return exes.size();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i=0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        
        int total = getTotalX(a, b);
        System.out.println(total);
    }
}
