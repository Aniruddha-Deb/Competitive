import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        int numInputs = sc.nextInt();
        int[] input = new int[numInputs];
        int[] nums = new int[100];
        for( int i=0; i<numInputs; i++ ) {
            input[i] = sc.nextInt();
            nums[input[i]]++;
        }
        
        for( int i=0; i<numInputs; i++ ) {
            for( int j=0; j<nums[i]; j++ ) {
                System.out.print( i + " " );                
            }
        }
        System.out.println();
    }
}
