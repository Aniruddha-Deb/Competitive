import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            int num = Integer.parseInt( s );
            int[] digits = new int[s.length()];
            
            int numDivisible = 0;
            for( int i=0; i<s.length(); i++ ) {
                digits[i] = Integer.parseInt( s.charAt(i)+"" );
                boolean b;
                try {
                    b = num % digits[i] == 0;
                }
                catch( Exception e ) {
                    b = false;
                }
                if( b ) {
                    numDivisible++;
                }
            }    
            
            System.out.println( numDivisible );
        }
    }
}
