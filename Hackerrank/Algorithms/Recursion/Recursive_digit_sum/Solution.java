import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        String arr[] = sc.nextLine().split("[ ]");
        int output = (Integer.parseInt(arr[1])*new BigInteger(arr[0]).remainder(new    BigInteger("9")).intValue())%9;
        System.out.println(output == 0 ? 9:output);
    } 
}
