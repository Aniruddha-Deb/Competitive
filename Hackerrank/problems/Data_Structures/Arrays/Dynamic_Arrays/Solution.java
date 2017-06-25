import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        int len = sc.nextInt();
        ArrayList<ArrayList<Integer>> seqList = new ArrayList<ArrayList<Integer>>(len);
        for( int i=0; i<len; i++ ) {
            seqList.add( new ArrayList<Integer>() );
        }
        
        int numQueries = sc.nextInt();
        int lastAnswer = 0;
        
        while( numQueries-- > 0 ) {
            int qType = sc.nextInt();
            int qArg1 = sc.nextInt();
            int qArg2 = sc.nextInt();
            ArrayList<Integer> seq = seqList.get( ((qArg1^lastAnswer)%len) );
            
            if( qType == 1 ) {
                seq.add( qArg2 );
            }
            else {
                lastAnswer = seq.get( qArg2 % seq.size() ).intValue();
                System.out.println( lastAnswer );
            }
        }
        
    }
}
