package w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q7 { // https://www.acmicpc.net/problem/1935
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String exp = br.readLine();

        char start = 'A';
        Map<Character, Integer> map = new HashMap<>();
        while(n-- > 0) {
            map.put(start++, Integer.parseInt(br.readLine()));
        }

        Stack<String> stack = new Stack<>();
        for(int i = exp.length() - 1; i>=0; i--) {
            if(65 < exp.charAt(i) && exp.charAt(i) < 90) {
                int x = map.get(exp.charAt(i));
                int y = map.get(exp.charAt(i--));
                String operator = stack.pop();

                int value = 0;
                if(operator.equals("+")) {
                    value = x + y;
                }
                else if(operator.equals("-")) {
                    value = x - y;
                }
                else if(operator.equals("*")) {
                    value = x * y;
                }
                else if(operator.equals("/")) {
                    value = x / y;
                }

                stack.push(Integer.toString(value));
            }
            else {
                stack.push(String.valueOf(exp.charAt(i)));
            }
        }

    }
}
