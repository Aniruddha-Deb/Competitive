import java.util.*;
import java.text.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        
        Locale locale = new Locale( "en", "IN" );
        
        NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat in = NumberFormat.getCurrencyInstance(locale);
        NumberFormat ch = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat fr = NumberFormat.getCurrencyInstance(Locale.FRANCE);            
        
        System.out.println("US: " + us.format( payment ) );
        System.out.println("India: " + in.format( payment ) );
        System.out.println("China: " + ch.format( payment ) );
        System.out.println("France: " + fr.format( payment ) );
    }
}
