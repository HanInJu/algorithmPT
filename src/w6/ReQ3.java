package w6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReQ3 {
    private static int[] adj;
    private static boolean[] visited;
    private static boolean[] finished;

    public static void main(String[] args) throws IOException {
        // 인접행렬로 구현한다. 일차원으로도 충분
        // 정점이 1부터 주어지므로 저장할 때 -1하기
        // 테케
        // 순영크기
        // 순열(공백꾸분)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for(int t = 0; t<test; t++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            adj = new int[n];
            visited = new boolean[n];
            finished = new boolean[n];

            for(int i = 0; i<n; i++) {
                adj[i] = Integer.parseInt(st.nextToken()) - 1;
            }

            int component = 0;
            for(int i = 0; i<n; i++) {
                if(!visited[i]) {
                    dfs(i);
                    if(finished[i]) {
                        component++;
                    }
                }
            }

            System.out.println(component);
        }
    }

    public static void dfs(int x) {
        visited[x] = true;
        int next = adj[x];
        if(!visited[next]) {
            dfs(next);
        }
        finished[x] = true;
    }
}
