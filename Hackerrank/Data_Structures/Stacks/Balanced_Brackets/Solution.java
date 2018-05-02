import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String isBalanced(String s) {
        Map<String, String> brackets = new HashMap<>();
        brackets.put( ")", "(" );
        brackets.put( "}", "{" );
        brackets.put( "]", "[" );
        
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] sarr = s.split( "" );
        for( String i : sarr ) {
            if( i.matches( "[\\[\\{\\(]" ) ) stack.push( i );
            else {
                if( stack.isEmpty() ) return "NO";
                else if( !stack.peek().equals( brackets.get( i ) ) ) {
                    return "NO";
                }
                else {
                    stack.pop();
                }
            }
        }
        if( stack.isEmpty() ) return "YES";
        else return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            String result = isBalanced(s);
            System.out.println(result);
        }
        in.close();
    }
}
