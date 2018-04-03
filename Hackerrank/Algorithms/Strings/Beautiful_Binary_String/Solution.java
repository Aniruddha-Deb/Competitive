import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int beautifulBinaryString( String b ) {
        char[] c = b.toCharArray();
        int numEdits = 0;
        for( int i=1; i<c.length-1; i++ ) {
            String substr = ""+c[i-1]+c[i]+c[i+1];
            if( substr.equals( "010" ) ) {
                // edit
                c[i+1] = '1';
                numEdits++;
            }
        }
        
        return numEdits;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String b = in.next();
        int result = beautifulBinaryString(b);
        System.out.println(result);
        in.close();
    }
}
