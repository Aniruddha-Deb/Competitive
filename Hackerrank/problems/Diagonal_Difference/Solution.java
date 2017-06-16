import java.util.Scanner;

public class Solution {

	public static void main( String[] args ) {
		Scanner sc = new Scanner( System.in );
		int side = sc.nextInt();
		
		int[][] elements = new int[side][side];
		int d1sum = 0;
		int d2sum = 0;
		for( int i=0; i<side; i++ ) {
			for( int j=0; j<side; j++ ) {
				elements[i][j] = sc.nextInt();
				
				if( i == j ) {
					d1sum += elements[i][j];
                    // centre adds up to both d1 & d2
                    if( i+j == side-1 ) {
                        d2sum += elements[i][j];
                    }
				}
				else if( i == ((side-1)-j) ) {
					d2sum += elements[i][j];
				}
			}
		}
		
		int diff = Math.abs( d1sum - d2sum );
		System.out.println( diff );
		
	}
