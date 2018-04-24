import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    static long maximumProgramValue(int n) {
        long x=0;
        
        while( n-- > 0 ) {
            String op = scanner.next();
            int i = scanner.nextInt();
            
            if( op.equals( "add" ) ) {
                if( i >= 0 ) x += i;
            }
            else if( op.equals( "set" ) ) {
                if( i >= x ) x = i;
            }
        }
        return x;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        long result = maximumProgramValue(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
