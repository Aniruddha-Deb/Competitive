import java.io.*;
import java.security.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner( System.in );
        MessageDigest m = MessageDigest.getInstance( "SHA-256" );
        m.reset();
        m.update( sc.nextLine().getBytes() );
        for( byte i : m.digest() ) {
            System.out.print( String.format( "%02x", i ) );
        }
        System.out.println();    
    }
}
