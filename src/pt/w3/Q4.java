package pt.w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q4 { // https://www.acmicpc.net/problem/2075
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        PriorityQueue<Integer> nn = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++) {
                nn.add(Integer.parseInt(st.nextToken()));
            }
        }

        while(n > 1) {
            nn.poll();
            n--;
        }
        System.out.println(nn.poll());
    }
}
