import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int solve(int n, int p){

        int minPagesFromFront = 0;
        int minPagesFromBack = 0;        
        
        for( int i=1; i<=n; i+=2 ) {
            if( i == p || i-1 == p ) {
                break;
            }
            minPagesFromFront++;
        }
        if( n%2 == 0 ) {
            for( int i=n; i>0; i-=2 ) {
                if( i == p || i+1 == p ) {
                    break;
                }
                minPagesFromBack++;
            } 
        }
        else {
            for( int i=n; i>0; i-=2 ) {
                if( i == p || i-1 == p ) {
                    break;
                }
                minPagesFromBack++;
            } 
        }

        return minPagesFromBack < minPagesFromFront ? minPagesFromBack : minPagesFromFront;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int result = solve(n, p);
        System.out.println(result);
    }
}
