import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int wordCount = 1;
        for( char c : s.toCharArray() ) {
            if( Character.isUpperCase( c ) ) {
                wordCount++;
            }
        }
        
        System.out.println( wordCount );
    }
}
