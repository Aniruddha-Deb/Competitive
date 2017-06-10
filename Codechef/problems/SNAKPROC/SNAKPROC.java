import java.io.*;

class SNAKPROC {

	public static void main( String args[] ) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		int numTestCases = Integer.parseInt( br.readLine() );

		while( numTestCases > 0 && numTestCases <= 500 ) {

			int numChars = Integer.parseInt( br.readLine() );
			
			String s = br.readLine();
			
			if( numChars > 500 || numChars < 1 ) {
				System.out.println( "Invalid" );
				continue;
			}

			boolean parsed = true;
			for( int i=0; i<numChars; i++ ) {
				try {
					if( s.charAt( i ) == 'H' ) {
						i++;
						while( s.charAt( i ) == '.' ) {
							i++;
						}
						if( s.charAt( i ) != 'T' ) {
							parsed = false;
						}
					}
					else if( s.charAt( i ) == 'T' ) {
						parsed = false;
						break;
					}
				} catch( StringIndexOutOfBoundsException e ) {
					parsed = false;
				}
			}
			
			if( parsed ) {
				System.out.println( "Valid" );
			}
			else {
				System.out.println( "Invalid" );
			}
			
			numTestCases--;
		}
	}
}
