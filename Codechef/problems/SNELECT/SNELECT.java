import java.util.Scanner;

class SNELECT {

	public static void main( String args[] ) {
		Scanner sc = new Scanner( System.in );
		int numTestCases = sc.nextInt();
		sc.nextLine();

		while( numTestCases > 0 && numTestCases <= 100 ) {

			String in = sc.nextLine();
			char[] input = in.toCharArray();

			if( input.length < 1 || input.length > 100 ) {
				System.exit( -1 );
			}

			int numSnakes = 0;
			int numMongooses = 0;

			for( int i=0; i<input.length; i++ ) {
				if( input[i] == 'm' ) {
					numMongooses++;
				}
				else if( input[i] == 's' ) {
					numSnakes++;
				}
			}

			for( int i=0; i<input.length; i++ ) {
				char c = input[i];
				if( c == 'm' ) {
					try {
						if( i+1 < input.length && input[i+1] == 's' ) {
							numSnakes--;
							input[i+1] = '0';
						}	
						else if( i-1 >= 0 && input[i-1] == 's' ) {
							numSnakes--;
							input[i-1] = '0';
						}
					} catch( StringIndexOutOfBoundsException e ) {
						e.printStackTrace() ;
					}
				}
			}

			System.out.println(numMongooses);
			System.out.println(numSnakes);

			if( numMongooses > numSnakes ) {
				System.out.println( "mongooses" );
			}
			else if( numMongooses < numSnakes ) {
				System.out.println( "snakes" );
			}
			else {
				System.out.println( "tie" );
			}

			numTestCases--;
		}
		sc.close();
	}
}
