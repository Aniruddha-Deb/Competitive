import java.util.Scanner;

public class Solution {

	public static void main( String[] args ){
		
		Scanner sc = new Scanner( System.in );
		int numCases = sc.nextInt();
		sc.nextLine();
		
		while( numCases > 0 && numCases < 20 ) {
			String strToSearch = sc.nextLine();
			if( strToSearch.length() < 0 || strToSearch.length() > 2000 ) {
				System.exit( -1 );
			}
			
			int numExps=0;

			for( int i=0; i<strToSearch.length(); i++ ) {
				char c = strToSearch.charAt( i );
				if( !Character.isLetterOrDigit( c ) ) {
					System.exit( -1 );
				}
				if( c == '1' && i+1 < strToSearch.length() ) {
					i++;
					c = strToSearch.charAt( i );
					boolean tripped = false;
					while( c == '0' && i+1 < strToSearch.length() ) {
						i++;
						tripped = true;
						c = strToSearch.charAt( i );						
					}
					if( c == '1' ) {
						i--;
						if( tripped ) {							
							numExps++;
						}
					}
					
				}			
			}
	        
	        System.out.println( numExps );

	        numCases--;
		}
	}
}
