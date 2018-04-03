import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int gemstones(String[] arr) {
        
        int[] charMap = new int[26];
        
        for( int i=0; i<arr.length; i++ ) {
            String s = arr[i];
            boolean[] visitedChars = new boolean[26];
            for( int j=0; j<s.length(); j++ ) {
                int c = s.charAt(j)-97;
                if( visitedChars[c] == false ) {
                    charMap[c]++;
                    visitedChars[c] = true;
                }
            }
        }
        
        int numGemstones = 0;
        for( int i=0; i<26; i++ ) {
            if( charMap[i] == arr.length ) numGemstones++;
        }
        return numGemstones;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arr = new String[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.next();
        }
        int result = gemstones(arr);
        System.out.println(result);
    }
}
