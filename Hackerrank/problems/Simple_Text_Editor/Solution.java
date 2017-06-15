import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        
        String str = "";
        Stack<String> prevState = new Stack<String>();
        prevState.push( str );
        
        while( Q-- > 0 ) {
            int op = sc.nextInt();
            if( op == 1 ) {
                str += sc.next();               
                prevState.push( str );
            }
            else if( op == 2 || op == 3 ){
                int arg = sc.nextInt();
                if( op == 2 ) {
                    str = str.substring( 0, str.length()-arg ); 
                    prevState.push( str );
                }
                else if( op == 3 ) {
                    System.out.println( str.charAt( arg-1 ) );
                }
            }
            else {
                prevState.pop();
                str = prevState.peek();
            }
        }
        
    }
}