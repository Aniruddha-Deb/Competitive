import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String gridChallenge(String[] grid) {
        for( int i=0; i<grid.length; i++ ) {
            char[] c = grid[i].toCharArray();
            Arrays.sort( c ); 
            grid[i] = String.valueOf( c ); 
        }
        for( int i=0; i<grid.length; i++ ) {
            for( int j=0; j<grid.length-1; j++ ) {
                if( grid[j].charAt( i ) > grid[j+1].charAt(i) ) {
                    return "NO";
                }
            }
        }
        return "YES";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for( int i=0; i<t; i++ ) {
            int n = in.nextInt();
            String[] grid = new String[n];
            for(int grid_i = 0; grid_i < n; grid_i++){
                grid[grid_i] = in.next();
            }
            String result = gridChallenge(grid);
            System.out.println(result);
        }
        in.close();
    }
}
