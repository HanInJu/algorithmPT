package pt.w1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q8 { // https://www.acmicpc.net/problem/2164
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            que.add(i+1);
        }

        while(que.size() > 1) {
            que.poll(); //맨 위 한 장 버림
//            if(--n == 1) {
//                break;
//            }
            que.add(que.poll()); //버리고 난 뒤 맨 위 카드는 맨 뒤로 보냄
        }

        System.out.println(que.poll());
    }
}
