import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        int len = sc.nextInt();
        double sumPos = 0;
        double sumNeg = 0;
        double sumZero = 0;
                
        for( int i=0; i<len; i++ ) {
            int num = sc.nextInt();
            if( num > 0 ) {
                sumPos++;
            }
            else if( num < 0 ) {
                sumNeg++;
            }
            else {
                sumZero++;
            }
        }
        
        System.out.println( (double)(sumPos/len) );
        System.out.println( (double)(sumNeg/len) );
        System.out.println( (double)(sumZero/len) );
        
    }
