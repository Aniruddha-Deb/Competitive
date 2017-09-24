import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        try {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            int quotient = num1/num2;
            System.out.println( quotient );
        } catch( InputMismatchException e ) {
            System.out.println( "java.util.InputMismatchException" );
        } catch( Exception ex ) {
            System.out.println( ex.toString() );
        }
    }
}
