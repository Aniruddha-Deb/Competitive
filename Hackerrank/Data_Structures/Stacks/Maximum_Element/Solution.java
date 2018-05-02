import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class Solution {

    public static void main( String[] args ) {
        Scanner sc = new Scanner( System.in );
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        PriorityQueue<Integer> q = new PriorityQueue<>( (i1, i2) -> -Integer.compare( i1, i2 ) );
        int numQueries = sc.nextInt();
        
        while( numQueries-- > 0 ) {
            int query = sc.nextInt();
            
            if( query == 1 ) {
                int input = sc.nextInt();
                q.add( input );
                stack.push( input );                
            }
            else if( query == 2 ) {
                q.remove( stack.pop() );
            }
            else {
                System.out.println( q.peek() );
            }
        }        
    }
}
