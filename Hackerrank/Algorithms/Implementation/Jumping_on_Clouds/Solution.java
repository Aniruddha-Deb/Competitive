import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        
        int numJumps = 0;
        for( int i=0; i<n-1; ) {
            // endgame scenario
            if( c[i+1] == 0 && i+1==n-1 ) {
                numJumps++;
                break;
            }
            // double jump
            else if( c[i+1] == 0 && c[i+2] == 0 ) {
                numJumps++;
                i += 2;
            }
            // thundercloud 2 steps ahead
            else if( c[i+1] == 0 && c[i+2] == 1 ) {
                numJumps++;
                i += 1;
            }
            // jump over thundercloud
            else if( c[i+1] == 1 && c[i+2] == 0 ) {
                numJumps++;
                i += 2;
            }
        }
        System.out.println( numJumps );
    }
}
