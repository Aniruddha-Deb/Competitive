import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        StringBuffer b = new StringBuffer( A );
        if( b.reverse().toString().equals( A ) ) {
            System.out.println( "Yes" );
        }
        else {
            System.out.println( "No" );
        }
        
    }
}
