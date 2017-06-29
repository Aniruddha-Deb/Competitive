import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
                
            System.out.println("================================");
            for(int i=0;i<3;i++)
            {
                String language = sc.next();
                int number = sc.nextInt();
                if( number < 0 || number > 999 ) {
                    System.exit( -1 );
                }
                if( language.length() > 10 ) {
                    System.exit( -1 );
                }
                System.out.printf( "%-15s", language );
                System.out.printf( "%03d\n", number );
            }
            System.out.println("================================");

    }
}
