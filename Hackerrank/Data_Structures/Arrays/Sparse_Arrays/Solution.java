import java.util.Scanner;

public class Solution {

    public static void main( String[] args ) {
        Scanner sc = new Scanner( System.in );
        int numStrings = sc.nextInt();
        sc.nextLine();
        
        String[] strCollection = new String[numStrings];
        for( int i=0; i<numStrings; i++ ) {
            strCollection[i] = sc.nextLine();
        }
        
        int numSearches = sc.nextInt();
        sc.nextLine();
        
        String[] strSearches = new String[numSearches];
        for( int i=0; i<numSearches; i++ ) {
            strSearches[i] = sc.nextLine();
        }
        
        for( String s : strSearches ) {
            int numMatches = 0;
            for( String str : strCollection ) {
                if( str.equals( s ) ) {
                    numMatches++;
                }
            }
            System.out.println( numMatches );
        }
        sc.close();
    }
}
