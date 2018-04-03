import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int theLoveLetterMystery( String s ){
        char[] c = s.toCharArray();
        int len = c.length/2;
        int numEdits = 0;
        for( int i=0; i<len; i++ ) {
            numEdits += Math.abs( (int)(c[i]-c[c.length-1-i]) );
        }
        return numEdits;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = theLoveLetterMystery(s);
            System.out.println(result);
        }
    }
}
