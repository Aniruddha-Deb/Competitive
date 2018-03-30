import java.io.*;

class TEST {

	public static void main( String args[] ) throws IOException{
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		while( true ) {
			String x = br.readLine();
			if( x.equals( "42" ) ) {
				System.exit(0);
			}
			else {
				System.out.println( x );
			}
		}
	}
}
