import java.io.*;
import java.util.*;

public class Solution {

    public static void main( String[] args ) {

        Scanner sc = new Scanner( System.in );
        int initialHeight = 1;

        int numCases = sc.nextInt();
        while( numCases-- > 0 ) {
            initialHeight = 1;
            int numCycles = sc.nextInt();
            for( int i=0; i<numCycles; i++ ) {
                if ( i%2 == 0 ) {
                    initialHeight *= 2;
                } 
                else {
                    initialHeight++;
                }
            }

            System.out.println( initialHeight );
        }
    }
}