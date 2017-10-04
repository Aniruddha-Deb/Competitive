import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        List<Integer> list = new ArrayList<>();
        int numElements = sc.nextInt();
        for( int i=0; i<numElements; i++ ) {
            list.add( sc.nextInt() );
        }
        
        int elem = sc.nextInt();
        for( int i=0; i<elem; i++ ) {
            if( sc.next().equals( "Insert" ) ) {
                list.add( sc.nextInt(), sc.nextInt() );
            }
            else {
                list.remove( sc.nextInt() );
            }
        }
        
        for( Integer i : list ) {
            System.out.print( i.intValue() + " " );
        }
        
    }
}
