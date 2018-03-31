import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long repeatedString(String s, long n) {
        long numa = 0;
        for( char c : s.toCharArray() ) {
            if( c == 'a' ) {
                numa++;
            }
        }
        numa *= n/s.length();
        long mod = n%s.length();
        for( long i=0; i<mod; i++ ) {
            if( s.charAt( (int)i ) == 'a' ) {
                numa++;  
            }
        }
        
        return numa;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();
        long result = repeatedString(s, n);
        System.out.println(result);
        in.close();
    }
}
