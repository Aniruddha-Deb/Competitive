import java.util.*;
import java.io.*;

class Solution{
    
    public static void main( String[] args ) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Map<String, String> phoneBook = new HashMap<>();
        for( int i=0; i<n; i++ ) {
            String name = sc.nextLine();
            String number = sc.nextLine();
            phoneBook.put( name, number );
        }
        
        for( int i=0; i<n; i++ ) {
            String key = sc.nextLine();
            String number = phoneBook.get( key );
            if( number == null ) {
                System.out.println( "Not found" );
            }
            else {
                System.out.println( key + "=" + number );
            }
        }
    }
}
