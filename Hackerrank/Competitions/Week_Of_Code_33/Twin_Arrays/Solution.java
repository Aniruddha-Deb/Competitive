import java.util.Scanner;

public class Solution {

	public static void main( String[] args ) {
		
		Scanner sc = new Scanner( System.in );
		int lenOfArray = sc.nextInt();
		
		if( lenOfArray < 2 || lenOfArray > 100000 ) {
			System.exit( -1 );
		}
		
		int[] array1 = new int[lenOfArray];
		int[] array2 = new int[lenOfArray];
		int arrayMin1Index = 0;
		int arrayMin2Index = 0;
		
		for( int i=0; i<lenOfArray; i++ ) {
			int input = sc.nextInt();
			if( input < 1 || input > 100000 ) {
				System.exit( -1 );
			}
			if( array1[arrayMin1Index] > input ) {
				arrayMin1Index = i;
			}
			array1[i] = input;
		}

		for( int i=0; i<lenOfArray; i++ ) {
			int input = sc.nextInt();
			if( input < 1 || input > 100000 ) {
				System.exit( -1 );
			}
			if( array2[arrayMin2Index] > input ) {
				arrayMin2Index = i;
			}
			array2[i] = input;
		}
		
		if( arrayMin1Index == arrayMin2Index ) {
			int arr1min = Integer.MAX_VALUE;
			for( int i=0; i<lenOfArray; i++ ) {
				if( i == arrayMin1Index ) {
					continue;
				}
				else {
					if( array1[i] < arr1min ) {
						arr1min = array1[i];
					}
				}
			}
			int op1 = arr1min + array2[arrayMin2Index];
			
			int arr2min = Integer.MAX_VALUE;
			for( int i=0; i<lenOfArray; i++ ) {
				if( i == arrayMin2Index ) {
					continue;
				}
				else {
					if( array2[i] < arr2min ) {
						arr2min = array2[i];
					}
				}
			}
			int op2 = arr2min + array1[arrayMin2Index];
			if( op2 > op1 ) {
				System.out.println( op1 );
			}
			else {
				System.out.println( op2 );
			}
		}
		else {
			System.out.println( (array1[arrayMin1Index] + array2[arrayMin2Index]) );
		}
		
		sc.close();
	}
}
