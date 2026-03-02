package gold;

import java.io.*;
import java.util.*;

public class Boj_2504_괄호의값 {

    static String line;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        line = br.readLine();

        Stack<Character> stack = new Stack<>();
        int result = 0;
        int temp = 1;
        boolean valid = true;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == '(') {
                temp *= 2;
                stack.push(c);
            } else if (c == '[') {
                temp *= 3;
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    valid = false;
                    break;
                }
                if (line.charAt(i - 1) == '(') {
                    result += temp;
                }
                stack.pop();
                temp /= 2;
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    valid = false;
                    break;
                }
                if (line.charAt(i - 1) == '[') {
                    result += temp;
                }
                stack.pop();
                temp /= 3;
            }
        }

        if (!valid || !stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}