import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        int numCases = sc.nextInt();
        
        while( numCases-- > 0 ) {
            double a = sc.nextInt();
            double b = sc.nextInt();
            int count = (int)Math.floor( Math.sqrt(b) ) - (int)Math.ceil( Math.sqrt(a) ) + 1; 
            System.out.println( count );
        }
    }
}
