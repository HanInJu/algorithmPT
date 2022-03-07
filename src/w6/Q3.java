package w6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q3 {
    private static LinkedList<Integer>[] adj;
    private static boolean[] visited;
    private static boolean[] finished;
    private static int node;

    public static void main(String[] args) throws IOException {
        // dfs 돌면서 컴포넌트 개수 구하면 될 것 같은데
        // 순열사이클이 만들어졌는지 확인을 해야 할까?
        // 안전하게 검사하자
        // 방향그래프
        // 인접리스트로 구현한다.
        // 테케마다 초기화 잊지말자
        // 순열사이클 개수
        // 테케 개수
        // 순열 크기
        // 순열 (공백구분)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for(int i = 0; i<test; i++) {
            int cycle = 0;
            int n = Integer.parseInt(br.readLine());
            adj = new LinkedList[n+1];
            visited = new boolean[n+1];
            finished = new boolean[n+1];

            initList(adj);
            Arrays.fill(visited, false);
            Arrays.fill(finished, false);

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++) {
                int vertex = Integer.parseInt(st.nextToken());
                adj[j].add(vertex);
            }

            for(int j = 0; j<n; j++) {
                if(!visited[j]) {
                    dfs(j);
                    cycle++;
                }
            }

            System.out.println(cycle);

        }
    }

    private static void dfs(int x) {
        visited[x] = true;
        int next = adj[x].poll();
        if(visited[next]) {
            if(!finished[next]) {
                node++;
                for(int i = next; i != x; i = adj[i].poll()) {
                    node++;
                }
            }
        }
        else {
            dfs(next);
        }
        finished[x] = true;
    }

    private static void initList(LinkedList<Integer>[] adj) {
        for(int i = 0; i<adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }

}
