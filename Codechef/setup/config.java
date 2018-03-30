import java.io.*;
import java.util.*;

import static java.lang.Math.*;
import static java.lang.System.*;

class {

    static BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

    static int nextInt() throws IOException {
        return Integer.parseInt( br.readLine() );
    }

    static int[] nextIntArray() throws IOException {
        String[] s = br.readLine().split( "\\s+" );
        int[] x = new int[s.length];
        for( int i=0; i<s.length; i++ ) {
            x[i] = Integer.parseInt( s[i] );
        }
        return x;
    }
    
    static long nextLong() throws IOException {
        return Long.parseLong( br.readLine() );    
    }

    static long[] nextLongArray() throws IOException {
        String[] s = br.readLine().split( "\\s+" );
        long[] x = new long[s.length];
        for( int i=0; i<s.length; i++ ) {
            x[i] = Long.parseLong( s[i] );
        }
        return x;
    }
    
    public static void main( String args[] ) throws IOException {
        int numTestCases = nextInt();
        
        while( numTestCases > 0 ) {
            // write code here

            numTestCases--;
        }
    }
}
