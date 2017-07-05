import java.io.*;
import java.util.*;

public class Solution {

    public static void insertionSortPart2(int[] ar)
    {       
        int numShifts = 0;
        for( int i=1; i<ar.length; i++ ) {
            int key = ar[i];
            int j = i-1;
            boolean flip = ar[j] > key ? true : false;
            while( j >= 0 && ar[j] > key ) {
                ar[j+1] = ar[j];
                j--;
                if( flip == true ) {
                    numShifts++;
                }
            }
            ar[j+1] = key;
        }
        
        System.out.println( numShifts );
    }  
    
    
      
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       int s = in.nextInt();
       int[] ar = new int[s];
       for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
       }
       insertionSortPart2(ar);    
                    
    }    

}
