import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int maxScoreOfVincent( int n, String s, String t ) {
        int maxScore = 0;
        for( int i=0; i<n; i++ ) {
            if( s.charAt(i) != t.charAt(i) && s.charAt(i) != '.' ) {
                maxScore++;
            }
        }
        return maxScore;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //  Return the maximum score of Vincent.
        int n = in.nextInt();
        String s = in.next();
        String t = in.next();
        int result = maxScoreOfVincent(n, s, t);
        System.out.println(result);
    }
}
