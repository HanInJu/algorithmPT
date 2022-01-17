package w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q2 { // https://www.acmicpc.net/problem/15903
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numOfCard = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> cards = new PriorityQueue<>();
        for(int i = 0; i<numOfCard; i++) {
            cards.add(Long.parseLong(st.nextToken()));
        }

        while(n > 0) {
            if(!cards.isEmpty()) {
                long first = cards.poll();
                long second = cards.poll();
                long addValue = first + second;
                cards.add(addValue);
                cards.add(addValue);
            }
            n--;
        }

        long answer = 0;
        while(!cards.isEmpty()) {
            answer += cards.poll();
        }

        System.out.println(answer);
    }
}
