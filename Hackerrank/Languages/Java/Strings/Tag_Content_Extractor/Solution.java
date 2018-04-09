import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution{
   public static void main(String[] args){
      
      Scanner in = new Scanner(System.in);
      int testCases = Integer.parseInt(in.nextLine());
      while(testCases>0){
          String line = in.nextLine();
         
          boolean matched = false;
          Pattern p = Pattern.compile("<(.+)>([^<]+)</\\1>");
          Matcher m = p.matcher(line);

          while( m.find() ) {
              System.out.println( m.group(2) );
              matched = true;
          }
          
          if( !matched ) {
              System.out.println( "None" );
          }
          testCases--;
      }
   }
}
