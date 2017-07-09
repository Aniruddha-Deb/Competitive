import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        int n = sc.nextInt();
        int[] a = new int[n];
        
        for( int i=0; i<n; i++ ) {
            a[i] = sc.nextInt();
        }
        
        quickSort( a, 0, n-1 );
    }
    
    static void quickSort( int[] a, int low, int high ) {
        if( low < high ) {
            int pIndex = partition( a, low, high );
            
            quickSort( a, low, pIndex-1 );
            quickSort( a, pIndex+1, high );
        }
    }
    
    static void printArray( int[] a ) {
        for( int i : a ) {
            System.out.print( i + " " );
        }
        System.out.println();
    }
    
    static int partition( int[] arr, int low, int high ) {
        
        int pivot = arr[high];
        int i=low-1;
        
        for( int j=low; j<high; j++ ) {
            if( arr[j] < pivot ) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        
        printArray( arr );
        
        return i;
    }
}
