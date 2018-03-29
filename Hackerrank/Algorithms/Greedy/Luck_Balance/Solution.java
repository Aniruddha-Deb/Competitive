import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int luckBalance(int n, int k, int[][] contests) {
        Arrays.sort( contests, (i1, i2) -> i1[0] > i2[0] ? -1 : (i1[0]==i2[0])?0:1 );
        int numImpCtstsLost = 0;
        int luck = 0;
        for( int[] a : contests ) {
            if( a[1] == 1 ) {
                // important contest
                if( numImpCtstsLost < k ) {
                    numImpCtstsLost++;
                    luck += a[0];
                }
                else {
                    luck -= a[0];
                }
            }
            else {
                luck += a[0];
            }
        }
        return luck;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] contests = new int[n][2];
        for(int contests_i = 0; contests_i < n; contests_i++){
            for(int contests_j = 0; contests_j < 2; contests_j++){
                contests[contests_i][contests_j] = in.nextInt();
            }
        }
        int result = luckBalance(n, k, contests);
        System.out.println(result);
        in.close();
    }
}
