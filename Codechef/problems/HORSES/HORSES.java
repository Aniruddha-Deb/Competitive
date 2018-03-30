import java.io.*;
import java.util.*;

class HORSES {

	public static void main( String args[] ) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		int numTestCases = Integer.parseInt( br.readLine() );

		while( numTestCases > 0 ) {
			int n = Integer.parseInt( br.readLine() );
            long[] S = new long[n];
            String[] str = br.readLine().split( "\\s+" );
            for( int i=0; i<n; i++ ) {
                S[i] = Long.parseLong( str[i] );
            }

            Arrays.sort( S );
            long minDiff = S[1]-S[0];
            for( int i=1; i<n-1; i++ ) {
                if( S[i+1]-S[i] < minDiff ) minDiff = S[i+1]-S[i];
            }
            System.out.println( minDiff );

			numTestCases--;
		}
	}
}
