import java.util.Scanner;

public class COOK82A {

	public static void main( String args[] ) {
		Scanner sc = new Scanner( System.in );
		int numTestCases = sc.nextInt();
		sc.nextLine();

		while( numTestCases > 0 ) {
			int barca = 0;
			int real = 1;
			int malaga = 2;
			int eibar = 3;
			
			int[] goals = new int[4];
			
			// Barcelona <-> Eibar
			// Real Madrid <-> Malaga
			for( int i=0; i<4; i++ ) {
				String input = sc.nextLine();
				String parts[] = input.split( " " );
				if( input.startsWith( "Barcelona" ) ) {
					goals[barca] = Integer.parseInt( parts[1] );
				}
				else if( input.startsWith( "RealMadrid" ) ) {
					goals[real] = Integer.parseInt( parts[1] );
				}
				else if( input.startsWith( "Malaga" ) ) {
					goals[malaga] = Integer.parseInt( parts[1] );
				}
				else if( input.startsWith( "Eibar" ) ) {
					goals[eibar] = Integer.parseInt( parts[1] );
				}
			}
			
			// Error checking
			for( int i : goals ) {
				if( i > 20 || i < 0 ) {
					System.out.println( "Goals have to be less than 20!" );
					System.exit( -1 );
				}
			}
			
			if( goals[real] < goals[malaga] && goals[barca] > goals[eibar] ) {
				System.out.println( "Barcelona" );
			}
			else {
				System.out.println( "RealMadrid" );
			}
			
			numTestCases--;
		}
		sc.close();
	}
}
