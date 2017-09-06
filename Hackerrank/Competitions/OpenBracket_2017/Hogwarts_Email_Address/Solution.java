import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String isValid(String email) {
        String parts[] = email.split( "@" );
        if( parts[0].length() != 5 ) {
            return "No";
        }
        for( int i=0; i<5; i++ ) {
            if( !( Character.isLowerCase( parts[0].charAt( i ) ) && Character.isAlphabetic( parts[0].charAt( i ) ) ) ) {
                return "No";
            }
        }
        if( !( parts[parts.length-1].equals( "hogwarts.com" ) ) ) {
            return "No";
        }
        return "Yes";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = isValid(s);
        System.out.println(result);
        in.close();
    }
}
