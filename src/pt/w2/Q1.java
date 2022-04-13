package pt.w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q1 { // https://www.acmicpc.net/problem/12789

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int front = Integer.parseInt(br.readLine());

        Stack<Integer> leftSpace = new Stack<>();
        leftSpace.push(front+1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < front; i++) {
            int frontPerson = Integer.parseInt(st.nextToken());

            if(frontPerson == 1) {
                continue;
            }
            if(leftSpace.peek() < frontPerson) {
                break;
            }
            else {
                leftSpace.push(frontPerson);
            }
        }

        if(leftSpace.size() == front) {
            System.out.println("Nice");
        }
        else {
            System.out.println("Sad");
        }

    }
}
