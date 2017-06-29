import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        
        int numAlterations = 0;
        for( int i=0; i<S.length(); i+=3 ) {
            if( !( S.substring( i, i+3 ).equals( "SOS" ) ) ) {
                String examinationStr = S.substring( i, i+3 );
                if( examinationStr.charAt( 0 ) != 'S' ) {
                    numAlterations++;
                }
                if( examinationStr.charAt( 1 ) != 'O' ) {
                    numAlterations++;
                }
                if( examinationStr.charAt( 2 ) != 'S' ) {
                    numAlterations++;
                }
            }
        }
        
        System.out.println( numAlterations );
    }
}
