import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int alternatingCharacters(String s){
        int numDeletions = 0;
        char prevChar = '\u0000';
        for( int i=0; i<s.length(); i++ ) {
            char c = s.charAt(i);
            if( prevChar == c ) numDeletions++;
            prevChar = c;
        }
        return numDeletions;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = alternatingCharacters(s);
            System.out.println(result);
        }
    }
}
