import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static void main( String args[] ) throws Exception {
        Scanner sc = new Scanner( System.in );
        String input = sc.nextLine();
        
        String allChars = "abcdefghijklmnopqrstuvwxyz";
        boolean containsAllChars = true;
        
        for( int i=0; i<allChars.length(); i++ ) {
            String charUp = Character.toUpperCase( allChars.charAt(i) ) + "";
            String charDown = allChars.charAt(i) + "";
            
            if( !( input.contains( charUp ) || input.contains( charDown ) ) ) {
                containsAllChars = false;
                break;
            }
        }
        
        if( containsAllChars ) {
            System.out.println( "pangram" );
        }
        else {
            System.out.println( "not pangram" );
        }
    }
}
