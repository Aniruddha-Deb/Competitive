import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            
            String hackerRank = "hackerrank";
            String formedRank = "";
            int currIndex = 0;
            for( int i=0; i<s.length() && currIndex<hackerRank.length(); i++ ) {                
                char c = s.charAt( i );
                if( hackerRank.charAt( currIndex ) == c ) {
                	formedRank += c;
                	currIndex++;
                }
            }
            
            if( formedRank.equals( hackerRank ) ) {
            	System.out.println( "YES" );
            }
            else {
            	System.out.println( "NO" );
            }
        }
    }
}
