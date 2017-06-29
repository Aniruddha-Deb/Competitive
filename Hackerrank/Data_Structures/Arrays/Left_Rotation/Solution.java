import java.util.Scanner;

public class Solution {

    public static void main( String[] args ) {
        Scanner sc = new Scanner( System.in );
        int n = sc.nextInt();
        int d = sc.nextInt();

        int[] a = new int[n];
        for( int i=0; i<n; i++ ) {
            a[i] = sc.nextInt();
        }
        
        for( int i=0; i<d; i++ ) {
            int popped = a[0];
            for( int j=0; j+1<n ; j++ ) {
                a[j] = a[j+1];
            }
            a[n-1] = popped;
        }
        
        for( int i=0; i<n; i++ ) {
            System.out.print( a[i] + " " );
        }
        
    }
}
