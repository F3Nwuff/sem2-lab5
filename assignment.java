import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class assignment {
    static int pre(char m)
    {
        return switch (m) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }
    static String postfix(String x)
    {
        String result = new String("");
        Deque<Character> stack = new ArrayDeque<Character>();
        for (int i = 0;i <x.length();++i) {
            char y = x.charAt(i);
            if (Character.isLetterOrDigit(y)) {
                result += y;
            }
            else if (y == '(') {
                stack.push(y);
            }
            else if (y == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.peek();
                    stack.pop();
                }
                stack.pop();
            }
            else
            {
                while (!stack.isEmpty() && pre(y) <= pre(stack.peek())) {
                    result += stack.peek();
                    stack.pop();
                }
                stack.push(y);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid";
            result += stack.peek();
            stack.pop();
        }
        return result;
    }
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("please input an infix ");
        String x = input.nextLine();
        if (x.isEmpty()){
            System.out.println("empty input ");
        }
        else{
            for (int i = 0;i <x.length();i++) {
                char z = x.charAt(i);
                if (z == '=') {
                    System.out.print("remove equal sign ");
                    break;
                }
                else if(i == x.length()-1) {
                    System.out.println("infix inputted :");
                    System.out.println(x);
                    System.out.println("postfix is :");
                    System.out.print(postfix(x));
                }
            }
        }
    }
}
