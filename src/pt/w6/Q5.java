package pt.w6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q5 {
    private static LinkedList<Integer>[] adj;
    private static boolean[] visited;
    private static int v;

    public static void main(String[] args) throws IOException {
        // dfs : 시작 점이 포함된 컴포넌트의 크기(노드 수) 구하기
        // 컴퓨터 1번부터 시작
        // 무조건 1번 컴퓨터가 감염
        // 1번부터 dfs 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        adj = new LinkedList[v];
        visited = new boolean[v];
        for(int i = 0; i<v; i++) {
            adj[i] = new LinkedList<>();
        }

        StringTokenizer st;
        for(int i = 0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            adj[x].add(y);
            adj[y].add(x);
        }

        System.out.println(dfs(0) - 1); // 자신을 포함하지 않음

    }

    public static int dfs(int x) {
        int node = 1;
        visited[x] = true;

        for(int next : adj[x]) {
            if(!visited[next]) {
                node += dfs(next);
            }
        }

        return node;
    }
}
