import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
    	Scanner sc = new Scanner( System.in );
    	int num = sc.nextInt();
    	int numInts = sc.nextInt();    	
    	for( int i=0; i<numInts; i++ ) {
    		if( sc.nextInt() == num ) {
    			System.out.println( i );
    			System.exit( 1 );
    		}
    	}
    	
    }
}
