import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        int in = sc.nextInt();
        BigInteger factorial = new BigInteger( "1" );
        
        for( int i=2; i<=in; i++ ) {
            factorial = factorial.multiply( BigInteger.valueOf( i ) );
        }
        System.out.println( factorial.toString() );
    }
}
