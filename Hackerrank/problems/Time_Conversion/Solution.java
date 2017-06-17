import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static void timeConversion( String s ) {
        try {
            DateFormat df = new SimpleDateFormat("hh:mm:ssa");
            DateFormat out = new SimpleDateFormat("HH:mm:ss");
            Date date = df.parse(s);
            System.out.println(out.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        timeConversion(s);
    }
}

