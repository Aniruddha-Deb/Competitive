import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int minimumNumber(int n, String password) {        
        int minNum = 0;
        if( !password.matches( ".*[!@#$%\\^&\\*()\\-+].*" ) ) {
            minNum++;
        }
        if( !password.matches( ".*[A-Z].*" ) ) {
            minNum++;
        }
        if( !password.matches( ".*[a-z].*" ) ) {
            minNum++;
        }
        if( !password.matches( ".*[0-9].*" ) ) {
            minNum++;
        }
        if( n+minNum < 6 ) {
            minNum += 6-(n+minNum);
        }
        return minNum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String password = in.next();
        int answer = minimumNumber(n, password);
        System.out.println(answer);
        in.close();
    }
}
