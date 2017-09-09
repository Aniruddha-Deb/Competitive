import java.io.*;
import java.util.*;
public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine().trim();
        String[] tokens = s.split( "[!?,'@_. ]+" );
        if( s.length() == 0 ) {
            System.out.println( "0" );
        }
        else if( !( s.length() > 400000 ) ) {
            System.out.println( tokens.length );
            for( int i=0; i<tokens.length; i++ ) {
                System.out.println( tokens[i] );
            }
        }
        scan.close();
    }
}
