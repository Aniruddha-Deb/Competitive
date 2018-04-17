import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static List<Integer> closestNumbers(int[] arr) {
        Arrays.sort( arr );
        List<Integer> pairs = new ArrayList<>();
        
        int mDiff = arr[0]-arr[1];
        for( int i=1; i<arr.length-1; i++ ) {
            if( arr[i]-arr[i+1] > mDiff ) mDiff = arr[i]-arr[i+1];
        }
        
        for( int i=0; i<arr.length-1; i++ ) {
            if( arr[i]-arr[i+1] == mDiff ) {
                pairs.add( arr[i] );
                pairs.add( arr[i+1] );
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        List<Integer> result = closestNumbers(arr);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + (i != result.size() - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
