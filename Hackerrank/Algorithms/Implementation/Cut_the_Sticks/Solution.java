import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static void cutTheSticks( Integer[] arr ) {
        PriorityQueue<Integer> sticks = new PriorityQueue( arr.length );
        sticks.addAll( Arrays.asList( arr ) );
        
        while( !sticks.isEmpty() ) {
            System.out.println( sticks.size() );
            int min = sticks.peek();
            sticks.removeIf( i -> i == min );
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        Integer[] arr = new Integer[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        cutTheSticks(arr);

        scanner.close();
    }
}
