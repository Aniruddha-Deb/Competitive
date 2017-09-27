import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int numLists = sc.nextInt();
        for( int i=0; i<numLists; i++ ) {
            ArrayList<Integer> sublist = new ArrayList<>();
            int numInts = sc.nextInt();
            for( int j=0; j<numInts; j++ ) {
                sublist.add( sc.nextInt() );
            }
            list.add( sublist );
        }
        
        int numQueries = sc.nextInt();
        for( int i=0; i<numQueries; i++ ) {
            int list1 = sc.nextInt();
            int list2 = sc.nextInt();
            try {
                System.out.println( list.get( --list1 ).get( --list2 ) );
            } catch( Exception ex ) {
                System.out.println( "ERROR!" );
            }
        }
    }
}
