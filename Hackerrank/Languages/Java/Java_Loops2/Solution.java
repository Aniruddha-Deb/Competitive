import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for( int x=0;x<t;x++ ){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            
            int sum = 0;
            int powSum = 0;
            for( int i=0; i<n; i++ ) {
                int pow = ((1 << i)*b);
                powSum += pow;
                System.out.print( (a + powSum) + " " );
            }
            System.out.println();
        }
        in.close();
    }
}
