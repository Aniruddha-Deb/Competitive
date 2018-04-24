import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    static void averageOfTopEmployees(int[] rating) {
        double sum = 0;
        double ne = 0;
        for( int i : rating ) {
            if( i >= 90 ) {
                sum += i;
                ne++;
            }
        }
        System.out.printf( "%.2f", (sum/ne) );
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] rating = new int[n];

        for (int ratingItr = 0; ratingItr < n; ratingItr++) {
            int ratingItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            rating[ratingItr] = ratingItem;
        }

        averageOfTopEmployees(rating);

        scanner.close();
    }
}
