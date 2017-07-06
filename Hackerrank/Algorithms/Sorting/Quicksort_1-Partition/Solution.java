import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner( System.in );
    	int n = sc.nextInt();
    	int[] nums = new int[n];
    	for( int i=0; i<n; i++ ) {
    		nums[i] = sc.nextInt();
    	}
    	
    	int pivot = nums[0];
    	ArrayList<Integer> left = new ArrayList<>();
    	ArrayList<Integer> equal = new ArrayList<>();
    	ArrayList<Integer> right = new ArrayList<>();
    	
    	for( int i=0; i<n; i++ ) {
    		if( nums[i] < pivot ) {
    			left.add( nums[i] );
    		}
    		else if( nums[i] > pivot ) {
    			right.add( nums[i] );
    		}
    		else {
    			equal.add( nums[i] );
    		}
    	}    	
    	
    	printArray( left );
    	printArray( equal );
    	printArray( right );
    }
    
    static void printArray( List<Integer> a ) {
    	for( Integer i : a ) {
    		System.out.print( i.intValue() + " " );
    	}
    }
}
