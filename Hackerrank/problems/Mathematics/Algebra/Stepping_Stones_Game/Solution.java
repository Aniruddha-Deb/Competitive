import java.io.*;
import java.util.*;

public class Solution {

    public static void main( String[] args ) {
        
        Scanner sc = new Scanner( System.in );
        long numGames = sc.nextLong();
        
        while( numGames > 0 && numGames <= 100000 ) {
            
            long block = sc.nextLong();
            if( block < 1 || block > Math.pow( 10, 18 ) ) {
                System.exit( -1 );
            }
            double determinant = Math.sqrt( 1 + (4*2*block) );
            if( ( determinant % 1.0d ) > 0 ) {
                System.out.println( "Better Luck Next Time" );
            }
            else {
                long ans = (long)( ( -1 + determinant ) / 2 );
                System.out.println( "Go On Bob " + ans );
            }
            
            numGames--;
        }
    }
}