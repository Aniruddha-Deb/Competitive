import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String caesarCipher( String s, int k ) {
        String sb = "";
        int turns = k%26; // 26 letters in the alphabet
        for( int i=0; i<s.length(); i++ ) {
            char c = s.charAt( i );
            if( !Character.isLetter( c ) ) {
                sb += (char)c;
                continue;
            }
            int turnedChar = c+turns;
            if( Character.isLowerCase( c ) && turnedChar > 122 ) {
                turnedChar = 97+(turnedChar-123);
            }
            else if( Character.isUpperCase( c ) && turnedChar > 90 ) {
                turnedChar = 65+(turnedChar-91);
            }
            sb += (char)turnedChar;
        }
        return sb;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int k = in.nextInt();
        String result = caesarCipher(s, k);
        System.out.println(result);
        in.close();
    }
}
