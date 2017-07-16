import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long saveThePrisoner(int n, int m, int s) {
        long poisoned = (s+m-1)%n;
        if( poisoned == 0 ) {
            poisoned = n;
        }
        return poisoned;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        int t = Integer.parseInt( br.readLine() );
        for(int a0 = 0; a0 < t; a0++){
            String[] parts = br.readLine().split( " " );
            int n = Integer.parseInt( parts[0] );
            int m = Integer.parseInt( parts[1] );
            int s = Integer.parseInt( parts[2] );
            long result = saveThePrisoner(n, m, s);
            System.out.println(result);
        }
    }
}
