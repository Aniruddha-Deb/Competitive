import java.io.*;
import java.util.*;

public class Solution {

    public static void main( String[] args ) {
        Scanner sc = new Scanner( System.in );
        int base = sc.nextInt();
        for( int i=1; i<=base; i++ ) {
            for( int j=1; j<=base; j++ ) {
                if( i > (base-j) ) {
                    System.out.print( "#" );
                }
                else {
                    System.out.print( " " );
                }
            }
            System.out.println();
        }
    }
