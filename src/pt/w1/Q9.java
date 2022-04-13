package pt.w1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q9 { // https://www.acmicpc.net/problem/10799
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String polls = br.readLine();

        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < polls.length(); i++) {
            if(polls.charAt(i) == '(') {
                stack.push(polls.charAt(i));
            }
            else {
                stack.pop();
                // 처음에는 항상 '('로 시작하므로 i-1에서 범위를 벗어날 걱정은 덜었음
                if((polls.charAt(i-1) == polls.charAt(i)) && (polls.charAt(i) == ')')) {
                    answer++;
                }
                else {
                    answer += stack.size();
                }
            }
        }
        System.out.println(answer);
    }
}
