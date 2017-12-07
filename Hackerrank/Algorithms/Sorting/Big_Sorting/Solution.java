import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<String> a = new ArrayList<>();
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            a.add( in.next() );
        }

        Collections.sort( a, (str1,str2) -> {
            if( str1.length() > str2.length() ) {
                return 1;
            }
            else if( str1.length() < str2.length() ) {
                return -1;
            }
            else {
                for( int i=0; i<str1.length(); i++ ) {
                    int ca = (int)str1.charAt( i );
                    int cb = (int)str2.charAt( i );
                    if( ca > cb ) {
                        return 1;
                    }
                    else if( ca < cb ) {
                        return -1;
                    }
                } 
            }
            return 0;            
        } );
        
        for( String s : a ) {
            System.out.println( s );
        }
    }    
}
