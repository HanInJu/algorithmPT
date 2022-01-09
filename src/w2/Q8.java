package w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q8 { // https://www.acmicpc.net/problem/1662

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int answer = 0;

        Stack<String> lengthStack = new Stack<>();
        for(int i = 0; i<str.length(); i++) {
            char arg = str.charAt(i);

            if(arg == ')') {
                int length = 0;
                while(!lengthStack.peek().equals("(")) {
                    String value = lengthStack.pop();
                    if(value.equals("-")) {
                        int beforeLength = Integer.parseInt(lengthStack.pop());
                        length += beforeLength;
                    }
                    else {
                        length++;
                    }
                }
                lengthStack.pop(); // 여는 괄호 ( 꺼냄
                int multipleNum = Integer.parseInt(lengthStack.pop()); // 곱해야 할 수 꺼냄
                lengthStack.add(String.valueOf(multipleNum * length)); // 길이 넣음
                lengthStack.add("-"); // 구분자 넣음
            }
            else {
                lengthStack.add(String.valueOf(arg));
            }

        }

        while(!lengthStack.isEmpty()) {
            String out = lengthStack.pop();
            if(out.equals("-")) {
                answer += Integer.parseInt(lengthStack.pop());
            }
            else {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
