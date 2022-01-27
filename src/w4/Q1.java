package w4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1 { // https://www.acmicpc.net/problem/1717

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        // n+1개의 집합을 이룸
        // 0 a b : 합집합, 1 a c : 같은 집합에 포함? (두 수는 같을 수도 있다)
        // p : 루트 노드의 번호를 갖고 있다. 루트 노드는 -1을 갖는다.
        // 합집합 : 한 쪽의 루트 노드를 다른 쪽의 루트 노드로 한다.
        // 같은 집합? : 루트 노드가 같은지 보면 됨
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for(int i = 0; i < n+1; i++) {
            parent[i] = -1;
        }

        int op = 0, a = 0, b = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            op = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(op == 0) {
                union(a,b);
            }
            else {
                sb.append(find(a)==find(b) ? "YES\n" : "NO\n");
            }
        }

        System.out.println(sb);
    }

    private static int find(int n) {
        if(parent[n] < 0) {
            return n;
        }
        parent[n] = find(parent[n]);
        return parent[n];
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a == b) {
            return;
        }
        if(parent[a] < parent[b]) { // a가 루트인 집합의 크기가 더 큼
            parent[a] += parent[b];
            parent[b] = a;
        }
        else {
            parent[b] += parent[a];
            parent[a] = b;
        }
    }
}
