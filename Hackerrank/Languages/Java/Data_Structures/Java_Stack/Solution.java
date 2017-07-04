import java.util.Scanner;
import java.util.Stack;

class Solution {
    
    public static void main( String args[] ) {
        
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
             String input=sc.next();
             Stack<Character> stacky = new Stack<>();
             for (int i = 0; i < input.length(); i++) {
                if (!stacky.isEmpty()) {
                    switch(input.charAt(i)) {
                        case '}' : if (stacky.peek() == '{') {
                            stacky.pop();
                        } break;
                        case ']' : if (stacky.peek() == '[') {
                            stacky.pop();
                        } break;
                        case ')' : if (stacky.peek() == '(') {
                            stacky.pop();
                        } break;
                        default: stacky.push(input.charAt(i));
                  }
                } else {
                    stacky.push(input.charAt(i));
                } 
             }
             System.out.println(stacky.isEmpty());
          }
            }
        } 
