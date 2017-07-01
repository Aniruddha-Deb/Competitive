import java.util.Scanner;

public class Solution {

    public static void main( String args[] ) {

        Scanner sc = new Scanner( System.in );
        int numCases = sc.nextInt();

        while( numCases-- > 0 ) {
            int numStudents = sc.nextInt();
            int minStudents = sc.nextInt();
            int onTimeStudents = 0;
            for( int i=0; i<numStudents; i++ ) {
                int arrivalTime = sc.nextInt();
                if( arrivalTime <= 0 ) {
                    onTimeStudents++;
                }
            }
            if( onTimeStudents < minStudents ) {
                System.out.println( "YES" );
            }
            else {
                System.out.println( "NO" );
            }
        }
    }
}