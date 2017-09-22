import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        
        BigInteger int1 = new BigInteger( sc.nextLine() );
        BigInteger int2 = new BigInteger( sc.nextLine() );
        
        System.out.println( int1.add( int2 ) );
        System.out.println( int1.multiply( int2 ) );
    }
}
