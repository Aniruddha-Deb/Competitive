import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner( System.in );
        int numChars = sc.nextInt();
        sc.nextLine();
        String steps = sc.nextLine();
        
        int numValleys = 0;
        int currLevel = 0;
        for( int i=0; i<numChars; i++ ) {
            char c = steps.charAt( i );
            if( c == 'D' ) {
                currLevel--;
            }
            else {
                currLevel++;
            }
            
            if( currLevel == 0 && c == 'U' ) {
                numValleys++;
            }
        }
        
        System.out.println( numValleys );
    }
}
