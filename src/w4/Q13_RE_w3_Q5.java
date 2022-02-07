package w4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q13_RE_w3_Q5 { // https://www.acmicpc.net/problem/1966
    static class Docs {
        private int order;
        private int priority;

        public Docs(int o, int p) {
            this.order = o;
            this.priority = p;
        }
    }
    public static void main(String[] args) throws IOException {
        // 중요도가 높은 파일이 하나라도 있으면 뒤로 -> 가장 중요도가 높은 파일부터 인쇄된다
        // 우선순위 큐 하나와 일반 큐 하나로 풀어야 한다.
        // 6 0
        // 1 1 9 1 1 1 - 1 9 1 1 1 1 - 9 1 1 1 1 1
        // 일반 큐 : 선입선출
        // 우선순위 큐 : 최소 힙, 루트가 가장 작은 것
        // 일반 큐와 우선순위 큐에 다 넣은 뒤 일반 큐에서 빼면서 비교, 아니면 뒤로 다시 넣는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int answer = 0;

        Queue<Docs> queue = new LinkedList<>();
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int docs = Integer.parseInt(st.nextToken());
            int question = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<docs; j++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.offer(new Docs(j, priority));
                pQ.offer(priority);
            }

            while(!queue.isEmpty()) {
                Docs current = queue.poll();
                int qCurrent = pQ.poll();

                if(current.priority < qCurrent) {
                    queue.offer(current);
                    pQ.offer(qCurrent);
                }
                answer++;
                if(current.order == question) {
                    break;
                }
            }
            System.out.println(answer);
        }
    }
}
