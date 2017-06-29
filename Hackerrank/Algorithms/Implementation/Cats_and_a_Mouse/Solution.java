import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            
            int numX = 0;
            if( x > z ) {
                for( ; x>=z; x-- ) {
                    numX++;
                }
            }
            else {
                for( ; x<=z; x++ ) {
                    numX++;
                }                
            }
            
            int numY = 0;
            if( y > z ) {
                for( ; y>=z; y-- ) {
                    numY++;
                }
            }
            else {
                for( ; y<=z; y++ ) {
                    numY++;
                }                
            }

            if( numX > numY ) {
                System.out.println( "Cat B" );
            }
            else if( numX < numY ) {
                System.out.println( "Cat A" );                
            }
            else {
                System.out.println( "Mouse C" );
            }
        }
    }
}
